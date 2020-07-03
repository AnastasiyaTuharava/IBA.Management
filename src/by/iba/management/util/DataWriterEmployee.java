package by.iba.management.util;

import by.iba.management.model.entity.Employee;
import by.iba.management.model.exception.FileNotFoundExceptionM;
import by.iba.management.model.exception.ReadFileIOException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Iterator;

import static by.iba.management.db.DBConnector.getConnection;

public class DataWriterEmployee {
    private static final String FILE_PATH = "data/EmployeesList.xlsx";

    public DataWriterEmployee() {}

    public static void writeEmployeeToFile(Employee employee) throws SQLException, IOException {
        File file = new File(FILE_PATH);
        try (FileInputStream in = new FileInputStream(file)) {
            XSSFWorkbook workbook = new XSSFWorkbook(in);
            //XSSFSheet sheet = workbook.getSheetAt(0);
            DataFormatter formatter = new DataFormatter();

            int rowIndex = 0;

            Statement statement;
            statement = getConnection().createStatement();
            String query = "Select * from EMPLOYEE";
            ResultSet result = statement.executeQuery(query);

            XSSFSheet sheet = workbook.createSheet("All Employees List");
            XSSFRow header = sheet.createRow(0);
            header.createCell(0).setCellValue("ID");
            header.createCell(1).setCellValue("First Name");
            header.createCell(2).setCellValue("Last Name");
            header.createCell(3).setCellValue("Project ID");
            header.createCell(0).setCellValue("Team Lead");
            header.createCell(1).setCellValue("Position");
            header.createCell(2).setCellValue("English Level");
            header.createCell(3).setCellValue("Java");
            header.createCell(0).setCellValue("C++");
            header.createCell(1).setCellValue("C#");
            header.createCell(2).setCellValue("PHP");
            header.createCell(3).setCellValue("DotNet");
            header.createCell(0).setCellValue("SQL");
            header.createCell(1).setCellValue("JS");
            header.createCell(2).setCellValue("HTML");
            header.createCell(3).setCellValue("CSS");
            header.createCell(0).setCellValue("jQuery");
            header.createCell(1).setCellValue("Manual QA");
            header.createCell(2).setCellValue("Automation QA");
            header.createCell(3).setCellValue("Desktop Testing");
            header.createCell(0).setCellValue("WebApp Testing");
            header.createCell(1).setCellValue("Vusial Studio");
            header.createCell(2).setCellValue("IntelliJ Idea");
            header.createCell(3).setCellValue("Eclipse");
            header.createCell(3).setCellValue("Net Beans");

            while (result.next()) {

                    Row row = sheet.createRow(rowIndex++);
                    int cellIndex = 0;
                    row.createCell(cellIndex++).setCellValue(String.valueOf(employee.getEmployeeId()));
                    row.createCell(cellIndex++).setCellValue(employee.getFirstName());
                    row.createCell(cellIndex++).setCellValue(employee.getLastName());
                    row.createCell(cellIndex++).setCellValue(String.valueOf(employee.getProjectId()));
                    row.createCell(cellIndex++).setCellValue(employee.isTeamLead());
                    row.createCell(cellIndex++).setCellValue(String.valueOf(employee.getPosition()));
                    row.createCell(cellIndex++).setCellValue(String.valueOf(employee.getEnglishLanguageLevel()));

                    row.createCell(cellIndex++).setCellValue(String.valueOf(employee.getProgrammingLanguage().isJava()));
                    row.createCell(cellIndex++).setCellValue(String.valueOf(employee.getProgrammingLanguage().iscPlusPlus()));
                    row.createCell(cellIndex++).setCellValue(String.valueOf(employee.getProgrammingLanguage().iscSharp()));
                    row.createCell(cellIndex++).setCellValue(String.valueOf(employee.getProgrammingLanguage().isPhp()));
                    row.createCell(cellIndex++).setCellValue(String.valueOf(employee.getProgrammingLanguage().isDotNet()));

                    row.createCell(cellIndex++).setCellValue(String.valueOf(employee.getSkills().isSql()));
                    row.createCell(cellIndex++).setCellValue(String.valueOf(employee.getSkills().isJavaScript()));
                    row.createCell(cellIndex++).setCellValue(String.valueOf(employee.getSkills().isHtml()));
                    row.createCell(cellIndex++).setCellValue(String.valueOf(employee.getSkills().isCss()));
                    row.createCell(cellIndex++).setCellValue(String.valueOf(employee.getSkills().isjQuery()));

                    row.createCell(cellIndex++).setCellValue(String.valueOf(employee.getTesting().isManual()));
                    row.createCell(cellIndex++).setCellValue(String.valueOf(employee.getTesting().isAutomation()));
                    row.createCell(cellIndex++).setCellValue(String.valueOf(employee.getTesting().isTestingDeskTopApplications()));
                    row.createCell(cellIndex++).setCellValue(String.valueOf(employee.getTesting().isTestingMobileApplications()));

                    row.createCell(cellIndex++).setCellValue(String.valueOf(employee.getTools().isVisualStudio()));
                    row.createCell(cellIndex++).setCellValue(String.valueOf(employee.getTools().isIntellijIdea()));
                    row.createCell(cellIndex++).setCellValue(String.valueOf(employee.getTools().isEclipse()));
                    row.createCell(cellIndex++).setCellValue(String.valueOf(employee.getTools().isNetBeans()));
                }

                //format sheet as text1:
                for (Row row : sheet) {
                    Iterator<Cell> cellIterator = row.cellIterator();
                    while (cellIterator.hasNext()) {
                        Cell cell = cellIterator.next();
                        formatter.formatCellValue(cell);
                    }
                }

            /*
            //format sheet as text2:
            DataFormat fmt = workbook.createDataFormat();
            CellStyle textStyle = workbook.createCellStyle();
            textStyle.setDataFormat(fmt.getFormat("@")); //format all rows as text
            mySheet.setDefaultColumnStyle(0-50, textStyle); //format columns 0-50 as text
            */

                //write this workbook in excel file:

            statement.close();
            result.close();

                try (FileOutputStream fos = new FileOutputStream(FILE_PATH)) {
                    workbook.write(fos);
                    System.out.println(FILE_PATH + " is successfully written");
                } catch (FileNotFoundExceptionM | ReadFileIOException e) {
                    //logger.error("File error or IO error: ", e);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
}


