package by.iba.management.model.logic.impl;

import by.iba.management.model.entity.Employee;
import by.iba.management.model.entity.EmployeesRepository;
import by.iba.management.model.entity.Project;
import by.iba.management.model.entity.ProjectsRepository;
import by.iba.management.model.logic.EditProject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class EditProjectImpl implements EditProject {
    @Override
    public void editProjectName (long projectId, String newProjectName) {
        new FindProjectImpl().findProjectById(projectId).setProjectName(newProjectName);
    }
    @Override
    public void editProjectDescription (long projectId, String newProjectDescription) {
        new FindProjectImpl().findProjectById(projectId).setProjectDescription(newProjectDescription);
    }
    @Override
    public void removeProject(long projectId) {
        for (Employee e : EmployeesRepository.getEmployeesList()) {
            if (e.getProjectId() == projectId) {
                e.setProjectId(0);
            }
        }
        ProjectsRepository.getProjectList().remove(new FindProjectImpl().findProjectById(projectId));
    }
}
