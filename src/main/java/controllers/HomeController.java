package controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import org.jboss.logging.Logger;

import utils.*;

/**
 *
 * @author Tony Manjarres
 */
public class HomeController implements Initializable {
    
    private static Logger LOG = Logger.getLogger(HomeController.class);

    @FXML
    private void addNewUser(MouseEvent event) {
        URL path = getClass().getResource(Constants.FXML_CREATE_USER);
        try {
            Parent root = FXMLLoader.load(path);
            Stage stage = new Stage();
            stage.setTitle("Create New User");
            stage.setResizable(false);
            stage.setScene(new Scene(root));
            stage.show();
        }
        catch (IOException e) {
            LOG.error("Not found: " + Constants.FXML_CREATE_USER);
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println("Home Controller!");
    }

}
