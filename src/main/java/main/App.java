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

public class App extends Application {

    private double xPos, yPos;

    @Override
    public void start(Stage primaryStage) throws Exception {
        URL path = getClass().getResource(Constants.FXML_HOME);
        if (path != null) {
            Parent root = FXMLLoader.load(path);
            root.setOnMousePressed((value) -> {
                xPos = value.getSceneX();
                yPos = value.getSceneY();
            });

            root.setOnMouseDragged((value) -> {
                primaryStage.setX(value.getScreenX() - xPos);
                primaryStage.setY(value.getScreenY() - yPos);
            });

            Scene scene = new Scene(root);
            scene.setFill(Color.TRANSPARENT);

            primaryStage.setTitle(Constants.APP_TITLE);
            primaryStage.setScene(scene);
            primaryStage.show();
        } else {
            System.exit(-1);
            System.err.println("Sorry, the main fxml could not be loaded.");
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
