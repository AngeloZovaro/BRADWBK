package br.edu.ifsp.graphql.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import br.edu.ifsp.graphql.model.Human;
import org.springframework.stereotype.Repository;

@Repository
public class HumanRepository {

    private static List<Human> humans = new ArrayList<>();

    static {
        humans.add(new Human("1001", "Luke Skywalker", List.of(), List.of(), 1.72f));
        humans.add(new Human("1002", "Darth Vader", List.of(), List.of(), 2.02f));
    }

    public List<Human> findAllHumans() {
        return humans;
    }

    public Optional<Human> findHumanById(String id) {
        return humans.stream()
                     .filter(human -> human.getId().equals(id))
                     .findFirst();
    }

    public void saveHuman(Human human) {
        humans.add(human);
    }

    public void updateHuman(Human human) {
        Optional<Human> existingHuman = findHumanById(human.getId());
        if (existingHuman.isPresent()) {
            Human h = existingHuman.get();
            h.setName(human.getName());
            h.setHeight(human.getHeight());
        }
    }

    public void deleteHuman(String id) {
        humans.removeIf(human -> human.getId().equals(id));
    }
}