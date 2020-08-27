package br.com.braz.rui.desafioinstagram.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class Comentario implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;
    private String comentario;
    private LocalDateTime data;
    @ManyToOne
    @JoinColumn(name = "id_postagem")
    private Postagem postagem;

    public Comentario(){

    }

    public Comentario(Integer id, Usuario usuario, String comentario, LocalDateTime data, Postagem postagem) {
        this.id = id;
        this.usuario = usuario;
        this.comentario = comentario;
        this.data = data;
        this.postagem = postagem;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    public Postagem getPostagem() {
        return postagem;
    }

    public void setPostagem(Postagem postagem) {
        this.postagem = postagem;
    }
}
