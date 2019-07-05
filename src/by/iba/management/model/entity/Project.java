package by.iba.management.model.entity;

import by.iba.management.util.ProjectIdGenerator;

import java.util.ArrayList;
import java.util.Objects;

/**
 * Created by katya on 2/20/2019.
 */
public class Project {
    private long projectId;
    private String projectName;
    private String projectDescription;
    private ArrayList<Employee> teamList = new ArrayList<>();

    public Project() {
        this.projectId = ProjectIdGenerator.getNewProjectId();
    }

    public Project(String projectName, String projectDescription) {
        this.projectId = ProjectIdGenerator.getNewProjectId();
        this.projectName = projectName;
        this.projectDescription = projectDescription;
    }

    public Project(long projectId, String projectName, String projectDescription) {
        this.projectId = projectId;
        this.projectName = projectName;
        this.projectDescription = projectDescription;
    }

    public Project(String projectId, String projectName, String projectDescription) {
        this.projectId = Long.parseLong(projectId);
        this.projectName = projectName;
        this.projectDescription = projectDescription;
    }

    public long getProjectId() {
        return projectId;
    }

    public String getProjectName() {
        return projectName;
    }

    public String getProjectDescription() {
        return projectDescription;
    }

    public void setProjectId(long projectId) {
        this.projectId = projectId;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public void setProjectDescription(String projectDescription) {
        this.projectDescription = projectDescription;
    }

    public ArrayList<Employee> getTeamList() {
        return teamList;
    }

    public void addTeamList(Employee employee) {
        teamList.add(employee);
    }

    public void removeFromTeamList(Employee employee) {
        teamList.remove(employee);
    }

    @Override
    public String toString() {
        return "Project{" +
                "projectId= " + projectId +
                ", projectName = " + projectName + '\'' +
                ", projectDescription = " + projectDescription + '\'' +
                '}';
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Project)) return false;
        Project project = (Project) o;
        return getProjectId() == project.getProjectId() &&
                getProjectName().equals(project.getProjectName()) &&
                Objects.equals(getProjectDescription(), project.getProjectDescription());
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(getProjectId(), getProjectName(), getProjectDescription());
        result = 31 * result;
        return result;
    }
}

