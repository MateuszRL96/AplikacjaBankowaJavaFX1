module cam.jmc.aplikacjabankowajavafx {
    requires javafx.controls;
    requires javafx.fxml;
    requires de.jensd.fx.glyphs.fontawesome;
    requires java.sql;
    requires org.xerial.sqlitejdbc;
    //requires javafx.graphics;

    opens cam.jmc.aplikacjabankowajavafx to javafx.fxml;
    exports cam.jmc.aplikacjabankowajavafx;
    exports cam.jmc.aplikacjabankowajavafx.Controllers;
    exports cam.jmc.aplikacjabankowajavafx.Controllers.Admin;
    exports cam.jmc.aplikacjabankowajavafx.Controllers.Client;
    exports cam.jmc.aplikacjabankowajavafx.Models;
    exports cam.jmc.aplikacjabankowajavafx.Views;
}