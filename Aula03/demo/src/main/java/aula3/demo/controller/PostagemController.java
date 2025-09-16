package aula3.demo.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import aula3.demo.model.Postagem;
import aula3.demo.service.PostagemService;

@RestController
@RequestMapping("/postagens")
public class PostagemController {

    private final PostagemService service;

    public PostagemController(PostagemService service) {
        this.service = service;
    }

    @GetMapping
    public List<Postagem> listarTodas() {
        return service.listarTodas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Postagem> buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Postagem> salvar(@RequestBody Postagem postagem) {
        return ResponseEntity.ok(service.salvar(postagem));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Postagem> atualizar(@PathVariable Long id, @RequestBody Postagem postagem) {
        return service.atualizar(id, postagem)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
