package by.iba.management.util;

import by.iba.management.model.exception.ReadFileIOException;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class FileReader {
    private static final Logger logger = LogManager.getRootLogger();
    public static ArrayList<String> readFile(String filePath) throws IOException {
        ArrayList<String> list = new ArrayList<>();
        File file = new File(filePath);
        try (FileInputStream in = new FileInputStream(file)) {
            XSSFWorkbook workbook = new XSSFWorkbook(in);
            XSSFSheet mySheet = workbook.getSheetAt(0);
            for (Row row : mySheet) {
                Iterator<Cell> cellIterator = row.cellIterator();
                String str = "";
                while (cellIterator.hasNext()) {
                    Cell cell = cellIterator.next();
                    str = str.concat(cell.getStringCellValue()).concat(" ");
                }
                list.add(str);
            }
        } catch (ReadFileIOException e) {
            logger.error("File error or IO error: ", e);
        }
        return list;
    }
}
