package controllers;

import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import entities.User;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import lombok.Setter;

/**
 * FXML Controller class
 *
 * @author Tony Manjarres
 */
public class CreateTaskController implements Initializable {

    @FXML
    private JFXTextField fieldTitle;

    @FXML
    private JFXTextArea fieldDescription;

    @FXML
    private JFXDatePicker fieldDate;
    
    @FXML
    private Label lblUser;
    
    //
    @Setter
    private User user;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        lblUser.setText(String.format("user: @%s", user.getUsername()));
    }

    @FXML
    void createTask(MouseEvent event) {
        
    }
    
}
