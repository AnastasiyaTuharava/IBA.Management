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
    public void editProjectName (Project project, String newProjectName) {
        project.setProjectName(newProjectName);
    }
    @Override
    public void editProjectDescription (Project project, String newProjectDescription) {
        project.setProjectDescription(newProjectDescription);
    }
    @Override
    public void removeProject(Project project, long projectId) {
        //remove projectId from all assigned employees:
        List<Employee> teamList = new ArrayList<>();
        for (Employee e : EmployeesRepository.getEmployeesList()) {
            if (e.getProjectId() == projectId) {
                e.setProjectId(0);
            }
        }
        //now remove the project:
        ProjectsRepository.getProjectList().remove(project);
    }
}
