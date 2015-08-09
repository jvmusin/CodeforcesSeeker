package core;

import base.User;
import controller.UserSeekerGridController;
import javafx.fxml.FXMLLoader;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;

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
        if (gridController == null)
            try {
                gridController = FXMLLoader.load(getClass().getResource("/UserSeekerGrid.fxml"));
                gridController.setUser(user);
            } catch (IOException e) {
                e.printStackTrace();
            }
        return gridController;
    }

    public boolean compareAndChangeLabels(User userNow) {
        boolean updated = false;

        if (!user.getHandle().equals(userNow.getHandle())) { updated = true; gridController.updateHandleLabels(); }
        if (!user.getEmail().equals(userNow.getEmail())) { updated = true; gridController.updateEmailLabels(); }
        if (!user.getVkId().equals(userNow.getVkId())) { updated = true; gridController.updateVkIDLabels(); }
        if (!user.getOpenId().equals(userNow.getOpenId())) { updated = true; gridController.updateOpenIDLabels(); }
        if (!user.getFirstName().equals(userNow.getFirstName())) { updated = true; gridController.updateFirstNameLabels(); }
        if (!user.getLastName().equals(userNow.getLastName())) { updated = true; gridController.updateLastNameLabels(); }
        if (!user.getCountry().equals(userNow.getCountry())) { updated = true; gridController.updateCountryLabels(); }
        if (!user.getCity().equals(userNow.getCity())) { updated = true; gridController.updateCityLabels(); }
        if (!user.getOrganization().equals(userNow.getOrganization())) { updated = true; gridController.updateOrganizationLabels(); }
        if (!user.getContribution().equals(userNow.getContribution())) { updated = true; gridController.updateContributionLabels(); }
        if (!user.getRank().equals(userNow.getRank())) { updated = true; gridController.updateRankLabels(); }
        if (!user.getMaxRank().equals(userNow.getMaxRank())) { updated = true; gridController.updateMaxRankLabels(); }
        if (!user.getRating().equals(userNow.getRating())) { updated = true; gridController.updateRatingLabels(); }
        if (!user.getMaxRating().equals(userNow.getMaxRating())) { updated = true; gridController.updateMaxRatingLabels(); }
        if (!user.getLastOnlineTimeSeconds().equals(userNow.getLastOnlineTimeSeconds())) { updated = true; gridController.updateLastVisitLabels(); }
        if (!user.getRegistrationTimeSeconds().equals(userNow.getRegistrationTimeSeconds())) { updated = true; gridController.updateRegisteredLabels(); }

//        return updated;
        return gridController.updateUserIfPossible(userNow);
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
