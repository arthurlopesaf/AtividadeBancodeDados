package com.example.telita;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class TelaInicialController {

    @FXML
    private TextField txtUsuario;

    @FXML
    private PasswordField txtSenha;

    @FXML
    private CheckBox chxVerSenha;

    @FXML
    private TextField txtSenhaVisivel;

    @FXML
    public void btnValidarAcesso(ActionEvent actionEvent) {

        String usuario = txtUsuario.getText();
        String senha = txtSenha.getText();

        if (usuario.equals(Dados.usuario) && senha.equals(Dados.senha)){

            Alert alerta = new Alert(Alert.AlertType.INFORMATION);
            alerta.setTitle("Login");
            alerta.setHeaderText("Acesso liberado");
            alerta.setContentText("Usuário e senha corretos");
            alerta.showAndWait();
            txtUsuario.clear();
            txtSenha.clear();
        }else{

            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("Login");
            alerta.setHeaderText("Acesso negado");
            alerta.setContentText("Usuário ou senha incorreto");
            alerta.showAndWait();
            txtUsuario.clear();
            txtSenha.clear();
        }
    }

    public void abrirCadastro(ActionEvent actionEvent) throws IOException {

        FXMLLoader loader = new FXMLLoader(
                getClass().getResource("TelaCadastro.fxml"));

        Parent root = loader.load();

        Stage stage = new Stage();
        stage.setTitle("Cadastro");
        stage.setScene(new Scene(root));
        stage.show();
    }

    public void alternarVisibilidade(ActionEvent actionEvent) {

        if (chxVerSenha.isSelected()){
            txtSenhaVisivel.setText(txtSenha.getText());
            txtSenhaVisivel.setVisible(true);
            txtSenhaVisivel.setManaged(true);

            txtSenha.setVisible(false);
            txtSenha.setManaged(false);
        }else{
            txtSenha.setText(txtSenhaVisivel.getText());
            txtSenha.setVisible(true);
            txtSenha.setManaged(true);

            txtSenhaVisivel.setVisible(false);
            txtSenhaVisivel.setManaged(false);
        }
    }
}


