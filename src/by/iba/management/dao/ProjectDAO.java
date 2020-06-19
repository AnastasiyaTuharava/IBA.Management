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
                project.setProjectId(rs.getInt("id"));
                project.setProjectName(rs.getString("name"));
                project.setProjectDescription(rs.getString("description"));
                projectList.add(project);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return projectList;
    }

    public static void removeProject(long projectId) {
        Connection connection = DBConnector.getConnection();
        try {
            Statement stmt = connection.createStatement();
            stmt.executeQuery("DELETE FROM PROJECT WHERE ID=" + projectId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void addProject(Project project) {
        Connection connection = DBConnector.getConnection();
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM PROJECT");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }


    }

    public static void editProject(Project project) {

    }

    public static Project getProject(long projectId) {
        Connection connection = DBConnector.getConnection();
        Project project = new Project();
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM PROJECT WHERE ID=" + projectId);
            project.setProjectId(rs.getInt("id"));
            project.setProjectName(rs.getString("name"));
            project.setProjectDescription(rs.getString("description"));
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return project;
    }
}
