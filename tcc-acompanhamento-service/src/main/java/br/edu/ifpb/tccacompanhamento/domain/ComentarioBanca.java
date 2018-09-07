package br.edu.ifpb.tccacompanhamento.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class ComentarioBanca {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "comentariobanca_sequence_gen")
    @SequenceGenerator(initialValue = 1, schema = "public", sequenceName = "comentariobanca_sequence", name = "comentariobanca_sequence_gen", allocationSize = 1)
    private Long id;
    @Column(nullable = false, unique = true)
    private Integer professorId;
    @Column(nullable = false)
    private String comentario;

    @OneToOne
    private Documento documento;

    public ComentarioBanca() {

    }



}