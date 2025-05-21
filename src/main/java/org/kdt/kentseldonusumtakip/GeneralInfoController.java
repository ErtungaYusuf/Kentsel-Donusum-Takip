package org.kdt.kentseldonusumtakip;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import org.kdt.kentseldonusumtakip.Backend.ApartmentHouse;
import org.kdt.kentseldonusumtakip.Backend.DetachedHouse;
import org.kdt.kentseldonusumtakip.Backend.IGarden;
import org.kdt.kentseldonusumtakip.Backend.Slum;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class GeneralInfoController implements Initializable {

    public static String selected_building;

    @FXML
    private ListView<String> buildings_listview;
    @FXML
    private Button goLoginPage,goSendWarningPage,goOldsPage,goAddNewPage;
    ArrayList<String> buildings_string = new ArrayList<String>();
    public GeneralInfoController(){
        String row;
        for(int i = 0; i<Main.houses.size(); i++){
            if(Main.houses.get(i) instanceof ApartmentHouse){
                 row = "Ad: " + Main.houses.get(i).getName() +
                        " Apt., Id: " + Main.houses.get(i).getId() +
                        ", Kat Sayısı: "+ ((ApartmentHouse) Main.houses.get(i)).getFloor() +
                 " Tip: " + Main.houses.get(i).getType() ;
            }else if(Main.houses.get(i) instanceof DetachedHouse){
                 row = "Ad: " + Main.houses.get(i).getName() +
                         " , Id: " + Main.houses.get(i).getId() +
                         " Kat Sayısı: "+ ((DetachedHouse) Main.houses.get(i)).getTotalFloor() +
                         " Bahçe: " + ((DetachedHouse) Main.houses.get(i)).getGardenSize() +
                         " " + ((DetachedHouse) Main.houses.get(i)).isGardenBigForKD() +
                         " Tip: " + Main.houses.get(i).getType() ;
            }else if(Main.houses.get(i) instanceof Slum){//Slum:
                row = "Ad: " + Main.houses.get(i).getName() +
                        " , Id: " + Main.houses.get(i).getId() +
                        " Bahçe: " +  ((Slum) Main.houses.get(i)).getGardenSize() +
                         " " + ((Slum) Main.houses.get(i)).isGardenBigForKD() +
                        " Tip: " + Main.houses.get(i).getType() ;
            }else{// House:
                row = "Ad: " + Main.houses.get(i).getName() +
                        " , Id: " + Main.houses.get(i).getId() +
                        " Tip: " + Main.houses.get(i).getType() ;
            }

            //System.out.println(row);
            buildings_string.add(row);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        buildings_listview.getItems().addAll(buildings_string);
        buildings_listview.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
                selected_building = buildings_listview.getSelectionModel().getSelectedItem();
                //System.out.println(selected_building);
            }
        });
    }
    public void goAddNewPageAction(ActionEvent action) throws IOException{
        goPage(goAddNewPage,"add_new.fxml");
    }
    public void goOldsPageAction(ActionEvent action) throws IOException{
        goPage(goOldsPage,"olds.fxml");
    }
    public void goSendWarningPageAction(ActionEvent action) throws IOException{
        goPage(goSendWarningPage,"send_warning.fxml");
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
}
