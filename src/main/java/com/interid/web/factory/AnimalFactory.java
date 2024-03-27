package com.interid.web.factory;

import com.interid.entity.Animal;
import com.interid.web.dto.AnimalDTO;
import org.springframework.stereotype.Component;


public interface AnimalFactory {
    Animal createAnimal(AnimalDTO animalDTO) throws Exception;
}
