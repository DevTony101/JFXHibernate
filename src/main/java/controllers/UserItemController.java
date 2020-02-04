package controllers;

import de.jensd.fx.glyphs.materialdesignicons.MaterialDesignIconView;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.paint.Paint;

import entities.User;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Tooltip;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import org.jboss.logging.Logger;
import utils.Constants;

/**
 * FXML Controller class
 *
 * @author Tony Manjarres
 */
public class UserItemController implements Initializable {
    
    private static final Logger LOG = Logger.getLogger(UserItemController.class);
    
    @FXML
    private MaterialDesignIconView mdCalendar;
    
    @FXML
    private Label lblName;
    
    @FXML
    private Label lblUsername;
    
    @FXML
    private Label lblTasks;

    //
    private User user;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // TODO
        mdCalendar.setOnMouseEntered(value -> {
            mdCalendar.setFill(Paint.valueOf("BLACK"));
        });
        
        mdCalendar.setOnMouseExited(value -> {
            mdCalendar.setFill(Paint.valueOf("LIGHTGRAY"));
        });
    }
    
    @FXML
    void addNewTask(MouseEvent event) {
        System.out.println("User id: " + user.getId());
        URL path = getClass().getResource(Constants.FXML_CREATE_TASK);
        try {
            FXMLLoader loader = new FXMLLoader(path);
            CreateTaskController controller = new CreateTaskController();
            controller.setUser(user);
            loader.setController(controller);
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setTitle("Create New Task");
            stage.setResizable(false);
            stage.setMaxWidth(405);
            stage.setMinHeight(240);
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            LOG.error("Not found: " + Constants.FXML_CREATE_TASK);
        }
    }
    
    void setUser(User user) {
        this.user = user;
        lblName.setText(String.format("%s %s", user.getFirstName(), user.getLastName()));
        lblName.setTooltip(new Tooltip(user.getCivilStatus()));
        lblUsername.setText("@" + user.getUsername());
        int numTasks = user.getTasks().size();
        if (numTasks > 0) {
            lblTasks.setText(String.format("This user has %d tasks", numTasks));
        }
    }
    
}
