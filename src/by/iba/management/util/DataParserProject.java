package by.iba.management.util;

import by.iba.management.model.entity.*;

import java.util.ArrayList;

public class DataParserProject {
    private static final String REGEX_SPACE = "\\s";
    public static ArrayList<Project> parseStringToCreateProject(ArrayList<String> list) {
        ArrayList<Project> projectsList = new ArrayList<>();
        DataValidatorProject validator = new DataValidatorProject();
        for (String str: list) {
            if (validator.validate(str)) {
                String[] s = str.split(REGEX_SPACE);
                Project project = new Project(Long.parseLong(s[0]), s[1], s[2]);
                projectsList.add(project);
            }
        }
        return projectsList;
    }
}