package com.interid.web.factory;

import com.interid.entity.Animal;
import com.interid.entity.Bird;
import com.interid.entity.Dog;
import com.interid.web.dto.AnimalDTO;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class AnimalFactoryImpl implements AnimalFactory{
    @Override
    public Animal createAnimalFromDTO(AnimalDTO animalDTO) {
        String type = animalDTO.getType();
        String name = animalDTO.getName();
        String parameter = animalDTO.getParameter();

        if ("Собака".equals(type)) {
            Dog dog = new Dog();
            dog.setName(name);
            dog.setRunSpeed(parameter);
            return dog;
        } else if ("Птица".equals(type)) {
            Bird bird = new Bird();
            bird.setName(name);
            bird.setFightSpeed(new BigDecimal(parameter));
            return bird;
        } else {
            throw new IllegalArgumentException("Invalid animal type: " + type);
        }
    }
}
