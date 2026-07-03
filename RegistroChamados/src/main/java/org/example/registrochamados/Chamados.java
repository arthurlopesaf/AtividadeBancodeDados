package org.example.registrochamados;

public class Chamados {

    private String solicitante;
    private String equipamento;
    private String problema;
    private String prioridade;

    public Chamados(String solicitante, String equipamento, String problema, String prioridade) {
        this.solicitante = solicitante;
        this.equipamento = equipamento;
        this.problema = problema;
        this.prioridade = prioridade;
    }

    public String getSolicitante() {
        return solicitante;
    }

    public String getEquipamento() {
        return equipamento;
    }

    public String getProblema() {
        return problema;
    }

    public String getPrioridade() {
        return prioridade;
    }
}
