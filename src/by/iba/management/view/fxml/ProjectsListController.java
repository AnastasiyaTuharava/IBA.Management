package by.iba.management.view.fxml;

import by.iba.management.dao.EmployeeDAO;
import by.iba.management.dao.ProjectDAO;
import by.iba.management.model.entity.Project;
import by.iba.management.model.logic.ProjectLogic;
import by.iba.management.util.DataWriterProject;
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
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

public class ProjectsListController {

    @FXML
    Button fxFindProjectButton;
    @FXML
    Button fxDeleteProjectButton;
    @FXML
    Button openProjectButton;
    @FXML
    Button addNewProjectButton;
    @FXML
    RadioButton fxSearchByProjectId;
    @FXML
    RadioButton fxSearchByProjectName;
    @FXML
    Button fxExportProjectsToExcelButton;
    @FXML
    Button clearSearchButton;
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
        List<Project> projectsList = ProjectLogic.getProjects();
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

    private void prepare(ActionEvent event, String link) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(link));
        Parent projectsListPage = loader.load();
        Object mainPageController = loader.getController();
        if (mainPageController instanceof ProjectProfileController) {
            ((ProjectProfileController) mainPageController).initProject(Integer.parseInt(projectIdLabel.getText()));
        }
        Scene mainPageScene = new Scene(projectsListPage);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(mainPageScene);
        window.centerOnScreen();
        window.show();
    }

    @FXML
    private void openProjectProfile(ActionEvent event) throws IOException {
        String projectProfileLink = "/by/iba/management/view/fxml/ProjectProfile.fxml";
        prepare(event, projectProfileLink);
    }

    @FXML
    private void addNewProject(ActionEvent event) throws IOException {
        String addNewProjectLink = "/by/iba/management/view/fxml/AddNewProject.fxml";
        prepare(event, addNewProjectLink);
    }

    @FXML
    private void handleDeleteProject(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation");
        alert.setHeaderText("Are you sure you want to delete this project from the system?");
        alert.setContentText("Please note that data cannot be restored.");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            int line = fxProjectsListTable.getSelectionModel().getSelectedIndex();
            Project project = fxProjectsListTable.getItems().get(line);
            ProjectLogic.unassignEmployee(project.getProjectId());
            ProjectLogic.removeProject(project);
            fxProjectsListTable.getItems().remove(line);
            alert.close();
        } else {
            alert.close();
        }
    }

    @FXML
    private void findProject() {
        String searchField = fxFindProjectTextField.getText();
        List<Project> searchResult = ProjectLogic.findProjectsByName(searchField);
        for (Project p : searchResult) {
            projectId.setCellValueFactory(new PropertyValueFactory<>("projectId"));
            projectName.setCellValueFactory(new PropertyValueFactory<>("projectName"));
            projectDescription.setCellValueFactory(new PropertyValueFactory<>("projectDescription"));
        }
        ObservableList<Project> projectsOList = FXCollections.observableList(searchResult);
        fxProjectsListTable.setItems(projectsOList);
        showProjectDetails(null);
        fxProjectsListTable.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) ->
                        showProjectDetails(newValue));
    }

    @FXML
    private void clearSearchResults(){
        initialize();
        fxFindProjectTextField.clear();
    }


    @FXML
    private void backToMain(ActionEvent event) throws IOException {
        String mainPageLink = "/by/iba/management/view/fxml/mainPage.fxml";
        prepare(event, mainPageLink);
    }

    @FXML
    private void exportProjectsToExcel() {
        DataWriterProject.writeProjectToFile();
        }
}
