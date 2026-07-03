package org.example.registrochamados;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UsuariosBD {

    public void salvarusuario (Usuarios usuarios){

        //language=SQL
        String sql = "INSERT INTO  usuarios (nome, usuario, senha) VALUES (?, ?, ?)";

        try (Connection conectar = IniciarBanco.conectar();
             PreparedStatement stmt = conectar.prepareStatement(sql)) {


            stmt.setString(1, usuarios.getNome());
            stmt.setString(2, usuarios.getUsuario());
            stmt.setString(3, usuarios.getSenha());

            stmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public boolean login(Usuarios usuarios) {

        //language=SQL
        String sql = "SELECT * FROM usuarios WHERE usuario = ? AND senha = ?";

        try (Connection conectar = IniciarBanco.conectar();
             PreparedStatement stmt = conectar.prepareStatement(sql)) {

            stmt.setString(1, usuarios.getUsuario());
            stmt.setString(2, usuarios.getSenha());

            return stmt.executeQuery().next();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
