package org.kdt.kentseldonusumtakip;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.kdt.kentseldonusumtakip.Backend.ApartmentHouse;
import org.kdt.kentseldonusumtakip.Backend.DetachedHouse;
import org.kdt.kentseldonusumtakip.Backend.House;
import org.kdt.kentseldonusumtakip.Backend.Slum;

import java.io.IOException;
import java.util.ArrayList;

public class Main extends Application {

    public static ArrayList<House> houses = new ArrayList<>();
    public static ArrayList<House> warned_houses = new ArrayList<>();

    @Override
    public void start(Stage stage) throws IOException {
        //example data adding:
        add_example_data(houses);
        add_example_data2(warned_houses);
        stage.setResizable(false);
        stage.setTitle("Kentsel Dönüşüm Takip Uygulaması");

        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("login_page.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
        stage.show();
    }


    public static void main(String[] args) {
        launch();
    }

    public void add_example_data(ArrayList<House> houses){
        houses.add(new House("Menekşe",1001,3));
        houses.add(new Slum("Kaya",1002,6));
        houses.add(new ApartmentHouse("Lale",1003,6, 7));
        houses.add(new House("Güzelevler",1004,1));
        houses.add(new House(1005,1));
        houses.add(new DetachedHouse("Tamevler",1006,5,30,40));
        houses.add(new DetachedHouse("Tamevler2",1008,5,2));

    }
    public void add_example_data2(ArrayList<House> houses){
        houses.add(new House("Öz",1007,9));
        houses.add(new ApartmentHouse("Kara",1003,6, 7));
    }

}