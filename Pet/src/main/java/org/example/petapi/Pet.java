package org.example.petapi;


public class Pet {
    private String name;
    private String owner;
    private String type;
    private String race;
    private int realAge;

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

    //calculate human age
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
}
