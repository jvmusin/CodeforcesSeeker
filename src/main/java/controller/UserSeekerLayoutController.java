package controller;

import api.APIHolder;
import base.CFResponse;
import base.User;
import core.MainApp;
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

import java.io.IOException;
import java.net.URL;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.concurrent.ForkJoinPool;

public class UserSeekerLayoutController implements Initializable {
    @FXML private Label handlesHeaderLabel;
    @FXML private TabPane seekingUsersTabPane;
    @FXML private ListView<UserDataHolder> foundUsersListView;
    @FXML private TextField userFinderHandleField;
    @FXML private Button userFinderFindButton;
    @FXML private Label userFinderStatusLabel;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ServiceHolder.setUserSeekerLayoutController(this);
        new UserSeeker().startSeeking();
        try {
            seekingUsersTabPane.getTabs().add(new Tab("first", FXMLLoader.load(getClass().getResource("/UserSeekerGrid.fxml"))));
            seekingUsersTabPane.getTabs().add(new Tab("second", FXMLLoader.load(getClass().getResource("/UserSeekerGrid.fxml"))));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void startSeekingSelectedUsers(ActionEvent event) {
        UserDataHolder selectedUserHolder = foundUsersListView.getSelectionModel().getSelectedItem();
        seekingUsersTabPane.getTabs().add(new Tab(selectedUserHolder.getUser().getHandle(), selectedUserHolder.getFullUserPane()));

        System.out.println("startSeekingSelectedUsers() meth");
    }

    @FXML
    public void removeSelectedUsers(ActionEvent event) {
        System.out.println("removeSelectedUsers() meth");
    }

    @FXML
    public void handleFind(ActionEvent event) {
        String handle = userFinderHandleField.getText().trim();
        if (!isHandleValid(handle)) {
            userFinderStatusLabel.setText("Handle is not valid!");
            userFinderStatusLabel.setId("userNotFoundLabel");
            return;
        }

        ServiceHolder.getMainApp().getPool().submit(() -> {
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