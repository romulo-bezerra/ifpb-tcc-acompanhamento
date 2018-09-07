package br.edu.ifpb.tccacompanhamento.service;

import br.edu.ifpb.tccacompanhamento.domain.Defesa;
import br.edu.ifpb.tccacompanhamento.repository.DefesaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DefesaService {

    private final DefesaRepository defesaRepository;

    public DefesaService(DefesaRepository defesaRepository) {
        this.defesaRepository = defesaRepository;
    }

    public Defesa salvarDefesa(Defesa defesa) {
        return defesaRepository.save(defesa);
    }

    public Defesa atualizarDefesa(Defesa defesaAtualizada) {
        return defesaRepository.save(defesaAtualizada);
    }

    public void apagarDefesa(Defesa defesa) {
        defesaRepository.delete(defesa);
    }

    public List<Defesa> listarTodas() {
        return defesaRepository.findAll();
    }

    public Optional<Defesa> buscarPorId(Long id) {
        return defesaRepository.findById(id);
    }
}
