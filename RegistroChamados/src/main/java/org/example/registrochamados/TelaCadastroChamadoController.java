package org.example.registrochamados;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class TelaCadastroChamadoController {

    @FXML
    private TextField txtSolicitante;

    @FXML
    private TextField txtEquipamento;

    @FXML
    private TextField txtProblema;

    @FXML
    private ComboBox<String> cmbPrioridade;

    @FXML
    public void initialize() {
        cmbPrioridade.getItems().addAll("Baixa", "Média", "Alta", "Urgente");
    }

    public void btnRegistrarChamado(ActionEvent event) {

        if (txtSolicitante.getText().isEmpty() || txtEquipamento.getText().isEmpty() || txtProblema.getText().isEmpty() || cmbPrioridade.getValue() == null) {

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro");
            alert.setHeaderText(null);
            alert.setContentText("Todos os campos devem ser preenchidos!");
            alert.showAndWait();

        } else {
            String solicitante = txtSolicitante.getText();
            String equipamento = txtEquipamento.getText();
            String problema = txtProblema.getText();
            String prioridade = cmbPrioridade.getValue();

            Chamados chamado = new Chamados(solicitante, equipamento, problema, prioridade);
            ChamadosBD chamadoDAO = new ChamadosBD();
            chamadoDAO.SalvarChamado(chamado);

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Sucesso");
            alert.setHeaderText(null);
            alert.setContentText("Chamado registrado com sucesso!");
            alert.showAndWait();

            txtSolicitante.clear();
            txtEquipamento.clear();
            txtProblema.clear();
            cmbPrioridade.getSelectionModel().clearSelection();
        }
    }

    public void btnLimparCampos(ActionEvent event) {

        txtSolicitante.clear();
        txtEquipamento.clear();
        txtProblema.clear();
        cmbPrioridade.getSelectionModel().clearSelection();

    }
}
