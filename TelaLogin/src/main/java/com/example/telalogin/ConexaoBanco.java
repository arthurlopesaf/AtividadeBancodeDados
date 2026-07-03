package com.example.telalogin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoBanco {

    private static final String url = "jdbc:mysql://localhost:3306/sistema_login";
    private static final String usuario = "root";
    private static final String senha = "";

    public static Connection conectar() throws SQLException {

        return DriverManager.getConnection(url, usuario, senha);
    }
}
