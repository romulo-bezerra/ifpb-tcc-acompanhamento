package br.edu.ifpb.tccacompanhamento.web;

import br.edu.ifpb.tccacompanhamento.domain.TCC;
import br.edu.ifpb.tccacompanhamento.service.TCCService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/tccacompanhamento/tcc")
@Api(value = "TCCController Resource", description = "Serviços pertinentes à TCCs")
public class TCCController {

    private final TCCService tccService;

    public TCCController(TCCService tccService) {
        this.tccService = tccService;
    }

    @PostMapping
    @ApiOperation(value = "Salva novo TCC")
    public ResponseEntity<TCC> salvarTCC(@RequestBody TCC tcc) {
        return ResponseEntity.ok().body(tccService.salvarTCC(tcc));
    }

    @GetMapping("todos")
    @ApiOperation(value = "Lista todos os TCCs")
    public ResponseEntity<List<TCC>> getTodos() {
        return ResponseEntity.ok().body(tccService.listarTodos());
    }

    @GetMapping
    @ApiOperation(value = "Busca TCC pelo id")
    public ResponseEntity<TCC> findTCCById(@RequestParam("id") Long id) {
        Optional<TCC> tcc = tccService.buscarPorId(id);
        if (tcc.isPresent()) return ResponseEntity.ok().body(tcc.get());
        else {
            HttpHeaders headers = new HttpHeaders();
            headers.add("message", String.format("TCC de id %d não existe", id));
            return ResponseEntity.notFound().headers(headers).build();
        }
    }

    @PutMapping
    @ApiOperation(value = "Atualiza TCC com o novo estado")
    public ResponseEntity<TCC> atualizaTCC (@RequestBody TCC tcc) {
        return ResponseEntity.ok().body(tccService.salvarTCC(tcc));
    }

    @DeleteMapping
    @ApiOperation(value = "Deleta um TCC pelo id")
    public ResponseEntity<Void> deleteTCC(@RequestParam("id") Long id) {
        Optional<TCC> tcc = tccService.buscarPorId(id);
        if (tcc.isPresent()) {
            tccService.apagarTCC(tcc.get());
            return ResponseEntity.ok().build();
        } else {
            HttpHeaders headers = new HttpHeaders();
            headers.add("message", String.format("TCC de id %d não existe", id));
            return ResponseEntity.notFound().headers(headers).build();
        }
    }

}
