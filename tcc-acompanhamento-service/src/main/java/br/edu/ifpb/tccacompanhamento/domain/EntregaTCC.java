package br.edu.ifpb.tccacompanhamento.domain;

import br.edu.ifpb.tccacompanhamento.domain.enums.TipoEntrega;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
public class EntregaTCC {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "entregatcc_sequence_gen")
    @SequenceGenerator(initialValue = 1, schema = "public", sequenceName = "entregatcc_sequence", name = "entregatcc_sequence_gen", allocationSize = 1)
    private Long id;
    @Column(nullable = false)
    private ZonedDateTime dataHoraMax;
    @Column(nullable = false)
    private String comunicado;
    @Column(nullable = false, unique = true)
    private Long TCCId;
    @Column(nullable = false, unique = true)
    private Long coordenadorId;
    @Column(nullable = false)
    @Enumerated
    private TipoEntrega tipoEntrega;

    @OneToMany
    private List<Documento> documentos;

    public EntregaTCC() {
        this.documentos = new ArrayList<>();
    }

    public EntregaTCC(ZonedDateTime dataHoraMax, String comunicado, Long TCCId, Long coordenadorId, TipoEntrega tipoEntrega, List<Documento> documentos) {
        this.dataHoraMax = dataHoraMax;
        this.comunicado = comunicado;
        this.TCCId = TCCId;
        this.coordenadorId = coordenadorId;
        this.tipoEntrega = tipoEntrega;
        this.documentos = documentos;
    }

    public boolean addDocumentos(Documento documento) {
        return documentos.add(documento);
    }

    @Override
    public String toString() {
        return "EntregaTCC{" +
                "id=" + id +
                ", dataHoraMax=" + dataHoraMax +
                ", comunicado='" + comunicado + '\'' +
                ", TCCId=" + TCCId +
                ", coordenadorId=" + coordenadorId +
                ", tipoEntrega=" + tipoEntrega +
                ", documentos=" + documentos +
                '}';
    }
}