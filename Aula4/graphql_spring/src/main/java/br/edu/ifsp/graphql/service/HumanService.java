package br.edu.ifsp.graphql.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifsp.graphql.model.Human;
import br.edu.ifsp.graphql.repository.HumanRepository;

@Service
public class HumanService {

    @Autowired
    private HumanRepository humanRepository;

    public List<Human> findAllHumans() {
        return humanRepository.findAllHumans();
    }

    public Optional<Human> findHumanById(String id) {
        return humanRepository.findHumanById(id);
    }

    public Human saveHuman(Human human) {
        humanRepository.saveHuman(human);
        return human;
    }

    public Human updateHuman(Human human) {
        humanRepository.updateHuman(human);
        return human;
    }

    public void deleteHuman(String id) {
        humanRepository.deleteHuman(id);
    }
}