package br.edu.ifsp.graphql.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifsp.graphql.model.Starship;
import br.edu.ifsp.graphql.repository.StarshipRepository;

@Service
public class StarshipService {

    @Autowired
    private StarshipRepository starshipRepository;

    public List<Starship> findAllStarships() {
        return starshipRepository.findAllStarships();
    }

    public Optional<Starship> findStarshipById(String id) {
        return starshipRepository.findStarshipById(id);
    }

    public Starship saveStarship(Starship starship) {
        starshipRepository.saveStarship(starship);
        return starship;
    }

    public Starship updateStarship(Starship starship) {
        starshipRepository.updateStarship(starship);
        return starship;
    }

    public void deleteStarship(String id) {
        starshipRepository.deleteStarship(id);
    }
}