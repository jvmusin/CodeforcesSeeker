package controller;

import base.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

import java.net.URL;
import java.util.ResourceBundle;

public class UserSeekerGridController implements Initializable {
    @FXML private GridPane userSeekerGrid;

    @FXML private Label defaultBeforeLabel;
    @FXML private Label defaultNowLabel;

    @FXML private Label defaultHandleLabel;
    @FXML private Label defaultEmailLabel;
    @FXML private Label defaultVkIDLabel;
    @FXML private Label defaultOpenIDLabel;
    @FXML private Label defaultFirstNameLabel;
    @FXML private Label defaultLastNameLabel;
    @FXML private Label defaultCountryLabel;
    @FXML private Label defaultCityLabel;
    @FXML private Label defaultOrganizationLabel;
    @FXML private Label defaultContributionLabel;
    @FXML private Label defaultRankLabel;
    @FXML private Label defaultMaxRankLabel;
    @FXML private Label defaultRatingLabel;
    @FXML private Label defaultMaxRatingLabel;
    @FXML private Label defaultLastVisitLabel;
    @FXML private Label defaultRegisteredLabel;

    @FXML private Label beforeHandleLabel;
    @FXML private Label beforeEmailLabel;
    @FXML private Label beforeVkIDLabel;
    @FXML private Label beforeOpenIDLabel;
    @FXML private Label beforeFirstNameLabel;
    @FXML private Label beforeLastNameLabel;
    @FXML private Label beforeCountryLabel;
    @FXML private Label beforeCityLabel;
    @FXML private Label beforeOrganizationLabel;
    @FXML private Label beforeContributionLabel;
    @FXML private Label beforeRankLabel;
    @FXML private Label beforeMaxRankLabel;
    @FXML private Label beforeRatingLabel;
    @FXML private Label beforeMaxRatingLabel;
    @FXML private Label beforeLastVisitLabel;
    @FXML private Label beforeRegisteredLabel;

    @FXML private Label nowHandleLabel;
    @FXML private Label nowEmailLabel;
    @FXML private Label nowVkIDLabel;
    @FXML private Label nowOpenIDLabel;
    @FXML private Label nowFirstNameLabel;
    @FXML private Label nowLastNameLabel;
    @FXML private Label nowCountryLabel;
    @FXML private Label nowCityLabel;
    @FXML private Label nowOrganizationLabel;
    @FXML private Label nowContributionLabel;
    @FXML private Label nowRankLabel;
    @FXML private Label nowMaxRankLabel;
    @FXML private Label nowRatingLabel;
    @FXML private Label nowMaxRatingLabel;
    @FXML private Label nowLastVisitLabel;
    @FXML private Label nowRegisteredLabel;

    @FXML private Button rememberButton;
    private User user;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        beforeHandleLabel.setText("beforeHandleLabel");
        beforeEmailLabel.setText("beforeEmailLabel");
        beforeVkIDLabel.setText("beforeVkIDLabel");
        beforeOpenIDLabel.setText("beforeOpenIDLabel");
        beforeFirstNameLabel.setText("beforeFirstNameLabel");
        beforeLastNameLabel.setText("beforeLastNameLabel");
        beforeCountryLabel.setText("beforeCountryLabel");
        beforeCityLabel.setText("beforeCityLabel");
        beforeOrganizationLabel.setText("beforeOrganizationLabel");
        beforeContributionLabel.setText("beforeContributionLabel");
        beforeRankLabel.setText("beforeRankLabel");
        beforeMaxRankLabel.setText("beforeMaxRankLabel");
        beforeRatingLabel.setText("beforeRatingLabel");
        beforeMaxRatingLabel.setText("beforeMaxRatingLabel");
        beforeLastVisitLabel.setText("beforeLastVisitLabel");
        beforeRegisteredLabel.setText("beforeRegisteredLabel");

