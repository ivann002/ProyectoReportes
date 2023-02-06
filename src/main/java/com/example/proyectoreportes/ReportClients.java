package com.example.proyectoreportes;

import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.swing.JRViewer;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;

public class ReportClients extends JFrame {
    public void showReportSimple() throws JRException, ClassNotFoundException, SQLException {

        String servidor = "jdbc:mariadb://localhost:5555/noinch?useSSL=false";
        String usuario = "adminer";
        String passwd = "adminer";

        Connection conexionBBDD;
        // Nos conectamos
        conexionBBDD = DriverManager.getConnection(servidor, usuario, passwd);

        //  Block of code to try
        String reportSrcFile = "src/main/resources/reportes/primerReporte.jrxml";

        // First, compile jrxml file.
        JasperReport jasperReport = JasperCompileManager.compileReport(reportSrcFile);

        // Ejemplo de definición de parámetros para el informe

        HashMap<String, Object> parameters = new HashMap<String, Object>();

        parameters.put("company", "MAROTHIA TECHS");
        parameters.put("receipt_no", "RE101".toString());

        JasperPrint print = JasperFillManager.fillReport(jasperReport, parameters, conexionBBDD);
        JRViewer viewer = new JRViewer(print);
        viewer.setOpaque(true);
        viewer.setVisible(true);
        this.add(viewer);
        this.setSize(700, 500);
        this.setVisible(true);
        System.out.print("Done!");

    }
    public void showReportConSubreport() throws JRException, ClassNotFoundException, SQLException {

        String servidor = "jdbc:mariadb://localhost:5555/noinch?useSSL=false";
        String usuario = "adminer";
        String passwd = "adminer";

        Connection conexionBBDD;

        conexionBBDD = DriverManager.getConnection(servidor, usuario, passwd);

        String reportSrcFile = "src/main/java/com/example/proyectoreportes/reportes/primerReporte.jrxml";
        String subReportSrcFile = "src/main/java/com/example/proyectoreportes/reportes/segundoReporte.jrxml";

        JasperReport jasperReport = JasperCompileManager.compileReport(reportSrcFile);
        JasperReport jasperSubReport = JasperCompileManager.compileReport(subReportSrcFile);

        HashMap<String, Object> parameters = new HashMap<String, Object>();

        parameters.put("Subreport", jasperSubReport);

        JasperPrint print = JasperFillManager.fillReport(jasperReport, parameters, conexionBBDD);
        JRViewer viewer = new JRViewer(print);
        viewer.setOpaque(true);
        viewer.setVisible(true);
        this.add(viewer);
        this.setSize(700, 500);
        this.setVisible(true);
        System.out.print("Done!");

    }
}
