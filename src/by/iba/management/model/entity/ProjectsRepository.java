package by.iba.management.model.entity;

import by.iba.management.util.DataParserProject;
import by.iba.management.util.FileReader;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import java.io.IOException;
import java.util.ArrayList;

public class ProjectsRepository {
    private static ArrayList<Project> projectsList = new ArrayList<>();
    private static final String FILE_PATH = "data/ProjectsList.xlsx";
    private static final Logger logger = LogManager.getRootLogger();
    static {
        try {
            projectsList = DataParserProject.parseStringToCreateProject(FileReader.readFile(FILE_PATH));
        } catch (IOException e) {
            logger.error("Error reading file: ", e);
        }
    }
    private ProjectsRepository() {
    }

    public static ArrayList<Project> getProjectList() {
        return projectsList;
    }
}