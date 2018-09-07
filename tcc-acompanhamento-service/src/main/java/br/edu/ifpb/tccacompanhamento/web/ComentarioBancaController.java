package br.edu.ifpb.tccacompanhamento.web;

import br.edu.ifpb.tccacompanhamento.domain.ComentarioBanca;
import br.edu.ifpb.tccacompanhamento.service.ComentarioBancaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/tccacompanhamento/comentariobanca")
@Api(value = "ComentarioBancaController Resource", description = "Serviços pertinentes à Comentarios de Bancas")
public class ComentarioBancaController {

    private final ComentarioBancaService comentarioBancaService;

    public ComentarioBancaController(ComentarioBancaService comentarioBancaService) {
        this.comentarioBancaService = comentarioBancaService;
    }

    @PostMapping
    @ApiOperation(value = "Salva novo Comentario de Banca")
    public ResponseEntity<ComentarioBanca> salvarComentarioBanca(@RequestBody ComentarioBanca comentarioBanca) {
        return ResponseEntity.ok().body(comentarioBancaService.salvarComentarioBanca(comentarioBanca));
    }

    @GetMapping("todos")
    @ApiOperation(value = "Lista todos os Comentarios de Bancas")
    public ResponseEntity<List<ComentarioBanca>> getTodos() {
        return ResponseEntity.ok().body(comentarioBancaService.listarTodos());
    }

    @GetMapping
    @ApiOperation(value = "Busca Comentario de Banca pelo id")
    public ResponseEntity<ComentarioBanca> findComentarioBancaById(@RequestParam("id") Long id) {
        Optional<ComentarioBanca> comentarioBanca = comentarioBancaService.buscarPorId(id);
        if (comentarioBanca.isPresent()) return ResponseEntity.ok().body(comentarioBanca.get());
        else {
            HttpHeaders headers = new HttpHeaders();
            headers.add("message", String.format("ComentarioBanca de id %d não existe", id));
            return ResponseEntity.notFound().headers(headers).build();
        }
    }

    @PutMapping
    @ApiOperation(value = "Atulaliza um Comentario de banca com o novo estado")
    public ResponseEntity<ComentarioBanca> atualizaComentarioBanca (@RequestBody ComentarioBanca comentarioBanca) {
        return ResponseEntity.ok().body(comentarioBancaService.salvarComentarioBanca(comentarioBanca));
    }

    @DeleteMapping
    @ApiOperation(value = "Deleta um Comentario de Banca pelo id")
    public ResponseEntity<Void> deleteComentarioBanca(@RequestParam("id") Long id) {
        Optional<ComentarioBanca> comentarioBanca = comentarioBancaService.buscarPorId(id);
        if (comentarioBanca.isPresent()) {
            comentarioBancaService.apagarComentarioBanca(comentarioBanca.get());
            return ResponseEntity.ok().build();
        } else {
            HttpHeaders headers = new HttpHeaders();
            headers.add("message", String.format("ComentarioBanca de id %d não existe", id));
            return ResponseEntity.notFound().headers(headers).build();
        }
    }

}
