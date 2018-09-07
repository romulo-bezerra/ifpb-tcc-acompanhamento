package br.edu.ifpb.tccacompanhamento.web;


import br.edu.ifpb.tccacompanhamento.domain.Banca;
import br.edu.ifpb.tccacompanhamento.service.BancaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/tccacompanhamento/banca")
@Api(value = "BancaController Resource", description = "Serviços pertinentes à Bancas de TCCs")
public class BancaController {

    private final BancaService bancaService;

    public BancaController(BancaService bancaService) {
        this.bancaService = bancaService;
    }

    @PostMapping
    @ApiOperation(value = "Salva nova banca de TCC")
    public ResponseEntity<Banca> salvarBanca(@RequestBody Banca banca) {
        return ResponseEntity.ok().body(bancaService.salvarBanca(banca));
    }

    @GetMapping("todas")
    @ApiOperation(value = "Lista todas as bancas de TCCs")
    public ResponseEntity<List<Banca>> getTodas() {
        return ResponseEntity.ok().body(bancaService.listarTodas());
    }

    @GetMapping
    @ApiOperation(value = "Busca banca de TCC pelo id")
    public ResponseEntity<Banca> findBancaById(@RequestParam("id") Long id) {
        Optional<Banca> banca = bancaService.buscarPorId(id);
        if (banca.isPresent()) return ResponseEntity.ok().body(banca.get());
        else {
            HttpHeaders headers = new HttpHeaders();
            headers.add("message", String.format("Banca de id %d não existe", id));
            return ResponseEntity.notFound().headers(headers).build();
        }
    }

    @PutMapping
    @ApiOperation(value = "Atuliza banca com o novo estado do objeto")
    public ResponseEntity<Banca> atualizaBanca (@RequestBody Banca banca) {
        return ResponseEntity.ok().body(bancaService.salvarBanca(banca));
    }

    @DeleteMapping
    @ApiOperation(value = "Deleta banca pelo id")
    public ResponseEntity<Void> deleteBanca(@RequestParam("id") Long id) {
        Optional<Banca> banca = bancaService.buscarPorId(id);
        if (banca.isPresent()) {
            bancaService.apagarBanca(banca.get());
            return ResponseEntity.ok().build();
        } else {
            HttpHeaders headers = new HttpHeaders();
            headers.add("message", String.format("Banca de id %d não existe", id));
            return ResponseEntity.notFound().headers(headers).build();
        }
    }

}
