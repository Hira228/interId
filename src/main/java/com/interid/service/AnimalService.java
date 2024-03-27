package com.interid.service;

import com.interid.entity.Animal;
import com.interid.repository.AnimalRepository;
import com.interid.web.dto.AnimalDTO;
import com.interid.web.factory.AnimalFactory;
import com.interid.web.factory.BirdFactory;
import com.interid.web.factory.DogFactory;
import jakarta.transaction.Transactional;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
public class AnimalService {
    private final AnimalRepository animalRepository;
    private final Map<String, AnimalFactory> factoryMap;

    @Transactional(rollbackOn = Exception.class)
    public void saveAnimalsFromDTOs(List<AnimalDTO> animalDTOs) throws Exception {
        for (AnimalDTO animalDTO : animalDTOs) {
            AnimalFactory factory = factoryMap.get(animalDTO.getType());
            if (factory == null) {
                throw new Exception("No factory found for type: " + animalDTO.getParameter());
            }
            Animal animal = factory.createAnimal(animalDTO);
            animalRepository.save(animal);
        }
    }
}
