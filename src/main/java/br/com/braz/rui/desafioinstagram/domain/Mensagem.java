package br.com.braz.rui.desafioinstagram.domain;

import net.bytebuddy.dynamic.loading.PackageDefinitionStrategy;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
public class Mensagem implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String texto;
    private LocalDateTime data;
    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    public Mensagem(){}


    public Mensagem(Integer id, String texto, LocalDateTime data, Usuario usuario) {
        this.id = id;
        this.texto = texto;
        this.data = data;
        this.usuario = usuario;
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
}
