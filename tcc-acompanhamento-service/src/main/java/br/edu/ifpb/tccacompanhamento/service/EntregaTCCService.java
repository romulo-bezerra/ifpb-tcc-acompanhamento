package br.edu.ifpb.tccacompanhamento.service;

import br.edu.ifpb.tccacompanhamento.domain.EntregaTCC;
import br.edu.ifpb.tccacompanhamento.repository.EntregaTCCRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EntregaTCCService {

    private final EntregaTCCRepository entregaTCCRepository;

    public EntregaTCCService(EntregaTCCRepository entregaTCCRepository) {
        this.entregaTCCRepository = entregaTCCRepository;
    }

    public EntregaTCC salvarEntregaTCC(EntregaTCC entregaTCC) {
        return entregaTCCRepository.save(entregaTCC);
    }

    public EntregaTCC atualizarEntregaTCC (EntregaTCC entregaTCCAtualizada) {
        return entregaTCCRepository.save(entregaTCCAtualizada);
    }

    public void apagarEntregaTCC(EntregaTCC entregaTCC) {
        entregaTCCRepository.delete(entregaTCC);
    }

    public List<EntregaTCC> listarTodas() {
        return entregaTCCRepository.findAll();
    }

    public Optional<EntregaTCC> buscarPorId(Long id) {
        return entregaTCCRepository.findById(id);
    }
}
