module com.example.proyectoreportes {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires jasperreports;
    requires java.desktop;
    requires org.mariadb.jdbc;

    opens com.example.proyectoreportes to javafx.fxml;
    exports com.example.proyectoreportes;
}