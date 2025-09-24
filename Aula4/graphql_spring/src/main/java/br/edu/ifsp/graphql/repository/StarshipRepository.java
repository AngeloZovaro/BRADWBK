package br.edu.ifsp.graphql.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import br.edu.ifsp.graphql.model.Starship;
import org.springframework.stereotype.Repository;

@Repository
public class StarshipRepository {

    private static List<Starship> starships = new ArrayList<>();

    static {
        starships.add(new Starship("3000", "Millenium Falcon", 1000f));
        starships.add(new Starship("3001", "X-Wing", 50f));
    }

    public List<Starship> findAllStarships() {
        return starships;
    }

    public Optional<Starship> findStarshipById(String id) {
        return starships.stream()
                     .filter(starship -> starship.getId().equals(id))
                     .findFirst();
    }

    public void saveStarship(Starship starship) {
        starships.add(starship);
    }

    public void updateStarship(Starship starship) {
        Optional<Starship> existingStarship = findStarshipById(starship.getId());
        if (existingStarship.isPresent()) {
            Starship s = existingStarship.get();
            s.setName(starship.getName());
            s.setLength(starship.getLength());
        }
    }

    public void deleteStarship(String id) {
        starships.removeIf(starship -> starship.getId().equals(id));
    }
}