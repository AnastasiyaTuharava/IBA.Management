package by.iba.management.util;

import by.iba.management.model.exception.ReadFileIOException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FileReader {
    private static final Logger LOGGER = Logger.getLogger(FileReader.class.getName());

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
            LOGGER.log(Level.FINE, "File error or IO error: ", e);
        }
        return list;
    }
}
