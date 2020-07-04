package by.iba.management.util;

import by.iba.management.model.entity.Employee;
import by.iba.management.model.entity.Project;
import by.iba.management.model.exception.FileNotFoundExceptionM;
import by.iba.management.model.exception.ReadFileIOException;
import javafx.scene.control.Alert;
import javafx.stage.DirectoryChooser;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static by.iba.management.db.DBConnector.getConnection;

public class DataWriterEmployee {
    private static DirectoryChooser dc = new DirectoryChooser();
    static File file = dc.showDialog(null);
    private static final String FILE_PATH = file.getAbsolutePath() + "/Employees.xlsx";

    private DataWriterEmployee() {
    }

    public static void writeEmployeeToFile() {
        try {
            XSSFWorkbook workbook = new XSSFWorkbook();

            XSSFSheet sheet = workbook.createSheet("Employees");
            XSSFRow header = sheet.createRow(0);
            int columnIndex = 0;
            header.createCell(columnIndex++).setCellValue("ID");
            header.createCell(columnIndex++).setCellValue("First Name");
            header.createCell(columnIndex++).setCellValue("Last Name");
            header.createCell(columnIndex++).setCellValue("Project ID");
            header.createCell(columnIndex++).setCellValue("Ieam Lead");
            header.createCell(columnIndex++).setCellValue("Position");
            header.createCell(columnIndex++).setCellValue("English Level");
            header.createCell(columnIndex++).setCellValue("Java");
            header.createCell(columnIndex++).setCellValue("C++");
            header.createCell(columnIndex++).setCellValue("C#");
            header.createCell(columnIndex++).setCellValue("PHP");
            header.createCell(columnIndex++).setCellValue("DotNet");
            header.createCell(columnIndex++).setCellValue("SQL");
            header.createCell(columnIndex++).setCellValue("JS");
            header.createCell(columnIndex++).setCellValue("HTML");
            header.createCell(columnIndex++).setCellValue("CSS");
            header.createCell(columnIndex++).setCellValue("jQuery");
            header.createCell(columnIndex++).setCellValue("Manual QA");
            header.createCell(columnIndex++).setCellValue("Auto QA");
            header.createCell(columnIndex++).setCellValue("Testing Desktop");
            header.createCell(columnIndex++).setCellValue("Testing Mobile");
            header.createCell(columnIndex++).setCellValue("Visual Studio");
            header.createCell(columnIndex++).setCellValue("IntelliJ Idea");
            header.createCell(columnIndex++).setCellValue("Eclipse");
            header.createCell(columnIndex++).setCellValue("Net Beans");

            Statement statement = getConnection().createStatement();
            String query = "SELECT * FROM EMPLOYEE";
            ResultSet result = statement.executeQuery(query);
            int rowIndex = 1;


            while (result.next()) {
                Row row = sheet.createRow(rowIndex++);
                int cellIndex = 0;
                row.createCell(cellIndex++).setCellValue(result.getInt("id"));
                row.createCell(cellIndex++).setCellValue(result.getString("name"));
                row.createCell(cellIndex++).setCellValue(result.getString("surname"));
                row.createCell(cellIndex++).setCellValue(result.getInt("project_id"));
                row.createCell(cellIndex++).setCellValue(result.getBoolean("is_teamlead"));
                row.createCell(cellIndex++).setCellValue(result.getString("position"));
                row.createCell(cellIndex++).setCellValue(result.getString("english_level"));

                row.createCell(cellIndex++).setCellValue(result.getBoolean("java"));
                row.createCell(cellIndex++).setCellValue(result.getBoolean("c_plus_plus"));
                row.createCell(cellIndex++).setCellValue(result.getBoolean("c_sharp"));
                row.createCell(cellIndex++).setCellValue(result.getBoolean("php"));
                row.createCell(cellIndex++).setCellValue(result.getBoolean("dot_net"));

                row.createCell(cellIndex++).setCellValue(result.getBoolean("sql"));
                row.createCell(cellIndex++).setCellValue(result.getBoolean("js"));
                row.createCell(cellIndex++).setCellValue(result.getBoolean("html"));
                row.createCell(cellIndex++).setCellValue(result.getBoolean("css"));
                row.createCell(cellIndex++).setCellValue(result.getBoolean("j_query"));

                row.createCell(cellIndex++).setCellValue(result.getBoolean("manual_qa"));
                row.createCell(cellIndex++).setCellValue(result.getBoolean("auto_qa"));
                row.createCell(cellIndex++).setCellValue(result.getBoolean("desktop_testing"));
                row.createCell(cellIndex++).setCellValue(result.getBoolean("mobile_testing"));

                row.createCell(cellIndex++).setCellValue(result.getBoolean("visual_studio"));
                row.createCell(cellIndex++).setCellValue(result.getBoolean("intellij_idea"));
                row.createCell(cellIndex++).setCellValue(result.getBoolean("eclipse"));
                row.createCell(cellIndex++).setCellValue(result.getBoolean("net_beans"));
            }

            FileOutputStream out = new FileOutputStream(new File(FILE_PATH));
            workbook.write(out);
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
