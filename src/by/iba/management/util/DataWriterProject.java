package by.iba.management.util;

import by.iba.management.model.entity.Project;
import by.iba.management.model.exception.FileNotFoundExceptionM;
import by.iba.management.model.exception.ReadFileIOException;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.*;

public class DataWriterProject {
    private static final String FILE_PATH = "data/ProjectsList.xlsx";
    private static final Logger logger = LogManager.getRootLogger();
    private DataWriterProject() {
    }

    public static void writeProjectToFile(List<Project> projectList){
        ArrayList<String> projectsList = new ArrayList<>();
        File file = new File(FILE_PATH);
        try (FileInputStream in = new FileInputStream(file)) {
            XSSFWorkbook workbook = new XSSFWorkbook(in);
            XSSFSheet mySheet = workbook.getSheetAt(0);

            int rowIndex = mySheet.getLastRowNum();
            for (Project project : projectList) {
                Row row = mySheet.createRow(++rowIndex);
                int cellIndex = 0;
                row.createCell(cellIndex++).setCellValue(String.valueOf(project.getProjectId()));
                row.createCell(cellIndex++).setCellValue(project.getProjectName());
                row.createCell(cellIndex++).setCellValue(project.getProjectDescription());
            }


            //write this workbook in excel file.
            try {
                FileOutputStream fos = new FileOutputStream(FILE_PATH);
                workbook.write(fos);
                //fos.close();
                System.out.println(FILE_PATH + " is successfully written");
            } catch (FileNotFoundExceptionM e) {
                logger.error("File error or IO error: ", e);
            } catch (ReadFileIOException e) {
                logger.error("File error or IO error: ", e);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
