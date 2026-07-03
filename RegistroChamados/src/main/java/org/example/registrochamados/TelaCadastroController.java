package org.example.registrochamados;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class TelaCadastroController {

    String nome;
    String usuario;
    String senha;

    @FXML
    private TextField txtCadastrarNome;

    @FXML
    private TextField txtCadastrarUsuario;

    @FXML
    private TextField txtCadastrarSenha;

    public void btnCadastrar(ActionEvent event) throws IOException {

        if(txtCadastrarNome.getText().isEmpty() || txtCadastrarUsuario.getText().isEmpty() || txtCadastrarSenha.getText().isEmpty()) {

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro");
            alert.setContentText("Todos os campos devem ser preenchidos!");
            alert.showAndWait();

        } else {

            nome = txtCadastrarNome.getText();
            usuario = txtCadastrarUsuario.getText();
            senha = txtCadastrarSenha.getText();

            Usuarios novousuario = new Usuarios(nome, usuario, senha);

            UsuariosBD usuariosBD = new UsuariosBD();
            usuariosBD.salvarusuario(novousuario); //salvando no banco de dados

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Sucesso");
            alert.setContentText("Usuário cadastrado com sucesso!");
            alert.showAndWait();

            FXMLLoader loader = new FXMLLoader(getClass().getResource("TelaLogin.fxml"));
            Parent root = loader.load();

            Stage stage = new Stage();
            stage.setTitle("Tela de Login");
            stage.setScene(new javafx.scene.Scene(root));
            stage.setResizable(false);
            stage.show();

            //Fechar a janela atual
            Stage EssaJanela = (Stage) ((Node) event.getSource()).getScene().getWindow();
            EssaJanela.close();
        }
    }
}
