package br.com.braz.rui.desafioinstagram.request;

import com.sun.istack.NotNull;

import java.time.LocalDateTime;

public class PostagemRequest {

    @NotNull
    private Integer idUsuarioLogado;
    @NotNull
    private String texto;
    private String imagem;

    public Integer getIdUsuarioLogado() {
        return idUsuarioLogado;
    }

    public void setIdUsuarioLogado(Integer idUsuarioLogado) {
        this.idUsuarioLogado = idUsuarioLogado;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }
}
