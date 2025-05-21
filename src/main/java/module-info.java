module org.kdt.kentseldonusumtakip {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.kdt.kentseldonusumtakip to javafx.fxml;
    exports org.kdt.kentseldonusumtakip;
    exports org.kdt.kentseldonusumtakip.Backend;
    opens org.kdt.kentseldonusumtakip.Backend to javafx.fxml;
    exports org.kdt.kentseldonusumtakip.Backend.MyExeptions;
    opens org.kdt.kentseldonusumtakip.Backend.MyExeptions to javafx.fxml;
}