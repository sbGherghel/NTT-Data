package org.example.petapi;

import jakarta.persistence.*;
@Entity
@Table(name = "pets")
public class Pet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String owner;
    private String type;
    private String race;
    private int realAge;

    public Pet() {}

    //Constructor
    public Pet(String name, String owner, String type, String race, int realAge){
        this.name = name;
        this.owner = owner;
        this.type = type;
        this.race = race;
        this.realAge = realAge;
    }

    //Getters
    public String getName(){
        return name;
    }
    public String getOwner(){
        return owner;
    }
    public String getType(){
        return type;
    }
    public String getRace(){
        return race;
    }
    public int getRealAge(){
        return realAge;
    }
    public Long getId() {
        return id;
    }

    //calculate human age
    @Transient
    public int getHumanAge(){
        if("dog".equalsIgnoreCase(this.type)){
            return this.realAge*7;
        } else if ("cat".equalsIgnoreCase(this.type)){
            return this.realAge*6;
        }
        return this.realAge*5;
    }

    //Setters
    public void setName(String name) {
        this.name = name;
    }
    public void setOwner(String owner) {
        this.owner = owner;
    }
    public void setType(String type) {
        this.type = type;
    }
    public void setRace(String race) {
        this.race = race;
    }
    public void setRealAge(int realAge) {
        this.realAge = realAge;
    }
    public void setId(Long id) {
        this.id = id;
    }
}
