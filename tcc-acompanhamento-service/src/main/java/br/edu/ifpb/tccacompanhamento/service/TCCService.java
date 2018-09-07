package br.edu.ifpb.tccacompanhamento.service;

import br.edu.ifpb.tccacompanhamento.domain.TCC;
import br.edu.ifpb.tccacompanhamento.repository.TCCRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TCCService {

    private final TCCRepository tccRepository;

    public TCCService(TCCRepository tccRepository) {
        this.tccRepository = tccRepository;
    }

    public TCC salvarTCC(TCC tcc) {
        return tccRepository.save(tcc);
    }

    public TCC atualizarTCC(TCC tccAtualizado) {
        return tccRepository.save(tccAtualizado);
    }

    public void apagarTCC(TCC tcc) {
        tccRepository.delete(tcc);
    }

    public List<TCC> listarTodos() {
        return tccRepository.findAll();
    }

    public Optional<TCC> buscarPorId(Long id) {
        return tccRepository.findById(id);
    }
}
