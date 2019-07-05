package by.iba.management.controller;

import by.iba.management.model.entity.Project;
import by.iba.management.model.entity.ProjectsRepository;
import by.iba.management.util.DataWriterProject;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.StageStyle;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application /*implements Runnable*/{

        public static void main(String[] args) {

                /*Project p1 = new Project("HelloWorld", "First line");
                ProjectsRepository.getProjectList().add(p1);
                for (Project p : ProjectsRepository.getProjectList()) {
                        System.out.println(p);
                }
                DataWriterProject.writeProjectToFile(ProjectsRepository.getProjectList());*/

                    /*ArrayList<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee(EmployeeIdGenerator.getEmployeeId(), "Bob", "Marley",
                7, true, Position.JUNIOR_QA, EnglishLanguageLevel.C1,
                new ProgrammingLanguage(true, false, false, false, false),
                new Skills(true, true, true, true, false),
                new Testing(false, false,false, false),
                new Tools(true, true, false, true)));
        DataWriterEmployee.writeEmployeeToFile(employeeList, p1);*/

                launch(args);
        }
        /*@Override
        public void run () {

        }*/
        @Override
        public void start(Stage primaryStage) throws IOException {
                Stage stage = new Stage();
                String fxmlLink = "/by/iba/management/view/fxml/mainPage.fxml";
                Parent root = FXMLLoader.load(getClass().getResource(fxmlLink));
                stage.setTitle("Management Tool");
                stage.setScene(new Scene(root));
                stage.sizeToScene();
                stage.show();
        }
}
