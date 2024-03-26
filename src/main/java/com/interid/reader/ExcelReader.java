package com.interid.reader;

import com.interid.web.dto.AnimalDTO;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ExcelReader {
    public static List<AnimalDTO> readAnimalsFromExcel(MultipartFile file) throws IOException {
        List<AnimalDTO> animals = new ArrayList<>();

        Workbook workbook = WorkbookFactory.create(file.getInputStream());
        Sheet sheet = workbook.getSheetAt(0);
        Iterator<Row> rowIterator = sheet.iterator();


        if (rowIterator.hasNext()) {
            rowIterator.next();
        }

        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();
            String type = row.getCell(0).getStringCellValue();
            String name = row.getCell(1).getStringCellValue();
            String parameter = row.getCell(2).getStringCellValue();

            AnimalDTO animalDTO = new AnimalDTO();
            animalDTO.setType(type);
            animalDTO.setName(name);
            animalDTO.setParameter(parameter);

            animals.add(animalDTO);
        }

        return animals;
    }
}
