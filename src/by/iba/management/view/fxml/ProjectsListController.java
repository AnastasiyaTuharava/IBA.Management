package by.iba.management.view.fxml;

import by.iba.management.dao.ProjectDAO;
import by.iba.management.dao.impl.ProjectDAOImpl;
import by.iba.management.model.entity.Project;
import by.iba.management.model.logic.impl.EditProjectImpl;
import by.iba.management.model.logic.impl.FindProjectImpl;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;

public class ProjectsListController {

    private final ProjectDAO projectDAO = new ProjectDAOImpl();

    @FXML
    Button fxFindProjectButton;
    @FXML
    Button fxDeleteProjectButton;
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
    public void initialize() {
        fxFindProjectTextField.setPromptText("Search");
        List<Project> projectsList = projectDAO.getProjects();
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
        fxFindProjectTextField.setPromptText("Search");
        ListView list = new ListView();

        list.setMaxHeight(180);
        List<Project> projectsList = projectDAO.getProjects();
        fxProjectsListTable.setItems(FXCollections.observableArrayList(projectsList));

        String searchField = fxFindProjectTextField.getText();
        ToggleGroup tg = new ToggleGroup();
        fxSearchByProjectId.setToggleGroup(tg);
        fxSearchByProjectName.setToggleGroup(tg);

        fxFindProjectButton.setOnAction(event1 -> {
            RadioButton rb = (RadioButton) tg.getSelectedToggle();
            if (rb.equals(fxSearchByProjectId)) {
                FindProjectImpl searchReasultById = new FindProjectImpl();
                searchReasultById.findProjectById(Long.parseLong(searchField));
            }
            if (rb.equals(fxSearchByProjectName)) {
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
        } else {
            projectIdLabel.setText("empty");
            projectNameLabel.setText("empty");
            projectDescriptionLabel.setText("empty");
        }
    }

    @FXML
    private void handleDeleteProject() {
        int line = fxProjectsListTable.getSelectionModel().getSelectedIndex();
        fxProjectsListTable.getItems().remove(line);
        EditProjectImpl deleteProject = new EditProjectImpl();
        deleteProject.removeProject(line);
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

    @FXML
    private void exportProjectsToExcel(ActionEvent event) throws IOException {

    }
}
