package controllers;

import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

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

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // TODO
        initComboBox();
        
    }    
    
    private void initComboBox() {
        String css = "-fx-font-family: Segoe UI; -fx-font-size: 14px;";
        cbCivilStatus.setStyle(css);
        cbCivilStatus.setItems(FXCollections.observableArrayList("Single", "Married"));
    }
}
