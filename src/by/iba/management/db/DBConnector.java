package by.iba.management.db;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBConnector {

    static final String JDBC_DRIVER = "org.h2.Driver";
    static final String DB_URL = "jdbc:h2:~/iba_management";

    static final String USER = "user";
    static final String PASS = "pass";

    private static final Logger LOGGER = Logger.getLogger(DBConnector.class.getName());

    public static Connection getConnection() {
        try {
            Class.forName(JDBC_DRIVER);
            return DriverManager.getConnection(DB_URL, USER, PASS);
        } catch (Exception ex) {
            throw new RuntimeException("Error connecting to the database ", ex);
        }
    }

    public static void createDBAndTables() {
        Statement stmt = null;
        try {
            stmt = getConnection().createStatement();

            DatabaseMetaData dbm = getConnection().getMetaData();
            ResultSet tables = dbm.getTables(null, null, "EMPLOYEE", null);
            if (!tables.next()) {
                String projectSql = "CREATE TABLE PROJECT " +
                        "(id INTEGER not NULL PRIMARY KEY AUTO_INCREMENT," +
                        " name VARCHAR(255), " +
                        " description VARCHAR(255));";
                stmt.executeUpdate(projectSql);

                String employeeSql = "CREATE TABLE EMPLOYEE " +
                        "(id INTEGER not NULL PRIMARY KEY AUTO_INCREMENT, " +
                        " name VARCHAR(255), " +
                        " surname VARCHAR(255), " +
                        " project_id INTEGER, " +
                        " is_teamLead BIT , " +
                        " position VARCHAR(255), " +
                        " english_level VARCHAR(255), " +
                        " java BIT , " +
                        " c_plus_plus BIT , " +
                        " c_sharp BIT , " +
                        " php BIT , " +
                        " dot_net BIT , " +
                        " sql BIT , " +
                        " js BIT , " +
                        " html BIT , " +
                        " css BIT , " +
                        " j_query BIT , " +
                        " manual_qa BIT , " +
                        " auto_qa BIT , " +
                        " desktop_testing BIT , " +
                        " mobile_testing BIT , " +
                        " visual_studio BIT , " +
                        " intellij_idea BIT , " +
                        " eclipse BIT , " +
                        " net_beans BIT , " +
                        " FOREIGN KEY (project_id) REFERENCES PROJECT(id));";
                stmt.executeUpdate(employeeSql);
                LOGGER.log(Level.INFO, "Created table in given database...");

                String insertProjectSQL = "INSERT INTO PROJECT(name, description) VALUES ('The', 'Dream'); " +
                        "INSERT INTO PROJECT(name, description) VALUES ('Guardians', 'of'); " +
                        "INSERT INTO PROJECT(name, description) VALUES ('Infinity', 'War'); " +
                        "INSERT INTO PROJECT(name, description) VALUES ('Ragnarok', 'Thor'); " +
                        "INSERT INTO PROJECT(name, description) VALUES ('Venom', 'Venom'); " +
                        "INSERT INTO PROJECT(name, description) VALUES ('HeroesMix', 'Ungrouped'); ";
                stmt.executeUpdate(insertProjectSQL);

                String insertEmployeeSQL = "INSERT INTO EMPLOYEE(name, surname, project_id, is_teamLead, position, english_level, java, c_plus_plus, c_sharp,php, dot_net, sql,js,html,css,j_query,manual_qa, auto_qa,desktop_testing,mobile_testing,visual_studio,intellij_idea,eclipse,net_beans) " +
                        "VALUES ('Anastasiya', 'Tuharava', 1, 0, 'JUNIOR_DEV', 'B1', 1,0,1,0,1,0,1,0,1,0,1,1,1,0,1,1,1,0); " +
                        "INSERT INTO EMPLOYEE(name, surname, project_id, is_teamLead, position, english_level, java, c_plus_plus, c_sharp,php, dot_net, sql,js,html,css,j_query,manual_qa, auto_qa,desktop_testing,mobile_testing,visual_studio,intellij_idea,eclipse,net_beans) " +
                        "VALUES ('Katya', 'Mikhailovich', 1, 1, 'JUNIOR_DEV', 'C1', 0,0,1,1,0,0,1,1,1,0,1,0,1,0,1,0,1,1); ";
                stmt.executeUpdate(insertEmployeeSQL);
                LOGGER.log(Level.INFO, "Tables were created");
            }
            stmt.close();
        } catch (Exception se) {
            se.printStackTrace();
        } finally {

            try {
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException se2) {
                LOGGER.log(Level.WARNING, "problems: " + se2.getMessage());
            }
        }
    }
}
