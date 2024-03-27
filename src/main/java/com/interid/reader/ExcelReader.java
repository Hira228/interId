package com.interid.reader;

import com.interid.web.dto.AnimalDTO;
import org.apache.poi.ss.usermodel.*;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ExcelReader {
    public static List<AnimalDTO> readAnimalsFromExcel(MultipartFile file) throws IOException {
        List<AnimalDTO> animals = new ArrayList<>();
        try {
            Workbook workbook = WorkbookFactory.create(file.getInputStream());
            Sheet sheet = workbook.getSheetAt(0);
            Iterator<Row> rowIterator = sheet.iterator();

            if (rowIterator.hasNext()) {
                rowIterator.next();
            }

            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();
                String type = getStringValueFromCell(row.getCell(0));
                String name = getStringValueFromCell(row.getCell(1));
                String parameter = getStringValueFromCell(row.getCell(2));

                AnimalDTO animalDTO = new AnimalDTO();
                animalDTO.setType(type);
                animalDTO.setName(name);
                animalDTO.setParameter(parameter);

                animals.add(animalDTO);
            }
        } catch (IOException e) {
            throw new IOException("Failed to read Excel file: " + e.getMessage());
        }

        return animals;
    }

    private static String getStringValueFromCell(Cell cell) {
        if (cell == null) {
            return null;
        }
        return switch (cell.getCellType()) {
            case STRING -> cell.getStringCellValue();
            case NUMERIC -> String.valueOf(cell.getNumericCellValue());
            default -> null;
        };
    }
}
