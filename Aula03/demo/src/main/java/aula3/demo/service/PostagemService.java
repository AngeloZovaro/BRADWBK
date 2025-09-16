package aula3.demo.service;

import aula3.demo.model.Postagem;
import aula3.demo.repository.PostagemRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostagemService {

    private final PostagemRepository repository;

    public PostagemService(PostagemRepository repository) {
        this.repository = repository;
    }

    public List<Postagem> listarTodas() {
        return repository.findAll();
    }

    public Optional<Postagem> buscarPorId(Long id) {
        return repository.findById(id);
    }

    public Postagem salvar(Postagem postagem) {
        return repository.save(postagem);
    }

    public Optional<Postagem> atualizar(Long id, Postagem novaPostagem) {
        return repository.findById(id).map(postagem -> {
            postagem.setTitulo(novaPostagem.getTitulo());
            postagem.setConteudo(novaPostagem.getConteudo());
            return repository.save(postagem);
        });
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }
}
