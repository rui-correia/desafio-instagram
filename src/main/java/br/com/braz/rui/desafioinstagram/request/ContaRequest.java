package br.com.braz.rui.desafioinstagram.request;

import com.sun.istack.NotNull;


public class ContaRequest {
    
    @NotNull
    private String senha;
    @NotNull
    private String email;
    @NotNull
    private String nome;
    @NotNull
    private String celular;

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }
}
