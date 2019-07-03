package by.iba.management.view.fxml;

import by.iba.management.model.entity.Project;
import by.iba.management.model.entity.ProjectsRepository;
import by.iba.management.model.logic.impl.FindProjectImpl;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class ProjectsListController {

    @FXML
    Button fxFindProjectButton;
    RadioButton fxSearchByProjectId;
    RadioButton fxSearchByProjectName;
    TextField fxFindProjectTextField;
    TableView projectsListTable;
    TableColumn fxProjectId;
    TableColumn fxProjectName;
    TableColumn fxProjectDescription;

    @FXML
    private void displayProjectsList() {
        ArrayList<Project> projectsList = ProjectsRepository.getProjectList();
        for (Project p: projectsList) {
            fxProjectId.setCellValueFactory(new PropertyValueFactory<Project, String>(p.getProjectId());
            fxProjectName.setCellValueFactory(new PropertyValueFactory<Project, String>(p.getProjectName()));
            fxProjectDescription.setCellValueFactory(new PropertyValueFactory<Project, String>(p.getProjectDescription()));
            projectsListTable.setItems((ObservableList) projectsList);
        }

        /*ObservableList<Project> projectsList =
                FXCollections.observableArrayList(ProjectsRepository.getProjectList());
        for (Project p : projectsList) {
            fxProjectId.setCellValueFactory(new PropertyValueFactory<Project, String>(p.getProjectId());
            fxProjectName.setCellValueFactory(new PropertyValueFactory<Project, String>(p.getProjectName()));
            fxProjectDescription.setCellValueFactory(new PropertyValueFactory<Project, String>(p.getProjectDescription()));
            projectsListTable.setItems(projectsList);
        }*/
    }

    @FXML
    private void findProject(ActionEvent event) {
        fxFindProjectTextField.setPromptText("Search");
        ListView list = new ListView();

        list.setMaxHeight(180);
        ArrayList<Project> projectsList = ProjectsRepository.getProjectList();
        projectsListTable.setItems((ObservableList) projectsList);

        String searchField = fxFindProjectTextField.getText();
        Boolean id = fxSearchByProjectId.isSelected();
        Boolean name = fxSearchByProjectName.isSelected();
        ToggleGroup tg = new ToggleGroup();
        fxSearchByProjectId.setToggleGroup(tg);
        fxSearchByProjectName.setToggleGroup(tg);

        fxFindProjectButton.setOnAction(ActionEvent event) {
            RadioButton rb = (RadioButton)tg.getSelectedToggle();
            if (rb.equals(fxSearchByProjectId)){
                FindProjectImpl searchReasultById = new FindProjectImpl();
                searchReasultById.findProjectById(Long.parseLong(searchField));
            }
            if (rb.equals(fxSearchByProjectName)){
                FindProjectImpl searchResultByName = new FindProjectImpl();
                searchResultByName.findProjectByName(searchField);
            }
        }
    }
}