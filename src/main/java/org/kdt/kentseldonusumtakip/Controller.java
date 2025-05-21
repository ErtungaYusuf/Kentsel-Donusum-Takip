package org.kdt.kentseldonusumtakip;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;

import java.io.IOException;

public class Controller{
    String admin_username = "a";
    String admin_password = "a";

    //----------------------------
    @FXML
    private Button login_button,goLoginPage,goBackToGeneralInfoPage;

    @FXML
    private Label entry_message;
    @FXML
    private TextField username;
    @FXML
    private PasswordField password;

     //---------------------

    public void goLoginPageAction(ActionEvent action) throws IOException{
        GeneralInfoController.selected_building = null;
        goPage(goLoginPage,"login_page.fxml");
    }
    public void goBackToGeneralInfoAction(ActionEvent action) throws IOException{
        GeneralInfoController.selected_building = null;
        goPage(goBackToGeneralInfoPage,"show_general_info.fxml");
    }

    @FXML
    public void LoginButtonAction(ActionEvent action) throws IOException {
        if(username.getText().toString().equals(admin_username) && password.getText().toString().equals(admin_password)){
            entry_message.setTextFill(Paint.valueOf("green"));
            entry_message.setText("Giriş Başarılı");
            goPage(login_button,"show_general_info.fxml");
        }else if(username.getText().toString().isEmpty() || password.getText().toString().isEmpty()){
            entry_message.setTextFill(Paint.valueOf("red"));
            entry_message.setText("Lütfen Tüm Zorunlu Alanları Doldurunuz");
        }else{
            entry_message.setTextFill(Paint.valueOf("red"));
            entry_message.setText("Hatalı Kullanıcı Adı Veya Şifre");
        }

    }
    private void goPage(Button button,String pageName) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource(pageName));
        Stage window = (Stage) button.getScene().getWindow();
        window.setScene(new Scene(root));
    }




    /*
    *   public void goOldsPageAction(ActionEvent action) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("olds.fxml"));
        Stage window = (Stage) goOldsPage.getScene().getWindow();
        window.setScene(new Scene(root));
    }*/

}