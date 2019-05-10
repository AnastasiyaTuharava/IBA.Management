package by.iba.management.util;

import by.iba.management.model.entity.Project;
import by.iba.management.model.exception.FileNotFoundExceptionM;
import by.iba.management.model.exception.ReadFileIOException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.*;

public class DataWriterProject {
    private static final String FILE_PATH_P = "data/ProjectsList.xlsx";
    private static final DataWriterProject INSTANCE = new DataWriterProject();

    public static DataWriterProject getInstance() {
        return INSTANCE;
    }

    private DataWriterProject() {
    }

    public static void writeProjectToFile(List<Project> projectList) throws IOException {
        ArrayList<String> projectsList = new ArrayList<>();
        File file = new File(FILE_PATH_P);
        try (FileInputStream in = new FileInputStream(file)) {
            XSSFWorkbook workbook = new XSSFWorkbook(in);
            XSSFSheet mySheet = workbook.getSheetAt(0);

            int rowIndex = mySheet.getLastRowNum();
            for (Project project : projectList) {
                Row row = mySheet.createRow(++rowIndex);
                int cellIndex = 0;
                row.createCell(cellIndex++).setCellValue(String.valueOf(ProjectIdGenerator.getProjectId()));
                row.createCell(cellIndex++).setCellValue(project.getProjectName());
                row.createCell(cellIndex++).setCellValue(project.getProjectDescription());
            }

            //write this workbook in excel file.
            try {
                FileOutputStream fos = new FileOutputStream(FILE_PATH_P);
                workbook.write(fos);
                fos.close();

                System.out.println(FILE_PATH_P + " is successfully written");
            } catch (FileNotFoundExceptionM e) {
                //logger.error("File error or IO error: ", e);
            } catch (ReadFileIOException e) {
                //logger.error("File error or IO error: ", e);
            }
        }
    }
}
