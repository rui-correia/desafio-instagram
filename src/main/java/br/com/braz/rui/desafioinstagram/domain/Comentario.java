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



}
