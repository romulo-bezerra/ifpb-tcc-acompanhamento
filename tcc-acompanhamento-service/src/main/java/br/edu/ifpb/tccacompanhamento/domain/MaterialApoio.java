package br.edu.ifpb.tccacompanhamento.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class MaterialApoio {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "materialapoio_sequence_gen")
    @SequenceGenerator(initialValue = 1, schema = "public", sequenceName = "materialapoio_sequence", name = "materialapoio_sequence_gen", allocationSize = 1)
    private Long id;
    @Column(nullable = false)
    private String comentario;
    @Column(nullable = false)
    private String descricao;
    @Column(nullable = false)
    private String arquivo;
    @Column(nullable = false)
    private String linkExterno;

    public MaterialApoio() {

    }

    public MaterialApoio(String comentario, String descricao, String arquivo, String linkExterno) {
        this.comentario = comentario;
        this.descricao = descricao;
        this.arquivo = arquivo;
        this.linkExterno = linkExterno;
    }

    @Override
    public String toString() {
        return "MaterialApoio{" +
                "id=" + id +
                ", comentario='" + comentario + '\'' +
                ", descricao='" + descricao + '\'' +
                ", arquivo='" + arquivo + '\'' +
                ", linkExterno='" + linkExterno + '\'' +
                '}';
    }
}