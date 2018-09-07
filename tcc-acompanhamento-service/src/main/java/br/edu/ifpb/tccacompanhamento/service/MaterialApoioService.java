package br.edu.ifpb.tccacompanhamento.service;

import br.edu.ifpb.tccacompanhamento.domain.MaterialApoio;
import br.edu.ifpb.tccacompanhamento.repository.MaterialApoioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MaterialApoioService {

    private final MaterialApoioRepository materialApoioRepository;

    public MaterialApoioService(MaterialApoioRepository materialApoioRepository) {
        this.materialApoioRepository = materialApoioRepository;
    }

    public MaterialApoio salvarMaterialApoio(MaterialApoio materialApoio) {
        return materialApoioRepository.save(materialApoio);
    }

    public MaterialApoio atualizarMaterialApoio(MaterialApoio materialApoioAtualizado) {
        return materialApoioRepository.save(materialApoioAtualizado);
    }

    public void apagarMaterialApoio(MaterialApoio materialApoio) {
        materialApoioRepository.delete(materialApoio);
    }

    public List<MaterialApoio> listarTodos() {
        return materialApoioRepository.findAll();
    }

    public Optional<MaterialApoio> buscarPorId(Long id) {
        return materialApoioRepository.findById(id);
    }
}
