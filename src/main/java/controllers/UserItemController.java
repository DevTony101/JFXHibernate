package controllers;

import de.jensd.fx.glyphs.materialdesignicons.MaterialDesignIconView;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.paint.Paint;

import entities.User;
import javafx.scene.control.Label;
import javafx.scene.control.Tooltip;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author Tony Manjarres
 */
public class UserItemController implements Initializable {

    @FXML
    private MaterialDesignIconView mdCalendar;

    @FXML
    private Label lblName;

    @FXML
    private Label lblUsername;

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
    }

    void setUser(User user) {
        this.user = user;
        lblName.setText(String.format("%s %s", user.getFirstName(), user.getLastName()));
        lblName.setTooltip(new Tooltip(user.getCivilStatus()));
        lblUsername.setText("@" + user.getUsername());
    }

}
