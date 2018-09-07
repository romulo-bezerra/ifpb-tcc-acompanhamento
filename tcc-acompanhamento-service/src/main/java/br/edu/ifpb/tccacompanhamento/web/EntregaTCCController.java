package br.edu.ifpb.tccacompanhamento.web;

import br.edu.ifpb.tccacompanhamento.domain.EntregaTCC;
import br.edu.ifpb.tccacompanhamento.service.EntregaTCCService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/tccacompanhamento/entregatcc")
@Api(value = "EntregaTCCController Resource", description = "Serviços pertinentes à Entregas de TCCs")
public class EntregaTCCController {

    private final EntregaTCCService entregaTCCService;

    public EntregaTCCController(EntregaTCCService entregaTCCService) {
        this.entregaTCCService = entregaTCCService;
    }

    @PostMapping
    @ApiOperation(value = "Salva uma nova Entrega de TCC")
    public ResponseEntity<EntregaTCC> salvarEntregaTCC(@RequestBody EntregaTCC entregaTCC) {
        return ResponseEntity.ok().body(entregaTCCService.salvarEntregaTCC(entregaTCC));
    }

    @GetMapping("todas")
    @ApiOperation(value = "Lista todas as Entregas de TCCs")
    public ResponseEntity<List<EntregaTCC>> getTodas() {
        return ResponseEntity.ok().body(entregaTCCService.listarTodas());
    }

    @GetMapping
    @ApiOperation(value = "Busca uma Entrega de TCC pelo id")
    public ResponseEntity<EntregaTCC> findEntregaTCCById(@RequestParam("id") Long id) {
        Optional<EntregaTCC> entregaTCC = entregaTCCService.buscarPorId(id);
        if (entregaTCC.isPresent()) return ResponseEntity.ok().body(entregaTCC.get());
        else {
            HttpHeaders headers = new HttpHeaders();
            headers.add("message", String.format("EntregaTCC de id %d não existe", id));
            return ResponseEntity.notFound().headers(headers).build();
        }
    }

    @PutMapping
    @ApiOperation(value = "Atualiza uma Entrega de TCC com o novo estado")
    public ResponseEntity<EntregaTCC> atualizaEntregaTCC (@RequestBody EntregaTCC entregaTCC) {
        return ResponseEntity.ok().body(entregaTCCService.salvarEntregaTCC(entregaTCC));
    }

    @DeleteMapping
    @ApiOperation(value = "Deleta uma Entrega de TCC pelo id")
    public ResponseEntity<Void> deleteEntregaTCC(@RequestParam("id") Long id) {
        Optional<EntregaTCC> entregaTCC = entregaTCCService.buscarPorId(id);
        if (entregaTCC.isPresent()) {
            entregaTCCService.apagarEntregaTCC(entregaTCC.get());
            return ResponseEntity.ok().build();
        } else {
            HttpHeaders headers = new HttpHeaders();
            headers.add("message", String.format("EntregaTCC de id %d não existe", id));
            return ResponseEntity.notFound().headers(headers).build();
        }
    }

}
