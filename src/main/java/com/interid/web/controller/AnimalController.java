package com.interid.web.controller;

import com.interid.reader.ExcelReader;
import com.interid.service.AnimalService;
import com.interid.web.dto.AnimalDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/animals")
public class AnimalController {
    private final AnimalService animalService;

    @PostMapping("/import")
    public ResponseEntity<?> importFromExcel(@RequestParam("file") MultipartFile multipartFile) {
        try {
            if (multipartFile.isEmpty()) {
                return ResponseEntity.badRequest().body("Uploaded file is empty.");
            }

            List<AnimalDTO> animalDTOs = ExcelReader.readAnimalsFromExcel(multipartFile);
            animalService.saveAnimalsFromDTOs(animalDTOs);
            return ResponseEntity.ok("Animals imported successfully.");

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error importing animals: " + e.getMessage());
        }
    }


}
