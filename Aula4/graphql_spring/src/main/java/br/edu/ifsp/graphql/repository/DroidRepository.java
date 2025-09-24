package br.edu.ifsp.graphql.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import br.edu.ifsp.graphql.model.Droid;
import br.edu.ifsp.graphql.model.Episode;
import org.springframework.stereotype.Repository;

@Repository
public class DroidRepository {

    private static List<Droid> droids = new ArrayList<>();

    static {
        droids.add(new Droid("2001", "R2-D2", List.of(Episode.NEWHOPE, Episode.EMPIRE, Episode.JEDI), List.of(), "Astromech"));
        droids.add(new Droid("2002", "C-3PO", List.of(Episode.NEWHOPE, Episode.EMPIRE, Episode.JEDI), List.of(), "Protocol"));
    }

    public List<Droid> findAllDroids() {
        return droids;
    }

    public Optional<Droid> findDroidById(String id) {
        return droids.stream()
                     .filter(droid -> droid.getId().equals(id))
                     .findFirst();
    }

    public void saveDroid(Droid droid) {
        droids.add(droid);
    }

    public void updateDroid(Droid droid) {
        Optional<Droid> existingDroid = findDroidById(droid.getId());
        if (existingDroid.isPresent()) {
            Droid d = existingDroid.get();
            d.setName(droid.getName());
            d.setPrimaryFunction(droid.getPrimaryFunction());
        }
    }

    public void deleteDroid(String id) {
        droids.removeIf(droid -> droid.getId().equals(id));
    }
}