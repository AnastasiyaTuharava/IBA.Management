
package by.iba.management.util;

import by.iba.management.model.entity.Project;
import by.iba.management.model.exception.FileNotFoundExceptionM;
import by.iba.management.model.exception.ReadFileIOException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

import static by.iba.management.db.DBConnector.getConnection;

public class DataWriterProject {
    private static final String FILE_PATH = "data/ProjectsList.xlsx";
    private static final Logger LOGGER = Logger.getLogger(FileReader.class.getName());

    private DataWriterProject() {
    }

    public static void writeProjectToFile(Project project) throws SQLException {
        File file = new File(FILE_PATH);
        try (FileInputStream in = new FileInputStream(file)) {
            XSSFWorkbook workbook = new XSSFWorkbook(in);
            XSSFSheet mySheet = workbook.getSheetAt(0);

            int rowIndex = 0;

            Statement statement;
            statement = getConnection().createStatement();
            String query = "Select * from PROJECT";
            ResultSet result = statement.executeQuery(query);

            XSSFSheet sheet = workbook.createSheet();
            XSSFRow header = sheet.createRow(0);
            header.createCell(0).setCellValue("ID");
            header.createCell(1).setCellValue("Project Name");
            header.createCell(2).setCellValue("Description");

            while (result.next()) {
                Row row = sheet.createRow(rowIndex++);
                int cellIndex = 0;
                row.createCell(cellIndex++).setCellValue(String.valueOf(project.getProjectId()));
                row.createCell(cellIndex++).setCellValue(project.getProjectName());
                row.createCell(cellIndex++).setCellValue(project.getProjectDescription());
            }

            try {
                FileOutputStream fos = new FileOutputStream(FILE_PATH);
                workbook.write(fos);
                //fos.close();
                LOGGER.log(Level.FINE, FILE_PATH + " is successfully written");
            } catch (FileNotFoundExceptionM | ReadFileIOException e) {
                LOGGER.log(Level.ALL, "File error or IO error: ", e);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
