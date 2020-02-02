package controllers;

import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import services.UserService;

/**
 * FXML Controller class
 *
 * @author Tony Manjarres
 */
public class CreateUserController implements Initializable {

    @FXML
    private JFXTextField fieldFName;

    @FXML
    private JFXTextField fieldLName;

    @FXML
    private JFXComboBox<String> cbCivilStatus;

    @FXML
    private JFXTextField fieldUsername;

    @FXML
    private JFXCheckBox cbAuto;
    
    //
    private final UserService uService = UserService.getInstance();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initComboBox();
        cbAuto.setOnAction(value -> {
            fieldUsername.setDisable(!fieldUsername.isDisable());
        });
    }
    
    @FXML
    private void createUser(MouseEvent event) {
        // TODO: Implement proper validations
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        String fname = fieldFName.getText().trim();
        String lname = fieldLName.getText().trim();
        String cstatus = cbCivilStatus.getValue();
        String username = fieldUsername.getText().trim();
        if(cbAuto.isSelected()) {
            int num = new java.util.Random().nextInt(899) + 100;
            username = fname.toLowerCase().substring(0, 3) + num;
        }
        uService.saveUser(fname, lname, username, cstatus);
        stage.close();
    }

    private void initComboBox() {
        String css = "-fx-font-family: Segoe UI; -fx-font-size: 14px;";
        cbCivilStatus.setStyle(css);
        cbCivilStatus.setItems(FXCollections.observableArrayList("Single", "Married"));
    }
}
