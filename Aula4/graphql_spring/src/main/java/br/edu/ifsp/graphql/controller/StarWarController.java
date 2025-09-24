package br.edu.ifsp.graphql.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import br.edu.ifsp.graphql.model.Character;
import br.edu.ifsp.graphql.model.Droid;
import br.edu.ifsp.graphql.model.Human;
import br.edu.ifsp.graphql.model.Review;
import br.edu.ifsp.graphql.model.ReviewInput;
import br.edu.ifsp.graphql.model.Starship;
import br.edu.ifsp.graphql.model.HumanInput;
import br.edu.ifsp.graphql.model.DroidInput;
import br.edu.ifsp.graphql.model.StarshipInput;

import br.edu.ifsp.graphql.service.CharacterService;
import br.edu.ifsp.graphql.service.DroidService;
import br.edu.ifsp.graphql.service.HumanService;
import br.edu.ifsp.graphql.service.ReviewService;
import br.edu.ifsp.graphql.service.StarshipService;

@Controller
public class StarWarController {

    @Autowired
    private HumanService humanService;

    @Autowired
    private DroidService droidService;

    @Autowired
    private StarshipService starshipService;

    @Autowired
    private CharacterService characterService;

    @Autowired
    private ReviewService reviewService;

    @QueryMapping
    public Character hero() {
        return droidService.findDroidById("2001").orElse(null);
    }

    @QueryMapping
    public Droid droid(@Argument String id) {
        return droidService.findDroidById(id).orElse(null);
    }

    @QueryMapping
    public List<Object> search(@Argument String text) {
        return List.of(
            new Droid("2001", "R2-D2", List.of(), List.of(), "Astromech"),
            new Human("1001", "Luke", List.of(), List.of(), 1.72f),
            new Starship("3000", "Millenium Falcon", 1000f)
        );
    }

    @MutationMapping
    public Review createReview(@Argument ReviewInput review) {
        return reviewService.createReview(review);
    }
    

    @QueryMapping
    public List<Human> humans() {
        return humanService.findAllHumans();
    }

    @QueryMapping
    public List<Starship> starships() {
        return starshipService.findAllStarships();
    }

    @QueryMapping
    public Character character(@Argument String id) {
        return characterService.findCharacterById(id).orElse(null);
    }


    @MutationMapping
    public Human createHuman(@Argument HumanInput humanInput) {
        Human newHuman = new Human(humanInput.getId(), humanInput.getName(), List.of(), List.of(), humanInput.getHeight());
        return humanService.saveHuman(newHuman);
    }

    @MutationMapping
    public Droid createDroid(@Argument DroidInput droidInput) {
        Droid newDroid = new Droid(droidInput.getId(), droidInput.getName(), List.of(), List.of(), droidInput.getPrimaryFunction());
        return droidService.saveDroid(newDroid);
    }

    @MutationMapping
    public Starship createStarship(@Argument StarshipInput starshipInput) {
        Starship newStarship = new Starship(starshipInput.getId(), starshipInput.getName(), starshipInput.getLength());
        return starshipService.saveStarship(newStarship);
    }

    @MutationMapping
    public Character addFriend(@Argument String characterId, @Argument String friendId) {

        return characterService.addFriend(characterId, friendId);
    }
}