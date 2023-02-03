package com.example.proyectoreportes;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import net.sf.jasperreports.engine.JRException;

import java.sql.SQLException;

public class HelloController {

   public void onImprimirListadoClick(ActionEvent actionEvent) {
      try {
         // --- Show Jasper Report on click-----
         new ReportClients().showReportSimple();
      } catch (ClassNotFoundException | JRException | SQLException e1) {
         e1.printStackTrace();
      }

   }

   public void onImprimirListadoPedidosCliClick(ActionEvent actionEvent) {
      try {
         // --- Show Jasper Report on click-----
         new ReportClients().showReportConSubreport();
      } catch (ClassNotFoundException | JRException | SQLException e1) {
         e1.printStackTrace();
      }
   }
}