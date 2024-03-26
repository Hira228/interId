package com.interid.web.factory;

import com.interid.entity.Animal;
import com.interid.web.dto.AnimalDTO;

public interface AnimalFactory {
    Animal createAnimalFromDTO(AnimalDTO animalDTO);
}
