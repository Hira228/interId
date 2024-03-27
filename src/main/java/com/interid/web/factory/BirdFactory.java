package com.interid.web.factory;

import com.interid.entity.Animal;
import com.interid.entity.Bird;
import com.interid.web.dto.AnimalDTO;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;


public class BirdFactory implements AnimalFactory{
    @Override
    public Animal createAnimal(AnimalDTO animalDTO) throws Exception {
        Bird bird = new Bird();
        bird.setName(animalDTO.getName());
        bird.setFlightSpeed(new BigDecimal(animalDTO.getParameter()));
        if(bird.getFlightSpeed().compareTo(BigDecimal.ZERO) < 0) throw new Exception("Negative speed");
        return bird;
    }

}
