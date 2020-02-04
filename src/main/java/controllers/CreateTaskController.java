package controllers;

import services.TaskService;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import entities.User;
import java.net.URL;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import lombok.Setter;
import services.UserService;

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
    private final UserService uService = UserService.getInstance();
    private final TaskService tService = TaskService.getInstance();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        lblUser.setText(String.format("user: @%s", user.getUsername()));
    }

    @FXML
    void createTask(MouseEvent event) {
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        String title = fieldTitle.getText().trim();
        String description = fieldDescription.getText().trim();
        LocalDate localDate = fieldDate.getValue();
        Instant instant = Instant.from(localDate.atStartOfDay(ZoneId.systemDefault()));
        Date deadline = Date.from(instant);
        tService.saveTask(title, description, deadline, user.getId());
        stage.close();
    }

}
