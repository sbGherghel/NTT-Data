package org.example.petapi;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class PetController {

    @GetMapping("/pets")
    public List<Pet> getPets(@RequestParam(required = false) String type){
        List<Pet> petList = new ArrayList<>();

        petList.add(new Pet("Rex", "Alice", "dog", "German Shepherd", 3));
        petList.add(new Pet("Luna", "Bob", "cat", "Maine Coon", 2));
        petList.add(new Pet("Bubbles", "Dan", "Fish", "Goldfish", 1));
        petList.add(new Pet("Buddy", "Eve", "dog", "Golden Retriever", 5));

        if (type != null && !type.isEmpty()) {
            return petList.stream()
                    .filter(pet -> type.equalsIgnoreCase(pet.getType()))
                    .collect(Collectors.toList());
        }

        return petList;
    }
}
