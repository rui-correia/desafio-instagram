package br.com.braz.rui.desafioinstagram.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private String numero;
    private String email;

    //Colecoes
    @JsonIgnore
    @OneToMany
    private List<Usuario> amigos = new ArrayList<>();

    @OneToMany(mappedBy = "usuario")
    private List<Postagem> postagens = new ArrayList<>();

    @OneToMany(mappedBy = "usuario")
    private List<Mensagem> mensagens = new ArrayList<>();

    @OneToMany(mappedBy = "usuario")
    private List<Comentario> comentarios = new ArrayList<>();
    @OneToOne(mappedBy = "usuario", cascade = CascadeType.ALL,
    fetch = FetchType.LAZY, optional = true)
    private Configuracao configuracao;

    public Usuario(){

    }

    public Usuario(Integer id, String nome, String numero, String email, Set<String> telefones, List<Usuario> amigos, List<Postagem> postagens, List<Mensagem> mensagens, List<Comentario> comentarios, Configuracao configuracao) {
        this.id = id;
        this.nome = nome;
        this.numero = numero;
        this.email = email;
        this.amigos = amigos;
        this.postagens = postagens;
        this.mensagens = mensagens;
        this.comentarios = comentarios;
        this.configuracao = configuracao;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Usuario> getAmigos() {
        return amigos;
    }

    public void setAmigos(List<Usuario> amigos) {
        this.amigos = amigos;
    }

    public List<Postagem> getPostagens() {
        return postagens;
    }

    public void setPostagens(List<Postagem> postagens) {
        this.postagens = postagens;
    }

    public List<Mensagem> getMensagens() {
        return mensagens;
    }

    public void setMensagens(List<Mensagem> mensagens) {
        this.mensagens = mensagens;
    }

    public List<Comentario> getComentarios() {
        return comentarios;
    }

    public void setComentarios(List<Comentario> comentarios) {
        this.comentarios = comentarios;
    }

    public Configuracao getConfiguracao() {
        return configuracao;
    }

    public void setConfiguracao(Configuracao configuracao) {
        this.configuracao = configuracao;
    }
}
