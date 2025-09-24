package br.edu.ifsp.graphql.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifsp.graphql.model.Droid;
import br.edu.ifsp.graphql.repository.DroidRepository;

@Service
public class DroidService {

    @Autowired
    private DroidRepository droidRepository;

    public List<Droid> findAllDroids() {
        return droidRepository.findAllDroids();
    }

    public Optional<Droid> findDroidById(String id) {
        return droidRepository.findDroidById(id);
    }

    public Droid saveDroid(Droid droid) {
        droidRepository.saveDroid(droid);
        return droid;
    }

    public Droid updateDroid(Droid droid) {
        droidRepository.updateDroid(droid);
        return droid;
    }

    public void deleteDroid(String id) {
        droidRepository.deleteDroid(id);
    }
}