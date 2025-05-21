package org.kdt.kentseldonusumtakip;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;
import org.kdt.kentseldonusumtakip.Backend.*;
import org.kdt.kentseldonusumtakip.Backend.MyExeptions.UnknownChoosingExeption;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AddNewController implements Initializable {
    @FXML
    private Button goLoginPage,goBackToGeneralInfoPage,addButton,cancelButton;

    @FXML
    private TextField name,id,risk,floor,garden_size;
    @FXML
    private ChoiceBox<String> BuildingType;

    @FXML
    private Label feedback_message,floor_label,garden_size_label;

    private String[] BuildingTypes = {"Müstakil Ev","Apartman Dairesi","Gecekondu"};

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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        floor_label.setVisible(false);
        floor.setVisible(false);
        garden_size_label.setVisible(false);
        garden_size.setVisible(false);
        BuildingType.getItems().addAll(BuildingTypes);
        BuildingType.setOnAction(this::show_invisibles);

    }

    private void show_invisibles(ActionEvent action){
        String type = BuildingType.getValue().toString();
        if(type.equals("Apartman Dairesi")){
            floor_label.setText("Kat Numarası:");
            floor_label.setVisible(true);
            floor.setVisible(true);
            garden_size_label.setVisible(false);
            garden_size.setVisible(false);
        }else if(type.equals("Müstakil Ev")){
            floor_label.setText("Kat Sayısı:");
            floor_label.setVisible(true);
            floor.setVisible(true);
            garden_size_label.setVisible(true);
            garden_size.setVisible(true);
        }else if(type.equals("Gecekondu")){
            floor_label.setVisible(false);
            floor.setVisible(false);
            garden_size_label.setVisible(true);
            garden_size.setVisible(true);
        }else{
            throw new RuntimeException();
        }
    }
    public void addAction(ActionEvent action) throws IOException, UnknownChoosingExeption {
        try{
            String building_name = name.getText();
            int building_id =Integer.parseInt(id.getText());
            int building_risk = Integer.parseInt(risk.getText());
            House newHouse;
            String type = BuildingType.getValue();
            if(type == null){
                type = "Belirtilmemiş";
            }
        System.out.println("tip:" +type);
            if(type.equals("Müstakil Ev")){
                int building_floor = Integer.parseInt(floor.getText());
                int building_garden_size = Integer.parseInt(garden_size.getText());
                newHouse = new DetachedHouse(building_name,building_id,building_risk,building_floor,building_garden_size);
            }else if(type.equals("Apartman Dairesi")){
                int total_floor = Integer.parseInt(floor.getText());
                System.out.println(total_floor);
                newHouse = new ApartmentHouse(building_name,building_id,building_risk,total_floor);
            }else if(type.equals("Gecekondu")){
                int building_garden_size = Integer.parseInt(garden_size.getText());
                newHouse = new Slum(building_name,building_id,building_risk,building_garden_size);
            }else{
                newHouse = new House(building_name,building_id,building_risk);
            }
            Main.houses.add(newHouse);
           cancelButton.setVisible(false);
           addButton.setVisible(false);
            feedback_message.setTextFill(Paint.valueOf("green"));
            feedback_message.setText("Ekleme Başarılı");
        }catch (Exception e){
          System.out.println(e.getMessage());
           feedback_message.setTextFill(Paint.valueOf("red"));
            feedback_message.setText("Ekleme Başarısız. Değerleri Uygun Giriniz");
        }


    }

}

