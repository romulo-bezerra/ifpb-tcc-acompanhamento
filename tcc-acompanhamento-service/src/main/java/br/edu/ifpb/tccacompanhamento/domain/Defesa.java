package br.edu.ifpb.tccacompanhamento.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.ZonedDateTime;

@Getter
@Setter
@Entity
public class Defesa {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "defesa_sequence_gen")
    @SequenceGenerator(initialValue = 1, schema = "public", sequenceName = "defesa_sequence", name = "defesa_sequence_gen", allocationSize = 1)
    private Long id;
    @Column(nullable = false)
    private String comunicado;
    @Column(nullable = false, unique = true)
    private Long TCCId;
    @Column(nullable = false, unique = true)
    private Long ambienteId;
    @Column(nullable = false)
    private ZonedDateTime dataHora;

    @OneToOne
    private Banca banca;

    public Defesa() {

    }

    public Defesa(String comunicado, Long TCCId, Long ambienteId, ZonedDateTime dataHora, Banca banca) {
        this.comunicado = comunicado;
        this.TCCId = TCCId;
        this.ambienteId = ambienteId;
        this.dataHora = dataHora;
        this.banca = banca;
    }

    @Override
    public String toString() {
        return "Defesa{" +
                "id=" + id +
                ", comunicado='" + comunicado + '\'' +
                ", TCCId=" + TCCId +
                ", ambienteId=" + ambienteId +
                ", dataHora=" + dataHora +
                ", banca=" + banca +
                '}';
    }
}