package com.zipcodewilmington.assessment1.part3;

import java.util.*;

/**
 * Created by leon on 2/16/18.
 */
public class PetOwner {

    List<Pet> pets = new ArrayList<Pet>();
    String petOwnerName;
    /**
     * @param name name of the owner of the Pet
     * @param pets array of Pet object
     */
    public PetOwner(){
        this.petOwnerName = null;
        this.pets = null;
    }
    public PetOwner(String name, Pet... pets) {
        this.petOwnerName = name;
        this.pets= Arrays.asList(pets);
    }
    public PetOwner(String name, Dog dog, Cat cat){
        this.petOwnerName = name;
        pets.add(dog);
        pets.add(cat);
    }

    /**
     * @param pet pet to be added to the composite collection of Pets
     */
    public void addPet(Pet pet) {
        pets.add(pet);
    }

    /**
     * @param pet pet to be removed from the composite collection Pets
     */
    public void removePet(Pet pet) {
        pets.remove(pet);
    }

    /**
     * @param pet pet to evaluate ownership of
     * @return true if I own this pet
     */
    public Boolean isOwnerOf(Pet pet) {
        /*if()
        return true;
        else*/
        return true;
    }
    public static Comparator<Pet>petAge = new Comparator<Pet>(){
        public int compare(Pet p1, Pet p2){
            int age1 = p1.getAge();
            int age2 = p2.getAge();

            //For ascending order of ages
            return age1-age2;

        }
    };
    /**
     * @return the age of the Pet object whose age field is the lowest amongst all Pets in this class
     */
    public Integer getYoungetPetAge() {

        Collections.sort(pets,petAge);
        return pets.get(0).age;
    }

    /**
     * @return the age of the Pet object whose age field is the highest amongst all Pets in this class
     */
    public Integer getOldestPetAge() {
        Collections.sort(pets,petAge);
        return pets.get(pets.size()-1).age;
    }


    /**
     * @return the sum of ages of Pet objects stored in this class divided by the number of Pet object
     */
    public Float getAveragePetAge() {
        float sum=0;
        for(Pet p:pets){
           sum += p.getAge();
        }
        float average = sum/pets.size();
        return average;
    }

    /**
     * @return the number of Pet objects stored in this class
     */
    public Integer getNumberOfPets() {
        return pets.size();
    }

    /**
     * @return the name property of the Pet
     */
    public String getName() {
        return petOwnerName;
    }

    /**
     * @return array representation of animals owned by this PetOwner
     */
    public Pet[] getPets() {
        Pet [] returnArray = pets.toArray(new Pet[pets.size()]);
        return returnArray;
    }
}
