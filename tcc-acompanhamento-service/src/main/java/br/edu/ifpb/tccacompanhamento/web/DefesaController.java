package br.edu.ifpb.tccacompanhamento.web;

import br.edu.ifpb.tccacompanhamento.service.DefesaService;
import br.edu.ifpb.tccacompanhamento.domain.Defesa;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/tccacompanhamento/defesa")
@Api(value = "DefesaController Resource", description = "Serviços pertinentes à Defesas de TCCs")
public class DefesaController {

    private final DefesaService defesaService;

    public DefesaController(DefesaService defesaService) {
        this.defesaService = defesaService;
    }

    @PostMapping
    @ApiOperation(value = "Salva nova Defesa")
    public ResponseEntity<Defesa> salvarDefesa(@RequestBody Defesa defesa) {
        return ResponseEntity.ok().body(defesaService.salvarDefesa(defesa));
    }

    @GetMapping("todas")
    @ApiOperation(value = "Lista todas as Defesas")
    public ResponseEntity<List<Defesa>> getTodas() {
        return ResponseEntity.ok().body(defesaService.listarTodas());
    }

    @GetMapping
    @ApiOperation(value = "Busca uma Defesa por id")
    public ResponseEntity<Defesa> findDefesaById(@RequestParam("id") Long id) {
        Optional<Defesa> defesa = defesaService.buscarPorId(id);
        if (defesa.isPresent()) return ResponseEntity.ok().body(defesa.get());
        else {
            HttpHeaders headers = new HttpHeaders();
            headers.add("message", String.format("Defesa de id %d não existe", id));
            return ResponseEntity.notFound().headers(headers).build();
        }
    }

    @PutMapping
    @ApiOperation(value = "atualiza uma Defesa com o novo estado")
    public ResponseEntity<Defesa> atualizaDefesa (@RequestBody Defesa defesa) {
        return ResponseEntity.ok().body(defesaService.salvarDefesa(defesa));
    }

    @DeleteMapping
    @ApiOperation(value = "Deleta uma Defesa pelo id")
    public ResponseEntity<Void> deleteDefesa(@RequestParam("id") Long id) {
        Optional<Defesa> defesa = defesaService.buscarPorId(id);
        if (defesa.isPresent()) {
            defesaService.apagarDefesa(defesa.get());
            return ResponseEntity.ok().build();
        } else {
            HttpHeaders headers = new HttpHeaders();
            headers.add("message", String.format("Defesa de id %d não existe", id));
            return ResponseEntity.notFound().headers(headers).build();
        }
    }

}