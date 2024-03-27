package com.interid.web.factory;

import com.interid.entity.Animal;
import com.interid.entity.Dog;
import com.interid.web.dto.AnimalDTO;


public class DogFactory implements AnimalFactory{
    @Override
    public Animal createAnimal(AnimalDTO animalDTO) {
        Dog dog = new Dog();
        dog.setName(animalDTO.getName());
        dog.setRunSpeed(animalDTO.getParameter());
        return dog;
    }
}
