package br.edu.ifpb.tccacompanhamento.service;

import br.edu.ifpb.tccacompanhamento.domain.Banca;
import br.edu.ifpb.tccacompanhamento.repository.BancaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BancaService {

    private final BancaRepository bancaRepository;

    public BancaService(BancaRepository bancaRepository) {
        this.bancaRepository = bancaRepository;
    }

    public Banca salvarBanca(Banca banca) {
        return bancaRepository.save(banca);
    }

    public Banca atualizarBanca(Banca bancaAtualizada) {
        return bancaRepository.save(bancaAtualizada);
    }

    public void apagarBanca(Banca banca) {
        bancaRepository.delete(banca);
    }

    public List<Banca> listarTodas() {
        return bancaRepository.findAll();
    }

    public Optional<Banca> buscarPorId(Long id) {
        return bancaRepository.findById(id);
    }
}
