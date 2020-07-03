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
                        "(id_project INTEGER not NULL PRIMARY KEY AUTO_INCREMENT," +
                        " name_project VARCHAR(255), " +
                        " description_project VARCHAR(500));";
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
                        " FOREIGN KEY (project_id) REFERENCES PROJECT(id_project));";
                stmt.executeUpdate(employeeSql);
                LOGGER.log(Level.INFO, "Created table in given database...");

                String insertProjectSQL = "INSERT INTO PROJECT(name_project, description_project) VALUES ('USS Enterprise', 'NCC-1701'); " +
                        "INSERT INTO PROJECT(name_project, description_project) VALUES ('Big Bang Theory','Math, science, history, unraveling the mysteries\n" +
                        "That all started with the big bang! Hey!'); " +
                        "INSERT INTO PROJECT(name_project, description_project) VALUES ('Spider Man', 'A fictional superhero created by writer-editor Stan Lee and writer-artist Steve Ditko'); " +
                        "INSERT INTO PROJECT(name_project, description_project) VALUES ('Star Wars', 'Lucasfilm'); " +
                        "INSERT INTO PROJECT(name_project, description_project) VALUES ('Superman', 'Superman was born on the planet Krypton and was given the name Kal-El at birth'); " +
                        "INSERT INTO PROJECT(name_project, description_project) VALUES ('Dream Team', 'A team of a dream'); ";
                stmt.executeUpdate(insertProjectSQL);

                String insertEmployeeSQL = "INSERT INTO EMPLOYEE(name, surname, project_id, is_teamLead, position, english_level, java, c_plus_plus, c_sharp,php, dot_net, sql,js,html,css,j_query,manual_qa, auto_qa,desktop_testing,mobile_testing,visual_studio,intellij_idea,eclipse,net_beans) " +
                        "VALUES ('Robert', 'April', 1, 1, 'SENIOR_DEV', 'C2', 1,0,1,0,1,0,1,0,1,0,1,1,1,0,1,1,1,0); " +
                        "INSERT INTO EMPLOYEE(name, surname, project_id, is_teamLead, position, english_level, java, c_plus_plus, c_sharp,php, dot_net, sql,js,html,css,j_query,manual_qa, auto_qa,desktop_testing,mobile_testing,visual_studio,intellij_idea,eclipse,net_beans) " +
                        "VALUES ('Christopher', 'Pike', 1, 1, 'JUNIOR_DEV', 'C1', 0,0,1,1,0,0,0,1,0,0,1,0,1,0,1,1,1,1); " +
                        "INSERT INTO EMPLOYEE(name, surname, project_id, is_teamLead, position, english_level, java, c_plus_plus, c_sharp,php, dot_net, sql,js,html,css,j_query,manual_qa, auto_qa,desktop_testing,mobile_testing,visual_studio,intellij_idea,eclipse,net_beans) " +
                        "VALUES ('James', 'T.Kirk', 1, 1, 'MIDDLE_DEV', 'B2', 0,0,1,0,1,0,1,0,1,0,0,1,1,1,1,1,1,0); " +
                        "INSERT INTO EMPLOYEE(name, surname, project_id, is_teamLead, position, english_level, java, c_plus_plus, c_sharp,php, dot_net, sql,js,html,css,j_query,manual_qa, auto_qa,desktop_testing,mobile_testing,visual_studio,intellij_idea,eclipse,net_beans) " +
                        "VALUES ('Spock', 'Vulcan', 1, 1, 'SENIOR_DEV', 'C2', 1,0,1,0,1,0,1,0,1,0,1,1,1,0,1,1,1,0); " +
                        "INSERT INTO EMPLOYEE(name, surname, project_id, is_teamLead, position, english_level, java, c_plus_plus, c_sharp,php, dot_net, sql,js,html,css,j_query,manual_qa, auto_qa,desktop_testing,mobile_testing,visual_studio,intellij_idea,eclipse,net_beans) " +
                        "VALUES ('Leonard', 'Hofstadter', 2, 1, 'SENIOR_DEV', 'C2', 0,0,1,0,1,0,1,0,1,0,0,1,1,1,1,1,1,0); " +
                        "INSERT INTO EMPLOYEE(name, surname, project_id, is_teamLead, position, english_level, java, c_plus_plus, c_sharp,php, dot_net, sql,js,html,css,j_query,manual_qa, auto_qa,desktop_testing,mobile_testing,visual_studio,intellij_idea,eclipse,net_beans) " +
                        "VALUES ('Sheldon', 'Cooper', 2, 1, 'SENIOR_DEV', 'B2', 1,0,1,0,1,0,1,1,1,0,1,1,1,0,1,1,1,0); " +
                        "INSERT INTO EMPLOYEE(name, surname, project_id, is_teamLead, position, english_level, java, c_plus_plus, c_sharp,php, dot_net, sql,js,html,css,j_query,manual_qa, auto_qa,desktop_testing,mobile_testing,visual_studio,intellij_idea,eclipse,net_beans) " +
                        "VALUES ('Penny', 'Penny', 2, 1, 'MIDDLE_DEV', 'C2', 1,0,1,0,1,0,1,0,1,0,1,1,0,0,1,1,1,0); " +
                        "INSERT INTO EMPLOYEE(name, surname, project_id, is_teamLead, position, english_level, java, c_plus_plus, c_sharp,php, dot_net, sql,js,html,css,j_query,manual_qa, auto_qa,desktop_testing,mobile_testing,visual_studio,intellij_idea,eclipse,net_beans) " +
                        "VALUES ('Howard', 'Wolowitz', 2, 1, 'SENIOR_DEV', 'C2', 1,0,1,0,1,1,1,0,1,0,1,1,1,0,1,1,1,0); " +
                        "INSERT INTO EMPLOYEE(name, surname, project_id, is_teamLead, position, english_level, java, c_plus_plus, c_sharp,php, dot_net, sql,js,html,css,j_query,manual_qa, auto_qa,desktop_testing,mobile_testing,visual_studio,intellij_idea,eclipse,net_beans) " +
                        "VALUES ('Raj', 'Koothrappali', 2, 1, 'SENIOR_DEV', 'B2', 1,0,0,0,1,0,1,0,1,0,0,1,1,0,1,1,1,0); " +
                        "INSERT INTO EMPLOYEE(name, surname, project_id, is_teamLead, position, english_level, java, c_plus_plus, c_sharp,php, dot_net, sql,js,html,css,j_query,manual_qa, auto_qa,desktop_testing,mobile_testing,visual_studio,intellij_idea,eclipse,net_beans) " +
                        "VALUES ('Ami', 'Farrah Fowler', 2, 1, 'SENIOR_DEV', 'B2', 1,0,1,0,1,0,1,0,1,0,1,1,1,0,1,1,1,0); " +
                        "INSERT INTO EMPLOYEE(name, surname, project_id, is_teamLead, position, english_level, java, c_plus_plus, c_sharp,php, dot_net, sql,js,html,css,j_query,manual_qa, auto_qa,desktop_testing,mobile_testing,visual_studio,intellij_idea,eclipse,net_beans) " +
                        "VALUES ('Bernadette', 'Rostenkowski-Wolowitz', 2, 1, 'SENIOR_DEV', 'C2', 1,1,1,1,1,0,1,1,1,0,1,1,1,0,1,1,1,0); " +
                        "INSERT INTO EMPLOYEE(name, surname, project_id, is_teamLead, position, english_level, java, c_plus_plus, c_sharp,php, dot_net, sql,js,html,css,j_query,manual_qa, auto_qa,desktop_testing,mobile_testing,visual_studio,intellij_idea,eclipse,net_beans) " +
                        "VALUES ('Peter', 'Parker', 3, 1, 'SENIOR_DEV', 'C2', 1,0,1,0,1,0,1,0,1,0,1,1,1,0,1,1,1,0); " +
                        "INSERT INTO EMPLOYEE(name, surname, project_id, is_teamLead, position, english_level, java, c_plus_plus, c_sharp,php, dot_net, sql,js,html,css,j_query,manual_qa, auto_qa,desktop_testing,mobile_testing,visual_studio,intellij_idea,eclipse,net_beans) " +
                        "VALUES ('Iron', 'Man', 3, 1, 'MIDDLE_DEV', 'C2', 1,0,1,0,1,0,1,0,1,1,1,1,1,0,1,1,1,0); " +
                        "INSERT INTO EMPLOYEE(name, surname, project_id, is_teamLead, position, english_level, java, c_plus_plus, c_sharp,php, dot_net, sql,js,html,css,j_query,manual_qa, auto_qa,desktop_testing,mobile_testing,visual_studio,intellij_idea,eclipse,net_beans) " +
                        "VALUES ('Mary Jane', 'Watson', 3, 0, 'MIDDLE_DEV', 'B2', 1,0,1,0,1,0,1,0,0,0,1,1,1,0,0,1,1,0); " +
                        "INSERT INTO EMPLOYEE(name, surname, project_id, is_teamLead, position, english_level, java, c_plus_plus, c_sharp,php, dot_net, sql,js,html,css,j_query,manual_qa, auto_qa,desktop_testing,mobile_testing,visual_studio,intellij_idea,eclipse,net_beans) " +
                        "VALUES ('Luke', 'Skywalker', 4, 1, 'MIDDLE_DEV', 'C2', 1,0,1,0,1,0,1,0,1,0,1,1,1,0,1,1,1,0); " +
                        "INSERT INTO EMPLOYEE(name, surname, project_id, is_teamLead, position, english_level, java, c_plus_plus, c_sharp,php, dot_net, sql,js,html,css,j_query,manual_qa, auto_qa,desktop_testing,mobile_testing,visual_studio,intellij_idea,eclipse,net_beans) " +
                        "VALUES ('Han', 'Solo', 4, 1, 'MIDDLE_DEV', 'C2', 1,0,1,0,1,0,1,0,1,0,1,1,1,0,1,1,1,0); " +
                        "INSERT INTO EMPLOYEE(name, surname, project_id, is_teamLead, position, english_level, java, c_plus_plus, c_sharp,php, dot_net, sql,js,html,css,j_query,manual_qa, auto_qa,desktop_testing,mobile_testing,visual_studio,intellij_idea,eclipse,net_beans) " +
                        "VALUES ('Leia', 'The Princess', 4, 1, 'SENIOR_DEV', 'C2', 1,0,0,0,1,0,1,0,1,0,1,1,1,0,1,1,1,0); " +
                        "INSERT INTO EMPLOYEE(name, surname, project_id, is_teamLead, position, english_level, java, c_plus_plus, c_sharp,php, dot_net, sql,js,html,css,j_query,manual_qa, auto_qa,desktop_testing,mobile_testing,visual_studio,intellij_idea,eclipse,net_beans) " +
                        "VALUES ('Obi-One', 'Kinobi', 4, 1, 'MIDDLE_DEV', 'C2', 0,0,1,0,1,0,1,0,1,0,1,1,1,0,1,1,1,0); " +
                        "INSERT INTO EMPLOYEE(name, surname, project_id, is_teamLead, position, english_level, java, c_plus_plus, c_sharp,php, dot_net, sql,js,html,css,j_query,manual_qa, auto_qa,desktop_testing,mobile_testing,visual_studio,intellij_idea,eclipse,net_beans) " +
                        "VALUES ('C-3PO', 'Droid', 4, 0, 'SENIOR_DEV', 'A1', 1,0,1,0,1,0,1,0,1,0,1,1,1,0,1,1,1,0); " +
                        "INSERT INTO EMPLOYEE(name, surname, project_id, is_teamLead, position, english_level, java, c_plus_plus, c_sharp,php, dot_net, sql,js,html,css,j_query,manual_qa, auto_qa,desktop_testing,mobile_testing,visual_studio,intellij_idea,eclipse,net_beans) " +
                        "VALUES ('R2D2', 'Droid', 4, 0, 'MIDDLE_DEV', 'C2', 1,0,1,0,1,0,1,0,1,0,1,1,1,0,1,1,1,0); " +
                        "INSERT INTO EMPLOYEE(name, surname, project_id, is_teamLead, position, english_level, java, c_plus_plus, c_sharp,php, dot_net, sql,js,html,css,j_query,manual_qa, auto_qa,desktop_testing,mobile_testing,visual_studio,intellij_idea,eclipse,net_beans) " +
                        "VALUES ('Chewbacca', 'Chewy', 4, 1, 'SENIOR_DEV', 'B2', 1,0,1,0,1,0,1,0,0,0,1,1,1,0,1,1,1,0); " +
                        "INSERT INTO EMPLOYEE(name, surname, project_id, is_teamLead, position, english_level, java, c_plus_plus, c_sharp,php, dot_net, sql,js,html,css,j_query,manual_qa, auto_qa,desktop_testing,mobile_testing,visual_studio,intellij_idea,eclipse,net_beans) " +
                        "VALUES ('Clark', 'Kent', 5, 0, 'SENIOR_DEV', 'A1', 1,0,1,0,1,0,1,0,1,0,1,1,1,0,1,1,1,0); " +
                        "INSERT INTO EMPLOYEE(name, surname, project_id, is_teamLead, position, english_level, java, c_plus_plus, c_sharp,php, dot_net, sql,js,html,css,j_query,manual_qa, auto_qa,desktop_testing,mobile_testing,visual_studio,intellij_idea,eclipse,net_beans) " +
                        "VALUES ('Lois', 'Lane', 5, 0, 'SENIOR_DEV', 'C2', 1,0,1,1,1,0,1,0,1,1,1,1,1,0,1,1,1,0); " +
                        "INSERT INTO EMPLOYEE(name, surname, project_id, is_teamLead, position, english_level, java, c_plus_plus, c_sharp,php, dot_net, sql,js,html,css,j_query,manual_qa, auto_qa,desktop_testing,mobile_testing,visual_studio,intellij_idea,eclipse,net_beans) " +
                        "VALUES ('Katsiaryna', 'Mikhailovich', 6, 1, 'JUNIOR_DEV', 'A1', 1,1,1,0,1,0,1,0,1,0,1,1,1,0,1,1,1,0); " +
                        "INSERT INTO EMPLOYEE(name, surname, project_id, is_teamLead, position, english_level, java, c_plus_plus, c_sharp,php, dot_net, sql,js,html,css,j_query,manual_qa, auto_qa,desktop_testing,mobile_testing,visual_studio,intellij_idea,eclipse,net_beans) " +
                        "VALUES ('Anastasiya', 'Tuharava', 6, 0, 'JUNIOR_DEV', 'C1', 1,1,1,0,1,1,1,0,1,0,1,1,1,0,1,1,1,0); " +
                        "INSERT INTO EMPLOYEE(name, surname, project_id, is_teamLead, position, english_level, java, c_plus_plus, c_sharp,php, dot_net, sql,js,html,css,j_query,manual_qa, auto_qa,desktop_testing,mobile_testing,visual_studio,intellij_idea,eclipse,net_beans) " +
                        "VALUES ('Jack', 'Daniels', 5, 0, 'MIDDLE_DEV', 'A1', 1,0,1,0,1,0,1,0,1,0,1,1,1,1,1,1,1,0); " +
                        "INSERT INTO EMPLOYEE(name, surname, project_id, is_teamLead, position, english_level, java, c_plus_plus, c_sharp,php, dot_net, sql,js,html,css,j_query,manual_qa, auto_qa,desktop_testing,mobile_testing,visual_studio,intellij_idea,eclipse,net_beans) " +
                        "VALUES ('Johnny', 'Walker', 5, 1, 'MIDDLE_DEV', 'B1', 1,0,0,0,1,0,1,0,0,0,1,1,1,0,1,1,1,0); " +
                        "INSERT INTO EMPLOYEE(name, surname, project_id, is_teamLead, position, english_level, java, c_plus_plus, c_sharp,php, dot_net, sql,js,html,css,j_query,manual_qa, auto_qa,desktop_testing,mobile_testing,visual_studio,intellij_idea,eclipse,net_beans) " +
                        "VALUES ('Famous', 'Grouse', 5, 1, 'MIDDLE_DEV', 'C2', 1,0,1,0,1,0,1,0,1,0,1,1,1,0,1,1,1,0); " +
                        "INSERT INTO EMPLOYEE(name, surname, project_id, is_teamLead, position, english_level, java, c_plus_plus, c_sharp,php, dot_net, sql,js,html,css,j_query,manual_qa, auto_qa,desktop_testing,mobile_testing,visual_studio,intellij_idea,eclipse,net_beans) " +
                        "VALUES ('Jameson', 'Caskmates', 5, 0, 'JUNIOR_DEV', 'B1', 1,0,1,0,1,0,1,0,1,0,1,1,1,0,1,1,1,0); " +
                        "INSERT INTO EMPLOYEE(name, surname, project_id, is_teamLead, position, english_level, java, c_plus_plus, c_sharp,php, dot_net, sql,js,html,css,j_query,manual_qa, auto_qa,desktop_testing,mobile_testing,visual_studio,intellij_idea,eclipse,net_beans) " +
                        "VALUES ('Paul John', 'Peated', 5, 1, 'SENIOR_DEV', 'C1', 1,0,1,0,1,0,1,0,1,0,1,1,1,0,1,1,1,0); " +
                        "INSERT INTO EMPLOYEE(name, surname, project_id, is_teamLead, position, english_level, java, c_plus_plus, c_sharp,php, dot_net, sql,js,html,css,j_query,manual_qa, auto_qa,desktop_testing,mobile_testing,visual_studio,intellij_idea,eclipse,net_beans) " +
                        "VALUES ('Dillon`s', 'Rye', 5, 1, 'JUNIOR_DEV', 'C2', 1,0,1,0,1,0,1,0,1,0,1,1,1,0,1,1,1,1); " +
                        "INSERT INTO EMPLOYEE(name, surname, project_id, is_teamLead, position, english_level, java, c_plus_plus, c_sharp,php, dot_net, sql,js,html,css,j_query,manual_qa, auto_qa,desktop_testing,mobile_testing,visual_studio,intellij_idea,eclipse,net_beans) " +
                        "VALUES ('Mickey', 'Mouse', 5, 1, 'MIDDLE_QA', 'B1', 1,1,1,0,1,0,1,0,1,0,1,1,1,0,1,1,1,1); " +
                        "INSERT INTO EMPLOYEE(name, surname, project_id, is_teamLead, position, english_level, java, c_plus_plus, c_sharp,php, dot_net, sql,js,html,css,j_query,manual_qa, auto_qa,desktop_testing,mobile_testing,visual_studio,intellij_idea,eclipse,net_beans) " +
                        "VALUES ('Donald', 'Duck', 5, 0, 'MIDDLE_QA', 'B1', 1,0,1,0,1,0,1,0,1,0,1,1,1,0,1,1,1,0); " +
                        "INSERT INTO EMPLOYEE(name, surname, project_id, is_teamLead, position, english_level, java, c_plus_plus, c_sharp,php, dot_net, sql,js,html,css,j_query,manual_qa, auto_qa,desktop_testing,mobile_testing,visual_studio,intellij_idea,eclipse,net_beans) " +
                        "VALUES ('Minnie', 'Mouse', 5, 1, 'JUNIOR_QA', 'C1', 1,0,1,0,1,0,1,0,1,0,1,1,1,0,1,1,1,0); " +
                        "INSERT INTO EMPLOYEE(name, surname, project_id, is_teamLead, position, english_level, java, c_plus_plus, c_sharp,php, dot_net, sql,js,html,css,j_query,manual_qa, auto_qa,desktop_testing,mobile_testing,visual_studio,intellij_idea,eclipse,net_beans) " +
                        "VALUES ('Pluto', 'The Dog', 5, 1, 'JUNIOR_QA', 'C2', 1,0,1,0,1,0,1,0,1,0,1,1,1,0,1,1,1,0); ";

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
