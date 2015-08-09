package core;

import controller.UserSeekerLayoutController;

public final class ServiceHolder {

    private ServiceHolder() {}

    private static UserSeekerLayoutController userSeekerLayoutController;
    private static MainApp mainApp;

    public static void setUserSeekerLayoutController(UserSeekerLayoutController controller) {
        userSeekerLayoutController = controller;
    }

    public static void setMainApp(MainApp mainApp) {
        ServiceHolder.mainApp = mainApp;
    }

    public static UserSeekerLayoutController getUserSeekerLayoutController() {
        return userSeekerLayoutController;
    }

    public static MainApp getMainApp() {
        return mainApp;
    }
}
