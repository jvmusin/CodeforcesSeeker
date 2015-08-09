package core;

import api.APIHolder;
import base.CFResponse;
import base.User;
import controller.UserSeekerLayoutController;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.Tab;

import java.util.*;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class UserSeeker {
    private ObservableList<Tab> openedTabs;
    private ObservableList<UserDataHolder> users;

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
                Thread.sleep(3000);
                String handles = openedTabs.stream().map(Tab::getText).collect(Collectors.joining(";"));
                if (handles.length() == 0) continue;
                Logger.getGlobal().info("Seekeing users " + handles);

                CFResponse<List<User>> info = APIHolder.getUserAPI().getInfo(handles);
                if (info.getExtendedStatus() == CFResponse.ExtendedStatus.SERVER_ERROR) {
                    getServerErrorAlert().showAndWait();
                    continue;
                }

                StringJoiner changedUsers = new StringJoiner("\n");

                info.getResult().forEach(userNow -> {
                    int pos = Collections.binarySearch(users, userNow);
                    if (pos < 0) return;

                    UserDataHolder userBeforeDataHolder = users.get(pos);
                    User userBefore = userBeforeDataHolder.getUser();
                    if (!userNow.equals(userBefore)) return;

                    boolean changed = userBeforeDataHolder.compareAndChangeLabels(userNow);
                    if (changed) changedUsers.add(userNow.getHandle());
                });

                System.out.println("CHANGED USERS\n" + changedUsers);
            } catch (InterruptedException e) {
                Logger.getGlobal().throwing(getClass().getName(), "seek()", e);
                return;
            } catch (ConcurrentModificationException ignored) {}
        }
    }

    private Alert getServerErrorAlert() {
        return null;
    }
}
