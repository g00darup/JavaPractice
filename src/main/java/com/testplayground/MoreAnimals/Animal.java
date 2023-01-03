package main.java.com.testplayground.MoreAnimals;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public final class Animal {
    private final String species;
    private final int age;
    private final List<String> favoriteFoods;

    private Animal(String species, int age, List<String> favoriteFoods) {
        this.species = species;
        this.age = age;
        if (favoriteFoods == null) {
            throw new RuntimeException("favoriteFoods is required");
        }
        this.favoriteFoods = new ArrayList<String>(favoriteFoods);
    }

    public String getSpecies() {
        return species;
    }

    public int getAge() {
        return age;
    }

    public int getFavoriteFoodsCount() {
        return favoriteFoods.size();
    }

    public String getFavoriteFood(int index) {
        return favoriteFoods.get(index);
    }

    public static class AnimalBuilder {
        private UUID uid;
        private String species;
        private int age;
        private List<String> favoriteFoods;

        public AnimalBuilder(UUID uid){
            uid=this.uid;
        }

        public AnimalBuilder setSpecies(String species) {
            if (species == null || species.trim().length() == 0) {
                throw new IllegalArgumentException("Species is required");
            }
            this.species = species;
            return this;
        }

        public int getAge() {
            return age;
        }

        public AnimalBuilder setAge(int age) {
            if (age < 0) {
                throw new IllegalArgumentException("Age cannot be a negative number");
            }
            this.age = age;
            return this;
        }

        public AnimalBuilder(List<String> favoriteFoods) {
            if (favoriteFoods == null) {
                throw new RuntimeException("favoriteFoods is required");
            }
            this.favoriteFoods = new ArrayList<>(favoriteFoods);
        }

        public List<String> getFavoriteFoods() { // MAKES CLASS MUTABLE!
            return favoriteFoods;
        }

        public Animal build() {
            return new Animal(species, age, favoriteFoods);
        }
    }

}