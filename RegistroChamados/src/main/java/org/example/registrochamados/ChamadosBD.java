package org.example.registrochamados;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ChamadosBD {

    public void SalvarChamado(Chamados chamado) {

        //language=SQL
        String sql = "INSERT INTO chamados (solicitante, equipamento, problema, prioridade) VALUES (?, ?, ?, ?)";

        try(Connection connection = IniciarBanco.conectar();
            PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setString(1, chamado.getSolicitante());
            stmt.setString(2, chamado.getEquipamento());
            stmt.setString(3, chamado.getProblema());
            stmt.setString(4, chamado.getPrioridade());

            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
