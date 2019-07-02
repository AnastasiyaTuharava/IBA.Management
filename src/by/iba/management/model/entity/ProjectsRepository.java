package by.iba.management.model.entity;

import by.iba.management.util.DataParserProject;
import by.iba.management.util.FileReader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProjectsRepository {
    private static final String FILE_PATH = "data/ProjectsList.xlsx";
    private static final Logger LOGGER = Logger.getLogger(ProjectsRepository.class.getName());
    private static ArrayList<Project> projectsList = new ArrayList<>();

    static {
        try {
            projectsList = DataParserProject.parseStringToCreateProject(FileReader.readFile(FILE_PATH));
        } catch (IOException e) {
            LOGGER.log(Level.FINE, "Error reading file: ", e);
        }
    }

    public ProjectsRepository() {
    }

    public static ArrayList<Project> getProjectList() {
        return projectsList;
    }
}