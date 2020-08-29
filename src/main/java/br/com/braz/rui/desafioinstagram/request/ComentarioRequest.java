package br.com.braz.rui.desafioinstagram.request;

import com.sun.istack.NotNull;

public class ComentarioRequest {

    @NotNull
    private Integer idUsuarioLogado;
    @NotNull
    private Integer idPostagem;
    @NotNull
    private String comentario;

    public Integer getIdUsuarioLogado() {
        return idUsuarioLogado;
    }

    public void setIdUsuarioLogado(Integer idUsuarioLogado) {
        this.idUsuarioLogado = idUsuarioLogado;
    }

    public Integer getIdPostagem() {
        return idPostagem;
    }

    public void setIdPostagem(Integer idPostagem) {
        this.idPostagem = idPostagem;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }
}
