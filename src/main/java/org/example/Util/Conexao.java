package org.example.Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

    private static final String URL = "jdbc:mysql://localhost:3306/sistemaAlmoxarifado";
    private static final String USER = "root";
    private static final String PASSWORD = "admin123";

    public static Connection conectar() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public static void main(String[] args) throws SQLException {

        try {
            Connection conn = conectar();

            if (conn != null) {
                System.out.println("Conexão bem sucessida");
            } else {
                System.out.println("Conexão falhou");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
