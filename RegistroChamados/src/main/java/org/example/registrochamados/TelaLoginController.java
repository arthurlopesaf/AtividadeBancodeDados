package org.example.registrochamados;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class TelaLoginController {

    String usuario;
    String senha;

    @FXML
    private TextField txtUsuario;

    @FXML
    private PasswordField txtSenha;

    public void btnConfirmarLogin(ActionEvent event) throws IOException {

        usuario = txtUsuario.getText();
        senha = txtSenha.getText();

        // Validar se não há campos vazios
        if (usuario.isEmpty() || senha.isEmpty()) {

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro");
            alert.setContentText("Todos os campos devem ser preenchidos!");
            alert.showAndWait();

        } else {

            // Validando login no banco de dados
            Usuarios usuarios = new Usuarios(null, usuario, senha);
            UsuariosBD dao = new UsuariosBD();
            boolean logado = dao.login(usuarios);

            if (logado) {

                Alert alerta = new Alert(Alert.AlertType.INFORMATION);
                alerta.setTitle("Login");
                alerta.setHeaderText("Acesso liberado");
                alerta.setContentText("Usuário e senha corretos");
                alerta.showAndWait();

                FXMLLoader loader = new FXMLLoader(getClass().getResource("TelaCadastroChamado.fxml"));
                Parent root = loader.load();

                Stage stage = new Stage();
                stage.setScene(new Scene(root));
                stage.setTitle("TelaCadastroChamado");
                stage.setResizable(false);
                stage.show();

                // Fechar a janela atual
                Stage essaJanela = (Stage) ((Node) event.getSource()).getScene().getWindow();
                essaJanela.close();

            } else {

                Alert alerta = new Alert(Alert.AlertType.ERROR);
                alerta.setTitle("Login");
                alerta.setHeaderText("Acesso negado");
                alerta.setContentText("Usuário ou senha incorreto");
                alerta.showAndWait();

                txtUsuario.clear();
                txtSenha.clear();
            }
        }
    }

    public void CriarConta(ActionEvent event) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("TelaCadastro.fxml"));
        Parent root = loader.load();

        Stage stage = new Stage();
        stage.setTitle("Tela de Cadastro");
        stage.setScene(new javafx.scene.Scene(root));
        stage.setResizable(false);
        stage.show();

        //Fechar a janela atual
        Stage EssaJanela = (Stage) ((Node) event.getSource()).getScene().getWindow();
        EssaJanela.close();
    }
}
