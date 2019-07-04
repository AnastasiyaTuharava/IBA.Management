package by.iba.management.view.fxml;

import by.iba.management.model.entity.Project;
import by.iba.management.model.entity.ProjectsRepository;
import by.iba.management.model.logic.impl.FindProjectImpl;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import javafx.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ProjectsListController {

    @FXML
    public void initialize(){
        fxFindProjectTextField.setPromptText("Search");
        ArrayList<Project> projectsList = ProjectsRepository.getProjectList();
        for (Project p: projectsList) {
            projectId.setCellValueFactory(new PropertyValueFactory<Project, String>("projectId"));
            projectName.setCellValueFactory(new PropertyValueFactory<Project, String>("projectName"));
            projectDescription.setCellValueFactory(new PropertyValueFactory<Project, String>("projectDescription"));

        }
        //List<String> projectsListStr = projectsList.stream().map(Project::toString).collect(Collectors.toList());
        ObservableList<Project> projectsOList = FXCollections.observableList(projectsList);
        System.out.println(projectsOList);
        /*for (Project p: projectsList) {
            projectId.setCellFactory(new PropertyValueFactory<Project, String>(Long.toString(p.getProjectId())));
            projectName.setCellValueFactory(new PropertyValueFactory<Project, String>(p.getProjectName()));
            projectDescription.setCellValueFactory(new PropertyValueFactory<Project, String>(p.getProjectDescription()));

        }*/
        fxProjectsListTable.setItems(projectsOList);
    }

    @FXML
    Button fxFindProjectButton;
    @FXML
    RadioButton fxSearchByProjectId;
    @FXML
    RadioButton fxSearchByProjectName;
    @FXML
    TextField fxFindProjectTextField;
    @FXML
    TableView<Project> fxProjectsListTable;
    @FXML
    TableColumn<Project, String> projectId;
    @FXML
    TableColumn<Project, String> projectName;
    @FXML
    TableColumn<Project, String> projectDescription;

    /*@FXML
    private void displayProjectsList() {
        ArrayList<Project> projectsList = ProjectsRepository.getProjectList();
        for (Project p: projectsList) {
            fxProjectId.setCellFactory(new PropertyValueFactory<Project, String>(Long.toString(p.getProjectId())));
            fxProjectName.setCellFactory(new PropertyValueFactory<Project, String>(p.getProjectName()));
            fxProjectDescription.setCellFactory(new PropertyValueFactory<Project, String>(p.getProjectDescription()));

        }
        ObservableList<Project> projectsOList = FXCollections.observableList(projectsList);
        System.out.println(projectsOList);
        projectsListTable.setItems(projectsOList);
    }*/

    @FXML
    private void findProject(ActionEvent event) {
        fxFindProjectTextField.setPromptText("Search");
        ListView list = new ListView();

        list.setMaxHeight(180);
        ArrayList<Project> projectsList = ProjectsRepository.getProjectList();
        fxProjectsListTable.setItems((ObservableList) projectsList);

        String searchField = fxFindProjectTextField.getText();
        ToggleGroup tg = new ToggleGroup();
        fxSearchByProjectId.setToggleGroup(tg);
        fxSearchByProjectName.setToggleGroup(tg);

        fxFindProjectButton.setOnAction(event1 -> {
            RadioButton rb = (RadioButton)tg.getSelectedToggle();
            if (rb.equals(fxSearchByProjectId)){
                FindProjectImpl searchReasultById = new FindProjectImpl();
                searchReasultById.findProjectById(Long.parseLong(searchField));
            }
            if (rb.equals(fxSearchByProjectName)){
                FindProjectImpl searchResultByName = new FindProjectImpl();
                searchResultByName.findProjectByName(searchField);
            }
        });
    }
}
