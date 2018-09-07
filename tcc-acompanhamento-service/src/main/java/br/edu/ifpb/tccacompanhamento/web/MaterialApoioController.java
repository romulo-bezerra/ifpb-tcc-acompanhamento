package br.edu.ifpb.tccacompanhamento.web;

import br.edu.ifpb.tccacompanhamento.domain.MaterialApoio;
import br.edu.ifpb.tccacompanhamento.service.MaterialApoioService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/tccacompanhamento/materialapoio")
@Api(value = "MaterialApoioController Resource", description = "Serviços pertinentes à Materiais de Apoio")
public class MaterialApoioController {

    private final MaterialApoioService materialApoioService;

    public MaterialApoioController(MaterialApoioService materialApoioService) {
        this.materialApoioService = materialApoioService;
    }

    @PostMapping
    @ApiOperation(value = "Salva novo Material de Apoio")
    public ResponseEntity<MaterialApoio> salvarMaterialApoio(@RequestBody MaterialApoio materialApoio) {
        return ResponseEntity.ok().body(materialApoioService.salvarMaterialApoio(materialApoio));
    }

    @GetMapping("todos")
    @ApiOperation(value = "Lista todos os Materiais de Apoio")
    public ResponseEntity<List<MaterialApoio>> getTodos() {
        return ResponseEntity.ok().body(materialApoioService.listarTodos());
    }

    @GetMapping
    @ApiOperation(value = "Busca Material de Apoio pro id")
    public ResponseEntity<MaterialApoio> findMaterialApoioById(@RequestParam("id") Long id) {
        Optional<MaterialApoio> materialApoio = materialApoioService.buscarPorId(id);
        if (materialApoio.isPresent()) return ResponseEntity.ok().body(materialApoio.get());
        else {
            HttpHeaders headers = new HttpHeaders();
            headers.add("message", String.format("MaterialApoio de id %d não existe", id));
            return ResponseEntity.notFound().headers(headers).build();
        }
    }

    @PutMapping
    @ApiOperation(value = "Atualiza Material de Apoio com o novo estado")
    public ResponseEntity<MaterialApoio> atualizaMaterialApoio (@RequestBody MaterialApoio materialApoio) {
        return ResponseEntity.ok().body(materialApoioService.salvarMaterialApoio(materialApoio));
    }

    @DeleteMapping
    @ApiOperation(value = "Deleta Material de Apoio pelo id")
    public ResponseEntity<Void> deleteMaterialApoio(@RequestParam("id") Long id) {
        Optional<MaterialApoio> materialApoio = materialApoioService.buscarPorId(id);
        if (materialApoio.isPresent()) {
            materialApoioService.apagarMaterialApoio(materialApoio.get());
            return ResponseEntity.ok().build();
        } else {
            HttpHeaders headers = new HttpHeaders();
            headers.add("message", String.format("MaterialApoio de id %d não existe", id));
            return ResponseEntity.notFound().headers(headers).build();
        }
    }

}
