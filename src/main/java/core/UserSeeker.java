package core;

import api.APIHolder;
import base.CFResponse;
import base.User;
import controller.UserSeekerLayoutController;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.Tab;
import javafx.stage.Modality;

import java.util.Collections;
import java.util.ConcurrentModificationException;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.RunnableFuture;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class UserSeeker {
    private final long DELAY = 3000L;
    private final ObservableList<Tab> openedTabs;
    private final ObservableList<UserDataHolder> users;

    public UserSeeker() {
        UserSeekerLayoutController userSeekerLayoutController = ServiceHolder.getUserSeekerLayoutController();
        openedTabs = userSeekerLayoutController.getSeekingUsersTabPane().getTabs();
        users = userSeekerLayoutController.getFoundUsersList();
    }

    public void startSeeking() {
        ServiceHolder.getMainApp().getPool().submit(this::seek);
    }

    private void seek() {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                Thread.sleep(DELAY);
                String handles = openedTabs.stream().map(Tab::getText).collect(Collectors.joining(";"));
                if (handles.length() == 0) continue;
                Logger.getGlobal().info("Seeking users " + handles);

                CFResponse<List<User>> info = APIHolder.getUserAPI().getInfo(handles);
                if (info.getStatus() == CFResponse.Status.FAILED) {
                    switch (info.getExtendedStatus()) {
                        case SERVER_ERROR:
                            showServerErrorAlert();
                        case USER_NOT_FOUND:    //  Test user is on the pane
                            continue;
                    }
                }

                List<String> updatedUsers = null;

                for (User userNow : info.getResult()) {
                    int pos = Collections.binarySearch(users, userNow);
                    if (pos < 0) continue;

                    UserDataHolder userBeforeDataHolder = users.get(pos);
                    User userBefore = userBeforeDataHolder.getUser();
                    if (!userNow.equals(userBefore)) continue;

                    boolean changed = userBeforeDataHolder.compareAndChangeLabels(userNow);
                    if (changed) {
                        if (updatedUsers == null) updatedUsers = new LinkedList<>();
                        updatedUsers.add(userNow.getHandle());
                    }
                }

                if (updatedUsers != null)
                    showUsersUpdatedAlert(updatedUsers);
            } catch (InterruptedException e) {
                Logger.getGlobal().throwing(getClass().getName(), "seek()", e);
                Platform.exit();
                return;
            } catch (ConcurrentModificationException ignored) {}
        }
    }

    private void showUsersUpdatedAlert(List<String> updatedUsers) {
        try {
            RunnableFuture<Void> work = new FutureTask<>(() -> {

                Alert alert = prepareAlert(
                        Alert.AlertType.INFORMATION,
                        "Information",
                        "Some users have been updated",
                        "Updated users:\n\n" + String.join(",\n", updatedUsers)
                );

                alert.showAndWait();
                return null;
            });

            Platform.runLater(work);
            work.get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
    private void showServerErrorAlert() {
        try {
            RunnableFuture<Void> work = new FutureTask<>(() -> {

                Alert alert = prepareAlert(
                        Alert.AlertType.WARNING,
                        "Information",
                        "Server error",
                        "Codeforces server doesn't work"
                );

                alert.showAndWait();
                return null;
            });

            Platform.runLater(work);
            work.get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }

    private Alert prepareAlert(Alert.AlertType type, String title, String header, String contentText) {
        Alert alert = new Alert(type);
        alert.setContentText(contentText);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.initModality(Modality.APPLICATION_MODAL);
        alert.setResizable(false);
        return alert;
    }
}
