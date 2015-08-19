package controller;

import api.APIHolder;
import base.CFResponse;
import base.User;
import core.ServiceHolder;
import core.UserDataHolder;
import core.UserSeeker;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ResourceBundle;

public class UserSeekerLayoutController implements Initializable {
    @FXML private VBox fullListSide;
    @FXML private TabPane seekingUsersTabPane;
    @FXML private ListView<UserDataHolder> foundUsersListView;
    @FXML private TextField userFinderHandleField;
    @FXML private Label userFinderStatusLabel;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ServiceHolder.setUserSeekerLayoutController(this);
        new UserSeeker().startSeeking();

        try {
            seekingUsersTabPane.getTabs().add(new Tab("ex", FXMLLoader.load(getClass().getResource("/UserSeekerGrid.fxml"))));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void startSeekingSelectedUsers(ActionEvent event) {
        foundUsersListView.getSelectionModel().getSelectedItems().forEach(userDataHolder ->
                seekingUsersTabPane.getTabs().add(new Tab(userDataHolder.getUser().getHandle(), userDataHolder.getFullUserSide())));
    }

    @FXML
    public void removeSelectedUsers(ActionEvent event) {
        List<UserDataHolder> selectedDataHolders = new ArrayList<>(foundUsersListView.getSelectionModel().getSelectedItems());

        selectedDataHolders.forEach(userDataHolder -> {
            ObservableList<Tab> tabs = seekingUsersTabPane.getTabs();
            tabs.removeIf(tab -> tab.getText().equals(userDataHolder.getUser().getHandle()));
        });

        foundUsersListView.getItems().removeAll(selectedDataHolders);
    }

    @FXML
    public void handleFind(ActionEvent event) {
        String handle = userFinderHandleField.getText().trim();
        if (!isHandleValid(handle)) {
            userFinderStatusLabel.setText("Handle is not valid!");
            userFinderStatusLabel.setId("userNotFoundLabel");
            return;
        }

        ServiceHolder.getMainApp().submitTask(() -> {
            Platform.runLater(() -> {
                userFinderStatusLabel.setText("Finding " + handle);
                userFinderStatusLabel.setId("userFindingInProcessLabel");
            });

            CFResponse<List<User>> info = APIHolder.getUserAPI().getInfo(handle);

            Platform.runLater(() -> {
                if (info.getStatus() == CFResponse.Status.FAILED) {
                    switch (info.getExtendedStatus()) {
                        case USER_NOT_FOUND:
                            userFinderStatusLabel.setText(handle + " not found");
                            userFinderStatusLabel.setId("userNotFoundLabel");
                            break;

                        case SERVER_ERROR:
                            userFinderStatusLabel.setText("Server error");
                            userFinderStatusLabel.setId("serverErrorLabel");
                            break;
                    }
                    return;
                }

                User user = info.getResult().get(0);
                @SuppressWarnings("unchecked")
                int pos = Collections.binarySearch((List) foundUsersListView.getItems(), user);
                if (pos >= 0) {
                    //  User already found
                    return;
                }
                pos = -(pos + 1);
                foundUsersListView.getItems().add(pos, new UserDataHolder(user));

                userFinderStatusLabel.setText(user.getHandle() + " found!");
                userFinderStatusLabel.setId("userFoundLabel");
                userFinderHandleField.clear();
            });
        });
    }
    private boolean isHandleValid(String handle) {
        return handle.matches("[\\w\\d_-]{3,24}");
    }

    public TabPane getSeekingUsersTabPane() {
        return seekingUsersTabPane;
    }

    public ObservableList<UserDataHolder> getFoundUsersList() {
        return foundUsersListView.getItems();
    }
}