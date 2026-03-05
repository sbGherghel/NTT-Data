package org.example.petapi;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/pets")
public class PetController {

    private final PetRepository repository;

    public PetController(PetRepository repository) {
        this.repository = repository;
    }

    // Helper to convert Entity to DTO
    private PetDTO convertToDto(Pet pet) {
        return new PetDTO(pet.getId(), pet.getName(), pet.getOwner(),
                pet.getType(), pet.getRace(), pet.getRealAge(), pet.getHumanAge());
    }

    @GetMapping
    public List<PetDTO> getAll(@RequestParam(required = false) String type) {
        List<Pet> pets = (type != null) ? repository.findByTypeIgnoreCase(type) : repository.findAll();
        return pets.stream().map(this::convertToDto).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public PetDTO getOne(@PathVariable Long id) {
        return repository.findById(id).map(this::convertToDto)
                .orElseThrow(() -> new RuntimeException("Pet not found"));
    }

    @PostMapping
    public PetDTO create(@RequestBody Pet pet) {
        return convertToDto(repository.save(pet));
    }

    @PutMapping("/{id}")
    public PetDTO update(@PathVariable Long id, @RequestBody Pet newPet) {
        return repository.findById(id).map(pet -> {
            pet.setName(newPet.getName());
            pet.setOwner(newPet.getOwner());
            pet.setType(newPet.getType());
            pet.setRace(newPet.getRace());
            pet.setRealAge(newPet.getRealAge());
            return convertToDto(repository.save(pet));
        }).orElseThrow(() -> new RuntimeException("Pet not found"));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
