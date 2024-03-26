package com.interid.service;

import com.interid.entity.Animal;
import com.interid.repository.AnimalRepository;
import com.interid.web.dto.AnimalDTO;
import com.interid.web.factory.AnimalFactory;
import jakarta.transaction.Transactional;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
public class AnimalService {
    private final AnimalFactory animalFactory;
    private final AnimalRepository animalRepository;


    @Transactional
    public void saveAnimalsFromDTOs(List<AnimalDTO> animalDTOs) {
        for (AnimalDTO animalDTO : animalDTOs) {
            Animal animal = animalFactory.createAnimalFromDTO(animalDTO);
            animalRepository.save(animal);
        }
    }
}
