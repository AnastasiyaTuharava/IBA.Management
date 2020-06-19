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
        } catch (SQLException e) {
            e.printStackTrace();
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
            ResultSet rs = stmt.executeQuery("INSERT INTO PROJECT VALUES ("
                    + project.getProjectId() + ", "
                    + project.getProjectName() + ", "
                    + project.getProjectDescription() + ")");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void editProject(Project project) {
        //INSERT INTO <table_name>
        //  VALUES (<value1>, <value2>, <value3>, …);

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
            ResultSet rs = stmt.executeQuery("SELECT * FROM PROJECT WHERE NAME=" + projectName);
            project.setProjectId(rs.getInt("id"));
            project.setProjectName(rs.getString("name"));
            project.setProjectDescription(rs.getString("description"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return project;
    }
}
