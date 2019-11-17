module gui {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.apache.logging.log4j;
    requires java.xml;
    /*requires java.xml.bind;*/

    opens de.hdm_stuttgart.mi to javafx.fxml;
    exports de.hdm_stuttgart.mi;
}