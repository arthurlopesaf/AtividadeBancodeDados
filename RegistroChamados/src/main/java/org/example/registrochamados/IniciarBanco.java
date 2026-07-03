package org.example.registrochamados;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class IniciarBanco {

    public static Connection conectar() throws SQLException {
        //language=SQL
        String conexaoBanco = "jdbc:mysql://localhost:3306/sistema_chamados_ti";
        String password = "";
        String username = "root";
        return DriverManager.getConnection(conexaoBanco, username, password);
    }
}
