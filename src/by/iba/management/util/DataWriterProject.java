package by.iba.management.util;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileOutputStream;
import java.sql.ResultSet;
import java.sql.Statement;

import static by.iba.management.db.DBConnector.getConnection;

public class DataWriterProject {
    private static final String FILE_PATH = "data/ProjectsList.xlsx";

    private DataWriterProject() {
    }

    public static void writeProjectToFile() {
        try {
            XSSFWorkbook workbook = new XSSFWorkbook();

            XSSFSheet sheet = workbook.createSheet("Projects");

            XSSFRow header = sheet.createRow(0);
            header.createCell(0).setCellValue("ID");
            header.createCell(1).setCellValue("Project Name");
            header.createCell(2).setCellValue("Description");

            Statement statement = getConnection().createStatement();
            String query = "SELECT * FROM PROJECT";
            ResultSet result = statement.executeQuery(query);
            int rowIndex = 1;

            while (result.next()) {
                Row row = sheet.createRow(rowIndex++);
                int cellIndex = 0;
                row.createCell(cellIndex++).setCellValue(result.getInt("id_project"));
                row.createCell(cellIndex++).setCellValue(result.getString("name_project"));
                row.createCell(cellIndex++).setCellValue(result.getString("description_project"));
            }
            FileOutputStream out = new FileOutputStream(new File(FILE_PATH));
            workbook.write(out);
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