        nowHandleLabel.setText("nowHandleLabel");
        nowEmailLabel.setText("nowEmailLabel");
        nowVkIDLabel.setText("nowVkIDLabel");
        nowOpenIDLabel.setText("nowOpenIDLabel");
        nowFirstNameLabel.setText("nowFirstNameLabel");
        nowLastNameLabel.setText("nowLastNameLabel");
        nowCountryLabel.setText("nowCountryLabel");
        nowCityLabel.setText("nowCityLabel");
        nowOrganizationLabel.setText("nowOrganizationLabel");
        nowContributionLabel.setText("nowContributionLabel");
        nowRankLabel.setText("nowRankLabel");
        nowMaxRankLabel.setText("nowMaxRankLabel");
        nowRatingLabel.setText("nowRatingLabel");
        nowMaxRatingLabel.setText("nowMaxRatingLabel");
        nowLastVisitLabel.setText("nowLastVisitLabel");
        nowRegisteredLabel.setText("nowRegisteredLabel");
    }

    public void setUser(User user) {
        this.user = user;

        beforeHandleLabel.setText("beforeHandleLabel");
        beforeEmailLabel.setText("beforeEmailLabel");
        beforeVkIDLabel.setText("beforeVkIDLabel");
        beforeOpenIDLabel.setText("beforeOpenIDLabel");
        beforeFirstNameLabel.setText("beforeFirstNameLabel");
        beforeLastNameLabel.setText("beforeLastNameLabel");
        beforeCountryLabel.setText("beforeCountryLabel");
        beforeCityLabel.setText("beforeCityLabel");
        beforeOrganizationLabel.setText("beforeOrganizationLabel");
        beforeContributionLabel.setText("beforeContributionLabel");
        beforeRankLabel.setText("beforeRankLabel");
        beforeMaxRankLabel.setText("beforeMaxRankLabel");
        beforeRatingLabel.setText("beforeRatingLabel");
        beforeMaxRatingLabel.setText("beforeMaxRatingLabel");
        beforeLastVisitLabel.setText("beforeLastVisitLabel");
        beforeRegisteredLabel.setText("beforeRegisteredLabel");
    }

    public void updateHandleLabels() { updateChangedLabels(beforeHandleLabel, nowHandleLabel); }
    public void updateEmailLabels() { updateChangedLabels(beforeEmailLabel, nowEmailLabel); }
    public void updateVkIDLabels() { updateChangedLabels(beforeVkIDLabel, nowVkIDLabel); }
    public void updateOpenIDLabels() { updateChangedLabels(beforeOpenIDLabel, nowOpenIDLabel); }
    public void updateFirstNameLabels() { updateChangedLabels(beforeFirstNameLabel, nowFirstNameLabel); }
    public void updateLastNameLabels() { updateChangedLabels(beforeLastNameLabel, nowLastNameLabel); }
    public void updateCountryLabels() { updateChangedLabels(beforeCountryLabel, nowCountryLabel); }
    public void updateCityLabels() { updateChangedLabels(beforeCityLabel, nowCityLabel); }
    public void updateOrganizationLabels() { updateChangedLabels(beforeOrganizationLabel, nowOrganizationLabel); }
    public void updateContributionLabels() { updateChangedLabels(beforeContributionLabel, nowContributionLabel); }
    public void updateRankLabels() { updateChangedLabels(beforeRankLabel, nowRankLabel); }
    public void updateMaxRankLabels() { updateChangedLabels(beforeMaxRankLabel, nowMaxRankLabel); }
    public void updateRatingLabels() { updateChangedLabels(beforeRatingLabel, nowRatingLabel); }
    public void updateMaxRatingLabels() { updateChangedLabels(beforeMaxRatingLabel, nowMaxRatingLabel); }
    public void updateLastVisitLabels() { updateChangedLabels(beforeLastVisitLabel, nowLastVisitLabel); }
    public void updateRegisteredLabels() { updateChangedLabels(beforeRegisteredLabel, nowRegisteredLabel); }

    public boolean updateUserIfPossible(User userNow) {
        boolean updated = false;

        if (!user.getHandle().equals(userNow.getHandle())) { updated = true; updateHandleLabels(); }
        if (!user.getEmail().equals(userNow.getEmail())) { updated = true; updateEmailLabels(); }
        if (!user.getVkId().equals(userNow.getVkId())) { updated = true; updateVkIDLabels(); }
        if (!user.getOpenId().equals(userNow.getOpenId())) { updated = true; updateOpenIDLabels(); }
        if (!user.getFirstName().equals(userNow.getFirstName())) { updated = true; updateFirstNameLabels(); }
        if (!user.getLastName().equals(userNow.getLastName())) { updated = true; updateLastNameLabels(); }
        if (!user.getCountry().equals(userNow.getCountry())) { updated = true; updateCountryLabels(); }
        if (!user.getCity().equals(userNow.getCity())) { updated = true; updateCityLabels(); }
        if (!user.getOrganization().equals(userNow.getOrganization())) { updated = true; updateOrganizationLabels(); }
        if (!user.getContribution().equals(userNow.getContribution())) { updated = true; updateContributionLabels(); }
        if (!user.getRank().equals(userNow.getRank())) { updated = true; updateRankLabels(); }
        if (!user.getMaxRank().equals(userNow.getMaxRank())) { updated = true; updateMaxRankLabels(); }
        if (!user.getRating().equals(userNow.getRating())) { updated = true; updateRatingLabels(); }
        if (!user.getMaxRating().equals(userNow.getMaxRating())) { updated = true; updateMaxRatingLabels(); }
        if (!user.getLastOnlineTimeSeconds().equals(userNow.getLastOnlineTimeSeconds())) { updated = true; updateLastVisitLabels(); }
        if (!user.getRegistrationTimeSeconds().equals(userNow.getRegistrationTimeSeconds())) { updated = true; updateRegisteredLabels(); }

        return true;
    }

    private void updateChangedLabels(Label labelBefore, Label labelNow) {
        labelBefore.setId("changedLabelBefore");
        labelNow.setId("changedLabelNow");
    }

    private void updateDefaultLabels(Label labelBefore, Label labelNow) {
        labelBefore.setId("defaultBeforeAndNowLabel");
        labelNow.setId("defaultBeforeAndNowLabel");
    }

    @FXML private void rememberChanges(ActionEvent event) {
        beforeHandleLabel.setText(nowHandleLabel.getText()); updateDefaultLabels(beforeHandleLabel, nowHandleLabel);
        beforeEmailLabel.setText(nowEmailLabel.getText()); updateDefaultLabels(beforeEmailLabel, nowEmailLabel);
        beforeVkIDLabel.setText(nowVkIDLabel.getText()); updateDefaultLabels(beforeVkIDLabel, nowVkIDLabel);
        beforeOpenIDLabel.setText(nowOpenIDLabel.getText()); updateDefaultLabels(beforeOpenIDLabel, nowOpenIDLabel);
        beforeFirstNameLabel.setText(nowFirstNameLabel.getText()); updateDefaultLabels(beforeFirstNameLabel, nowFirstNameLabel);
        beforeLastNameLabel.setText(nowLastNameLabel.getText()); updateDefaultLabels(beforeLastNameLabel, nowLastNameLabel);
        beforeCountryLabel.setText(nowCountryLabel.getText()); updateDefaultLabels(beforeCountryLabel, nowCountryLabel);
        beforeCityLabel.setText(nowCityLabel.getText()); updateDefaultLabels(beforeCityLabel, nowCityLabel);
        beforeOrganizationLabel.setText(nowOrganizationLabel.getText()); updateDefaultLabels(beforeOrganizationLabel, nowOrganizationLabel);
        beforeContributionLabel.setText(nowContributionLabel.getText()); updateDefaultLabels(beforeContributionLabel, nowContributionLabel);
        beforeRankLabel.setText(nowRankLabel.getText()); updateDefaultLabels(beforeRankLabel, nowRankLabel);
        beforeMaxRankLabel.setText(nowMaxRankLabel.getText()); updateDefaultLabels(beforeMaxRankLabel, nowMaxRankLabel);
        beforeRatingLabel.setText(nowRatingLabel.getText()); updateDefaultLabels(beforeRatingLabel, nowRatingLabel);
        beforeMaxRatingLabel.setText(nowMaxRatingLabel.getText()); updateDefaultLabels(beforeMaxRatingLabel, nowMaxRatingLabel);
        beforeLastVisitLabel.setText(nowLastVisitLabel.getText()); updateDefaultLabels(beforeLastVisitLabel, nowLastVisitLabel);
        beforeRegisteredLabel.setText(nowRegisteredLabel.getText()); updateDefaultLabels(beforeRegisteredLabel, nowRegisteredLabel);
    }
}
