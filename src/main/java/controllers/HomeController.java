package controllers;

import entities.User;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;
import org.jboss.logging.Logger;
import services.UserService;

import utils.*;

/**
 *
 * @author Tony Manjarres
 */
public class HomeController implements Initializable {

    private final static Logger LOG = Logger.getLogger(HomeController.class);

    @FXML
    private VBox vbUsers;

    //
    private final UserService uService = UserService.getInstance();
    private static int ogCount = 0; // Original count of rows in the table users

    @FXML
    private void addNewUser(MouseEvent event) {
        URL path = getClass().getResource(Constants.FXML_CREATE_USER);
        try {
            Parent root = FXMLLoader.load(path);
            Stage stage = new Stage();
            stage.setTitle("Create New User");
            stage.setResizable(false);
            stage.setMaxWidth(405);
            stage.setMinHeight(240);
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            LOG.error("Not found: " + Constants.FXML_CREATE_USER);
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println("Home Controller!");
        updateList();
    }

    public void updateList() {
        // Every 5 seconds
        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(5000), (event) -> {
            List<User> users = uService.getAllUsers();
            if (users.size() != ogCount) try {
                ogCount = users.size();
                vbUsers.getChildren().clear();
                for (User user : users) {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource(Constants.FXML_USER_ITEM));
                    UserItemController controller = new UserItemController();
                    loader.setController(controller);
                    vbUsers.getChildren().add(loader.load());
                    controller.setUser(user);
                }
            } catch (IOException e) {
                LOG.error("Error: " + e.getMessage());
            }
        }));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }

}
