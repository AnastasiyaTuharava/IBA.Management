package by.iba.management.dao;

import by.iba.management.db.DBConnector;
import by.iba.management.model.entity.Project;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProjectDAO {

    public static List<Project> getProjects() {
        List<Project> projectList = new ArrayList<>();
        Connection connection = DBConnector.getConnection();
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM PROJECT");
            while (rs.next()) {
                Project project = new Project();
                project.setProjectId(rs.getInt("id_project"));
                project.setProjectName(rs.getString("name_project"));
                project.setProjectDescription(rs.getString("description_project"));
                projectList.add(project);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return projectList;
    }

    public static void removeProject(long projectId) {
        Connection connection = DBConnector.getConnection();
        try {
            Statement stmt = connection.createStatement();
            stmt.execute("DELETE FROM PROJECT WHERE id_project=" + projectId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void addProject(Project project) {
        Connection connection = DBConnector.getConnection();
        try {
            Statement stmt = connection.createStatement();
            stmt.execute("INSERT INTO PROJECT (name_project, description_project) VALUES ('"
                    + project.getProjectName() + "', '"
                    + project.getProjectDescription() + "')");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void updateProject(Project project) {
        Connection connection = DBConnector.getConnection();
        try {
            Statement stmt = connection.createStatement();
            stmt.execute("UPDATE PROJECT SET " +
                    "name_project='" + project.getProjectName() + "' , " +
                    "description_project='" + project.getProjectDescription() + "' " +
                    "WHERE id_project=" + project.getProjectId());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Project getProject(long projectId) {
        Connection connection = DBConnector.getConnection();
        Project project = new Project();
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM PROJECT WHERE id_project=" + projectId);
            while (rs.next()) {
                project.setProjectId(rs.getInt("id_project"));
                project.setProjectName(rs.getString("name_project"));
                project.setProjectDescription(rs.getString("description_project"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return project;
    }

    public static Project getProject(String projectName) {
        Connection connection = DBConnector.getConnection();
        Project project = new Project();
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM PROJECT WHERE name_project='" + projectName + "'");
            while (rs.next()) {
                project.setProjectId(rs.getInt("id_project"));
                project.setProjectName(rs.getString("name_project"));
                project.setProjectDescription(rs.getString("description_project"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return project;
    }

    public static List<Project> findProjectsByName(String projectName) {
        Connection connection = DBConnector.getConnection();
        List<Project> projectList = new ArrayList<>();
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM PROJECT WHERE name_project LIKE '%" + projectName + "%'");
            while (rs.next()) {
                Project project = new Project();
                project.setProjectId(rs.getInt("id_project"));
                project.setProjectName(rs.getString("name_project"));
                project.setProjectDescription(rs.getString("description_project"));
                projectList.add(project);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return projectList;
    }
}
