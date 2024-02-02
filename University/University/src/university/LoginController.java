/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package university;

import Database.ConnectionSingleton;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import university.Database.DataAccessLayer;

/**
 *
 * @author OMAR
 */
public class LoginController implements Initializable {
    
    @FXML
    private TextField usernameTxt;

    @FXML
    private PasswordField passwordTxt;

    @FXML
    private Button loginBtn;
    public void loginAdmin(){
        Alert alert = null;
        try{
        if(DataAccessLayer.checkLogin(usernameTxt.getText(), passwordTxt.getText(), ConnectionSingleton.connectDB()))
        {
            alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Information Message");
            alert.setHeaderText(null);
            alert.setContentText("Successfully Login!");
            alert.showAndWait();

//                    TO HIDE THE LOGIN FORM
            loginBtn.getScene().getWindow().hide();
            //LINK YOUR DASHBOARD 
            Parent root = FXMLLoader.load(getClass().getResource("MainScene.fxml"));

            Stage stage = new Stage();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
        else{
            alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Wrong Username/Password");
            alert.showAndWait();
        }
        }catch(Exception e){e.printStackTrace();}
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
