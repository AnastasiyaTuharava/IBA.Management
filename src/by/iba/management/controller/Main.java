package by.iba.management.controller;

import by.iba.management.model.entity.Project;
import by.iba.management.model.entity.ProjectsRepository;
import by.iba.management.util.DataWriterProject;

public class Main {
    public static void main(String[] args) {
        Project p1 = new Project("HelloWorld", "First line");
        ProjectsRepository.getProjectList().add(p1);
        for (Project p : ProjectsRepository.getProjectList()) {
            System.out.println(p);
        }
        DataWriterProject.writeProjectToFile(ProjectsRepository.getProjectList());
    }
}
