package br.edu.ifpb.tccacompanhamento.service;

import br.edu.ifpb.tccacompanhamento.domain.Documento;
import br.edu.ifpb.tccacompanhamento.repository.DocumentoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DocumentoService {

    private final DocumentoRepository documentoRepository;

    public DocumentoService(DocumentoRepository documentoRepository) {
        this.documentoRepository = documentoRepository;
    }

    public Documento salvarDocumento(Documento documento) {
        return documentoRepository.save(documento);
    }

    public Documento atualizarDocumento(Documento documentoAtualizado) {
        return documentoRepository.save(documentoAtualizado);
    }

    public void apagarDocumento(Documento documento) {
        documentoRepository.delete(documento);
    }

    public List<Documento> listarTodos() {
        return documentoRepository.findAll();
    }

    public Optional<Documento> buscarPorId(Long id) {
        return documentoRepository.findById(id);
    }
}
