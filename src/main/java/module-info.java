module inquiz {
    requires java.xml.bind;
    opens de.hdm_stuttgart.mi.classes to java.xml.bind;
    exports de.hdm_stuttgart.mi.classes;

    requires javafx.controls;
    requires javafx.graphics;
    requires org.apache.logging.log4j;
    requires javafx.fxml;
    requires java.sql;

    opens de.hdm_stuttgart.mi.guiHandler to javafx.graphics, javafx.fxml;
    exports de.hdm_stuttgart.mi.guiHandler;
}