package core;

import base.User;
import controller.UserSeekerGridController;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.RunnableFuture;

public class UserDataHolder implements Comparable<User> {
    private UserSeekerGridController gridController;
    private User user;

    public UserDataHolder(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public UserSeekerGridController getGridController() {
        if (gridController == null) {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/UserSeekerGrid.fxml"));
                loader.load();
                gridController = loader.getController();
                Platform.runLater(() -> gridController.setUser(user));
            } catch (IOException ioe) {
                ioe.printStackTrace();
                return null;
            }
        }
        return gridController;
    }

    public Pane getFullUserSide() {
        return getGridController().getFullUserSide();
    }

    public boolean compareAndChangeLabels(User userNow) {
        RunnableFuture<Boolean> updater = new FutureTask<>(() -> getGridController().tryUpdateUser(userNow));
        Platform.runLater(updater);

        boolean updated = false;
        try {
            updated = updater.get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
            ServiceHolder.getMainApp().closeApplication();
        }
        return updated;
    }

    @Override
    public int compareTo(User anotherUser) {
        return user.getHandle().compareToIgnoreCase(anotherUser.getHandle());
    }

    @Override
    public String toString() {
        return user.getHandle();
    }
}
