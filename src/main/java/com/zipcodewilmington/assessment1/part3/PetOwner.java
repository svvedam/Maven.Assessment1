package com.zipcodewilmington.assessment1.part3;

import java.lang.reflect.Array;
import java.util.*;

/**
 * Created by leon on 2/16/18.
 */
public class PetOwner {

    List<Pet> petList;
    String petOwnerName;

    public PetOwner(){
        this.petOwnerName = "Pet Owner";
        this.petList = new ArrayList<>();
    }
    public PetOwner(String name, Pet... pets) {
        this.petOwnerName = name;
        if(pets == null){
            this.petList = new ArrayList<>();
            Pet p = new Dog();
            pets= new Pet[1];
            pets[0]= p;
        }
        else{
            this.petList = new ArrayList<>(Arrays.asList(pets));
        }
        for(int i =0;i<pets.length;i++){
            pets[i].setOwner(this);
        }
    }
    public PetOwner(String name, Dog dog, Cat cat){
        this.petOwnerName = name;
        petList.add(dog);
        petList.add(cat);
    }

    /**
     * @param pet pet to be added to the composite collection of Pets
     */
    public void addPet(Pet pet) {


        petList.add(pet);
    }

    /**
     * @param pet pet to be removed from the composite collection Pets
     */
    public void removePet(Pet pet) {
        if(petList.contains(pet)){
            petList.remove(pet);
        }
        else if(petList == null) {
            petList.add(pet);
            petList.remove(pet);
        }

    }

    /**
     * @param pet pet to evaluate ownership of
     * @return true if I own this pet
     */
    public Boolean isOwnerOf(Pet pet) {
        Boolean flag = false;
        if(petList.contains(pet))
        {
            flag = true;
        }
        return flag;
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

        Collections.sort(petList,petAge);
        return petList.get(0).age;
    }

    /**
     * @return the age of the Pet object whose age field is the highest amongst all Pets in this class
     */
    public Integer getOldestPetAge() {
        Collections.sort(petList,petAge);
        return petList.get(petList.size()-1).age;
    }


    /**
     * @return the sum of ages of Pet objects stored in this class divided by the number of Pet object
     */
    public Float getAveragePetAge() {
        float sum=0;
        for(Pet p:petList){
           sum += p.getAge();
        }
        float average = sum/petList.size();
        return average;
    }

    /**
     * @return the number of Pet objects stored in this class
     */
    public Integer getNumberOfPets() {
        return petList.size();
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
        Pet[] returnArray;
        if(petList.size()==0){
            returnArray = new Pet[1];
            Pet p = null;
            returnArray[0] = p;
        }
        else {
            returnArray = petList.toArray(new Pet[petList.size()]);
        }
        return returnArray;
    }
}
