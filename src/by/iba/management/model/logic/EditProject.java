package by.iba.management.model.logic;

import by.iba.management.model.entity.Employee;
import by.iba.management.model.entity.Project;

import java.io.IOException;

public interface EditProject {
    void editProjectName(long projectId, String newProjectName);
    void editProjectDescription(long projectId, String newProjectDescription);
    void removeProject(long projectId) throws IOException;
}
