package by.iba.management.view.fxml;

import by.iba.management.model.entity.Project;
import by.iba.management.model.entity.ProjectsRepository;
import by.iba.management.model.logic.impl.FindProjectImpl;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import javafx.event.ActionEvent;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ProjectsListController {

    @FXML
    public void initialize() {
        fxFindProjectTextField.setPromptText("Search");
        ArrayList<Project> projectsList = ProjectsRepository.getProjectList();
        for (Project p : projectsList) {
            projectId.setCellValueFactory(new PropertyValueFactory<>("projectId"));
            projectName.setCellValueFactory(new PropertyValueFactory<>("projectName"));
            projectDescription.setCellValueFactory(new PropertyValueFactory<>("projectDescription"));
        }
        ObservableList<Project> projectsOList = FXCollections.observableList(projectsList);
        fxProjectsListTable.setItems(projectsOList);
        showProjectDetails(null);
        fxProjectsListTable.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) ->
                        showProjectDetails(newValue));
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
    @FXML
    Label projectIdLabel;
    @FXML
    Label projectNameLabel;
    @FXML
    Label projectDescriptionLabel;

    @FXML
    private void openProjectProfile(ActionEvent event) throws IOException {
        String projectProfileLink = "/by/iba/management/view/fxml/ProjectProfile.fxml";
        Parent projectsList = FXMLLoader.load(getClass().getResource(projectProfileLink));
        Scene projectProfile = new Scene(projectsList);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(projectProfile);
        window.show();
    }

    @FXML
    private void findProject(ActionEvent event) {
        //fxFindProjectTextField.setPromptText("Search");
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

    private void showProjectDetails(Project project) {
        if (project != null) {
            projectIdLabel.setText(String.valueOf(project.getProjectId()));
            projectNameLabel.setText(project.getProjectName());
            projectDescriptionLabel.setText(project.getProjectDescription());
        }
        else {
            projectIdLabel.setText("empty");
            projectNameLabel.setText("empty");
            projectDescriptionLabel.setText("empty");
        }
    }

    @FXML
    private void backToMain(ActionEvent event) throws IOException {
        String mainPageLink = "/by/iba/management/view/fxml/mainPage.fxml";
        Parent projectsList = FXMLLoader.load(getClass().getResource(mainPageLink));
        Scene mainPage = new Scene(projectsList);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(mainPage);
        window.show();
    }
}
