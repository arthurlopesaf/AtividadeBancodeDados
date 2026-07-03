package org.example.registrochamados;

public class Usuarios {

    private String usuario;
    private String senha;
    private String nome;

    public Usuarios(String novoNome, String novoUsuario, String novaSenha) {
        this.nome = novoNome;
        this.usuario = novoUsuario;
        this.senha = novaSenha;
    }

    public String getNome() {
        return nome;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getSenha() {
        return senha;
    }

}
