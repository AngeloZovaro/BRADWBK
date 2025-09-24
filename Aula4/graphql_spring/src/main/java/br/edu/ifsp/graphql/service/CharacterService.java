package br.edu.ifsp.graphql.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifsp.graphql.model.Character;
import br.edu.ifsp.graphql.model.Droid;
import br.edu.ifsp.graphql.model.Human;
import br.edu.ifsp.graphql.repository.DroidRepository;
import br.edu.ifsp.graphql.repository.HumanRepository;

@Service
public class CharacterService {

    @Autowired
    private HumanRepository humanRepository;

    @Autowired
    private DroidRepository droidRepository;
    public Optional<Character> findCharacterById(String id) {
        Optional<Human> human = humanRepository.findHumanById(id);
        if (human.isPresent()) {
            return Optional.of(human.get());
        }

        Optional<Droid> droid = droidRepository.findDroidById(id);
        if (droid.isPresent()) {
            return Optional.of(droid.get());
        }

        return Optional.empty();
    }

    public Character addFriend(String characterId, String friendId) {
        Optional<Character> characterOptional = findCharacterById(characterId);
        Optional<Character> friendOptional = findCharacterById(friendId);

        if (characterOptional.isPresent() && friendOptional.isPresent()) {
            Character character = characterOptional.get();
            Character friend = friendOptional.get();
            character.getFriends().add(friend);
            return character;
        }

        return null;
    }
}