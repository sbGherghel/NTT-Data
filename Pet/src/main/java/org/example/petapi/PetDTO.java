package org.example.petapi;

public record PetDTO(Long id, String name, String owner, String type, String race, int realAge, int humanAge) {

}