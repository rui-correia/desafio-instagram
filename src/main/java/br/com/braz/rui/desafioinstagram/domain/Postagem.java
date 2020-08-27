package br.com.braz.rui.desafioinstagram.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Postagem implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String texto;
    private String imagem;
    private LocalDateTime data;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    @OneToMany(mappedBy = "postagem")
    private List<Comentario> comentarios = new ArrayList<>();

    public Postagem(){

    }

    public Postagem(Integer id, String texto, String imagem, LocalDateTime data, Usuario usuario, List<Comentario> comentarios) {
        this.id = id;
        this.texto = texto;
        this.imagem = imagem;
        this.data = data;
        this.usuario = usuario;
        this.comentarios = comentarios;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Comentario> getComentarios() {
        return comentarios;
    }

    public void setComentarios(List<Comentario> comentarios) {
        this.comentarios = comentarios;
    }
}
