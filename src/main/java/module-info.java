module inquiz {
    requires java.xml.bind;
    opens de.hdm_stuttgart.mi.classes to java.xml.bind;
    exports de.hdm_stuttgart.mi.classes;
    exports de.hdm_stuttgart.mi.exceptions;
    exports de.hdm_stuttgart.mi.animations;
    exports de.hdm_stuttgart.mi.gameModeFactory;
    exports de.hdm_stuttgart.mi.interfaces;
    exports de.hdm_stuttgart.mi.jokerFactory;

    requires javafx.controls;
    requires javafx.graphics;
    requires org.apache.logging.log4j;
    requires javafx.fxml;
    requires java.sql;
    requires javafx.media;

    opens de.hdm_stuttgart.mi.guiHandler to javafx.graphics, javafx.fxml, javafx.media;
    exports de.hdm_stuttgart.mi.guiHandler;
}