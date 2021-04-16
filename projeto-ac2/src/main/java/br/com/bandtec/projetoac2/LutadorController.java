package br.com.bandtec.projetoac2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/lutadores")
public class LutadorController {

    @Autowired
    private LutadorRepository repository;

    @PostMapping
    public ResponseEntity postLutador(@RequestBody @Valid Lutador novoLutador){
        repository.save(novoLutador);
        return ResponseEntity.status(201).build();
    }

    @GetMapping
    public ResponseEntity getLutador() {
        return ResponseEntity.status(200).body(repository.findAllByOrderByForcaGolpeDesc());
        }

    @GetMapping("/contagem-vivos")
    public ResponseEntity getContagemVivos(){
        int lutadores = repository.countAllByVivoTrue();
        return ResponseEntity.status(200).body(lutadores);
    }
}
