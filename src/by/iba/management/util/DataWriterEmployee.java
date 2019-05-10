package by.iba.management.util;

import by.iba.management.model.entity.*;
import by.iba.management.model.exception.FileNotFoundExceptionM;
import by.iba.management.model.exception.ReadFileIOException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DataWriterEmployee {
    private static final String FILE_PATH = "data/EmployeesList.xlsx";

    private DataWriterEmployee() {
    }

    public static void writeEmployeeToFile(List<Employee> employeeList, Project project){
        ArrayList<String> employeesList = new ArrayList<>();
        File file = new File(FILE_PATH);
        try (FileInputStream in = new FileInputStream(file)) {
            XSSFWorkbook workbook = new XSSFWorkbook(in);
            XSSFSheet mySheet = workbook.getSheetAt(0);
            DataFormatter formatter = new DataFormatter();

            int rowIndex = mySheet.getLastRowNum();
            for (Employee employee : employeeList) {
                Row row = mySheet.createRow(++rowIndex);
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
            for (Row row : mySheet) {
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
            try (FileOutputStream fos = new FileOutputStream(FILE_PATH)) {
                workbook.write(fos);
                System.out.println(FILE_PATH + " is successfully written");
            } catch (FileNotFoundExceptionM e) {
                //logger.error("File error or IO error: ", e);
            } catch (ReadFileIOException e) {
                //logger.error("File error or IO error: ", e);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
