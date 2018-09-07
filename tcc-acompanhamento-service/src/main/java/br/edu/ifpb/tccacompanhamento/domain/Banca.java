package br.edu.ifpb.tccacompanhamento.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
public class Banca {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "banca_sequence_gen")
    @SequenceGenerator(initialValue = 1, schema = "public", sequenceName = "banca_sequence", name = "banca_sequence_gen", allocationSize = 1)
    private Long id;
    @Column(nullable = false)
    @ElementCollection
    private List<Long> professores;
    @Column(nullable = false, unique = true)
    private Integer coordenadorId;

    @OneToOne
    private Defesa defesa;

    public Banca() {
        this.professores = new ArrayList<>();
    }

    public Banca(List<Long> professores, Integer coordenadorId, Defesa defesa) {
        this.professores = professores;
        this.coordenadorId = coordenadorId;
        this.defesa = defesa;
    }

    public boolean addProfessor(Long professorId){
        return professores.add(professorId);
    }

    @Override
    public String toString() {
        return "Banca{" +
                "id=" + id +
                ", professores=" + professores +
                ", coordenadorId=" + coordenadorId +
                ", defesa=" + defesa +
                '}';
    }
}