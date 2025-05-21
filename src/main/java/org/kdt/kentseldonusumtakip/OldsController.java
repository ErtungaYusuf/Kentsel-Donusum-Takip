package org.kdt.kentseldonusumtakip;

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

public class OldsController implements Initializable {

    @FXML
    private ListView<String> warned_buildings_listview;
    @FXML
    private Button goLoginPage,goBackToGeneralInfoPage;
    ArrayList<String> buildings_string = new ArrayList<String>();
    public OldsController(){
        String row;
        for(int i = 0; i<Main.warned_houses.size(); i++){
            if(Main.warned_houses.get(i) instanceof ApartmentHouse){
                row = "Ad: " + Main.warned_houses.get(i).getName() +
                        " Apt.,  Id: " + Main.warned_houses.get(i).getId() +
                        ", Kat Sayısı: "+ ((ApartmentHouse) Main.warned_houses.get(i)).getFloor() +
                " Tip: "+ Main.warned_houses.get(i).getType();
            }else if(Main.warned_houses.get(i) instanceof DetachedHouse){
                row = "Ad: " + Main.warned_houses.get(i).getName() +
                        " , Id: " + Main.warned_houses.get(i).getId() +
                        " Kat Sayısı: "+ ((DetachedHouse) Main.warned_houses.get(i)).getTotalFloor() +
                        " Bahçe: " + ((DetachedHouse) Main.warned_houses.get(i)).getGardenSize() +
                        " " + ((DetachedHouse) Main.warned_houses.get(i)).isGardenBigForKD() +
                        " Tip: " + Main.warned_houses.get(i).getType() ;
            }else if(Main.warned_houses.get(i) instanceof Slum){//Slum:
                row = "Ad: " + Main.warned_houses.get(i).getName() +
                        " , Id: " + Main.warned_houses.get(i).getId() +
                        " Bahçe: " +  ((Slum) Main.warned_houses.get(i)).getGardenSize() +
                        " " + ((Slum) Main.warned_houses.get(i)).isGardenBigForKD() +
                        " Tip: " + Main.warned_houses.get(i).getType() ;
            }else{// House:
                row = "Ad: " + Main.warned_houses.get(i).getName() +
                        " , Id: " + Main.warned_houses.get(i).getId() +
                        " Tip: " + Main.warned_houses.get(i).getType() ;
            }

            //System.out.println(row);
            buildings_string.add(row);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        warned_buildings_listview.getItems().addAll(buildings_string);
    }
    public void goBackToGeneralInfoAction(ActionEvent action) throws IOException{
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
}
