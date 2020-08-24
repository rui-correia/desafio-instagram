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
}
