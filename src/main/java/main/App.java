package main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import utils.Constants;

import java.net.URL;
import static javafx.application.Application.launch;
import org.jboss.logging.Logger;

public class App extends Application {
    
    private static final Logger LOG = Logger.getLogger(App.class);

    @Override
    public void start(Stage primaryStage) throws Exception {
        URL path = getClass().getResource(Constants.FXML_HOME);
        if (path != null) {
            Parent root = FXMLLoader.load(path);
            
            Scene scene = new Scene(root);
            scene.setFill(Color.TRANSPARENT);

            primaryStage.setTitle(Constants.APP_TITLE);
            primaryStage.setScene(scene);
            primaryStage.setResizable(false);
            primaryStage.setMaxWidth(775);
            primaryStage.setMaxHeight(600);
            primaryStage.show();
        } else {
            System.exit(-1);
            LOG.error("Sorry, the main fxml could not be loaded.");
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
