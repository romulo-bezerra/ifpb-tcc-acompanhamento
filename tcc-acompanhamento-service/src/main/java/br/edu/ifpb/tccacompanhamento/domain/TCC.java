package br.edu.ifpb.tccacompanhamento.domain;

import br.edu.ifpb.tccacompanhamento.domain.enums.StatusTCC;
import br.edu.ifpb.tccacompanhamento.domain.enums.TipoTCC;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class TCC {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tcc_sequence_gen")
    @SequenceGenerator(initialValue = 1, schema = "public", sequenceName = "tcc_sequence", name = "tcc_sequence_gen", allocationSize = 1)
    private Long id;
    @Column(nullable = false)
    private String semestre;
    @Column(nullable = false, unique = true)
    private Long alunoId;
    @Column(nullable = false, unique = true)
    private Long orientadorId;
    @Column(nullable = false)
    private Long tema;
    @Column(nullable = false)
    private String titulo;
    @Enumerated
    private TipoTCC tipo;
    @Enumerated
    private StatusTCC statusTCC;
    @Column(nullable = false, unique = true)
    private Long cursoId;

    public TCC() {

    }

    public TCC(String semestre, Long alunoId, Long orientadorId, Long tema, String titulo, TipoTCC tipo, StatusTCC statusTCC, Long cursoId) {
        this.semestre = semestre;
        this.alunoId = alunoId;
        this.orientadorId = orientadorId;
        this.tema = tema;
        this.titulo = titulo;
        this.tipo = tipo;
        this.statusTCC = statusTCC;
        this.cursoId = cursoId;
    }

    @Override
    public String toString() {
        return "TCC{" +
                "id=" + id +
                ", semestre='" + semestre + '\'' +
                ", alunoId=" + alunoId +
                ", orientadorId=" + orientadorId +
                ", tema=" + tema +
                ", titulo='" + titulo + '\'' +
                ", tipo=" + tipo +
                ", statusTCC=" + statusTCC +
                ", cursoId=" + cursoId +
                '}';
    }
}