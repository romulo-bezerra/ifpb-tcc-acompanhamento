package br.edu.ifpb.tccacompanhamento.service;

import br.edu.ifpb.tccacompanhamento.domain.ComentarioBanca;
import br.edu.ifpb.tccacompanhamento.repository.ComentarioBancaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ComentarioBancaService {

    private final ComentarioBancaRepository comentarioBancaRepository;

    public ComentarioBancaService(ComentarioBancaRepository comentarioBancaRepository) {
        this.comentarioBancaRepository = comentarioBancaRepository;
    }

    public ComentarioBanca salvarComentarioBanca(ComentarioBanca comentarioBanca) {
        return comentarioBancaRepository.save(comentarioBanca);
    }

    public ComentarioBanca atualizarComentarioBanca(ComentarioBanca comentarioBancaAtualizado) {
        return comentarioBancaRepository.save(comentarioBancaAtualizado);
    }

    public void apagarComentarioBanca(ComentarioBanca comentarioBanca) {
        comentarioBancaRepository.delete(comentarioBanca);
    }

    public List<ComentarioBanca> listarTodos() {
        return comentarioBancaRepository.findAll();
    }

    public Optional<ComentarioBanca> buscarPorId(Long id) {
        return comentarioBancaRepository.findById(id);
    }
}
