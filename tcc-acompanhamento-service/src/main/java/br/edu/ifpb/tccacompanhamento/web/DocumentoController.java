package br.edu.ifpb.tccacompanhamento.web;

import br.edu.ifpb.tccacompanhamento.domain.Documento;
import br.edu.ifpb.tccacompanhamento.service.DocumentoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/tccacompanhamento/documento")
@Api(value = "DocumentoController Resource", description = "Serviços pertinentes à Documentos de TCCs")
public class DocumentoController {

    private final DocumentoService documentoService;

    public DocumentoController(DocumentoService documentoService) {
        this.documentoService = documentoService;
    }

    @PostMapping
    @ApiOperation(value = "Salva um novo Documento")
    public ResponseEntity<Documento> salvarDocumento(@RequestBody Documento documento) {
        return ResponseEntity.ok().body(documentoService.salvarDocumento(documento));
    }

    @GetMapping("todos")
    @ApiOperation(value = "Lista todos os Documentos")
    public ResponseEntity<List<Documento>> getTodos() {
        return ResponseEntity.ok().body(documentoService.listarTodos());
    }

    @GetMapping
    @ApiOperation(value = "Busca um Documento pelo id")
    public ResponseEntity<Documento> findDocumentoById(@RequestParam("id") Long id) {
        Optional<Documento> documento = documentoService.buscarPorId(id);
        if (documento.isPresent()) return ResponseEntity.ok().body(documento.get());
        else {
            HttpHeaders headers = new HttpHeaders();
            headers.add("message", String.format("Documento de id %d não existe", id));
            return ResponseEntity.notFound().headers(headers).build();
        }
    }

    @PutMapping
    @ApiOperation(value = "Atualiza um Documento com o novo estado")
    public ResponseEntity<Documento> atualizaDocumento (@RequestBody Documento documento) {
        return ResponseEntity.ok().body(documentoService.salvarDocumento(documento));
    }

    @DeleteMapping
    @ApiOperation(value = "Deleta um Documento pelo id")
    public ResponseEntity<Void> deleteDocumento(@RequestParam("id") Long id) {
        Optional<Documento> documento = documentoService.buscarPorId(id);
        if (documento.isPresent()) {
            documentoService.apagarDocumento(documento.get());
            return ResponseEntity.ok().build();
        } else {
            HttpHeaders headers = new HttpHeaders();
            headers.add("message", String.format("Documento de id %d não existe", id));
            return ResponseEntity.notFound().headers(headers).build();
        }
    }

}
