package com.example.telita;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class TelaCadastroController {

    @FXML
    private TextField txtNovoUsuario;

    @FXML
    private TextField txtNovaSenha;

    @FXML
    public void btnFecharTelaCadastro(ActionEvent actionEvent) {

        Dados.usuario = txtNovoUsuario.getText();
        Dados.senha = txtNovaSenha.getText();

        Stage stage = (Stage) ((Node) actionEvent.getSource())
                .getScene()
                .getWindow();

        stage.close();
    }
}
