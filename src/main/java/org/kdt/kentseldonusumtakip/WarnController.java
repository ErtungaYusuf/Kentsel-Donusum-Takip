package org.kdt.kentseldonusumtakip;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;
import org.kdt.kentseldonusumtakip.Backend.MyExeptions.ChoosesAreWrongExeption;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class WarnController implements Initializable {
    @FXML
    private Label send_warn_message;
    @FXML
    private Button goLoginPage,send_warn_button,goBackToGeneralInfoPage,send_warn_cancel_button;

    @FXML
    private Label warn_feedback;
    public void goBackToGeneralInfoAction(ActionEvent action) throws IOException {
        GeneralInfoController.selected_building = null;
        goPage(goBackToGeneralInfoPage,"show_general_info.fxml");
    }

    public void goLoginPageAction(ActionEvent action) throws IOException{
        GeneralInfoController.selected_building = null;
        goPage(goLoginPage,"login_page.fxml");
    }
    private void goPage(Button button,String pageName) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource(pageName));
        Stage window = (Stage) button.getScene().getWindow();
        window.setScene(new Scene(root));
    }
    public void sendWarningAction(ActionEvent action) throws IOException{
        send_warn_cancel_button.setVisible(false);
        send_warn_button.setVisible(false);
        boolean check = false;
        for(int i = 0; i<Main.houses.size(); i++){
            //System.out.println(Main.houses.get(i).getName());
           // System.out.println(GeneralInfoController.selected_building.split(" ")[1]);
            if(Main.houses.get(i).getName().equals(GeneralInfoController.selected_building.split(" ")[1])){
                //System.out.println(Main.houses.get(i).getName() + " uyarı verilenlere eklendi" );
                Main.warned_houses.add(Main.houses.get(i));
                Main.houses.remove(i);
                check = true;
                break;
            }
        }
        if(check){
            warn_feedback.setTextFill(Paint.valueOf("green"));
            warn_feedback.setText("Başarıyla Uyarı Gönderildi");
        }else{
            warn_feedback.setTextFill(Paint.valueOf("red"));
            warn_feedback.setText("Uyarı Verilecek Bina Bulunamadı");
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        try{
            if(GeneralInfoController.selected_building == null){
                throw new ChoosesAreWrongExeption("There isnt any selection for send warning page");
            }else{
                send_warn_message.setText(GeneralInfoController.selected_building);
            }
        }catch (ChoosesAreWrongExeption ex){
            send_warn_message.setTextFill(Paint.valueOf("red"));
            send_warn_message.setText("Hiçbir seçim yapılmadı, Genel Bilgiler sayfasından bir bina seçiniz");
            send_warn_cancel_button.setVisible(false);
            send_warn_button.setVisible(false);
        }


    }
}
