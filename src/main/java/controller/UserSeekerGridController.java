package controller;

import base.User;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class UserSeekerGridController implements Initializable {
    @FXML private Pane fullUserPane;

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

        setLabelText(beforeHandleLabel, user.getHandle());
        setLabelText(beforeEmailLabel, user.getEmail());
        setLabelText(beforeVkIDLabel, user.getVkId());
        setLabelText(beforeOpenIDLabel, user.getOpenId());
        setLabelText(beforeFirstNameLabel, user.getFirstName());
        setLabelText(beforeLastNameLabel, user.getLastName());
        setLabelText(beforeCountryLabel, user.getCountry());
        setLabelText(beforeCityLabel, user.getCity());
        setLabelText(beforeOrganizationLabel, user.getOrganization());
        setLabelText(beforeContributionLabel, user.getContribution());
        setLabelText(beforeRankLabel, user.getRank());
        setLabelText(beforeMaxRankLabel, user.getMaxRank());
        setLabelText(beforeRatingLabel, user.getRating());
        setLabelText(beforeMaxRatingLabel, user.getMaxRating());
        setLabelText(beforeLastVisitLabel, user.getLastOnlineTimeSeconds());
        setLabelText(beforeRegisteredLabel, user.getRegistrationTimeSeconds());

        setLabelText(nowHandleLabel, user.getHandle());
        setLabelText(nowEmailLabel, user.getEmail());
        setLabelText(nowVkIDLabel, user.getVkId());
        setLabelText(nowOpenIDLabel, user.getOpenId());
        setLabelText(nowFirstNameLabel, user.getFirstName());
        setLabelText(nowLastNameLabel, user.getLastName());
        setLabelText(nowCountryLabel, user.getCountry());
        setLabelText(nowCityLabel, user.getCity());
        setLabelText(nowOrganizationLabel, user.getOrganization());
        setLabelText(nowContributionLabel, user.getContribution());
        setLabelText(nowRankLabel, user.getRank());
        setLabelText(nowMaxRankLabel, user.getMaxRank());
        setLabelText(nowRatingLabel, user.getRating());
        setLabelText(nowMaxRatingLabel, user.getMaxRating());
        setLabelText(nowLastVisitLabel, user.getLastOnlineTimeSeconds());
        setLabelText(nowRegisteredLabel, user.getRegistrationTimeSeconds());
    }
    private void setLabelText(Label label, Object value) {
        label.setText(value == null ? "" : value.toString());
    }

    public void updateHandleLabels(Object newValue) { updateChangedLabels(beforeHandleLabel, nowHandleLabel, newValue); }
    public void updateEmailLabels(Object newValue) { updateChangedLabels(beforeEmailLabel, nowEmailLabel, newValue); }
    public void updateVkIDLabels(Object newValue) { updateChangedLabels(beforeVkIDLabel, nowVkIDLabel, newValue); }
    public void updateOpenIDLabels(Object newValue) { updateChangedLabels(beforeOpenIDLabel, nowOpenIDLabel, newValue); }
    public void updateFirstNameLabels(Object newValue) { updateChangedLabels(beforeFirstNameLabel, nowFirstNameLabel, newValue); }
    public void updateLastNameLabels(Object newValue) { updateChangedLabels(beforeLastNameLabel, nowLastNameLabel, newValue); }
    public void updateCountryLabels(Object newValue) { updateChangedLabels(beforeCountryLabel, nowCountryLabel, newValue); }
    public void updateCityLabels(Object newValue) { updateChangedLabels(beforeCityLabel, nowCityLabel, newValue); }
    public void updateOrganizationLabels(Object newValue) { updateChangedLabels(beforeOrganizationLabel, nowOrganizationLabel, newValue); }
    public void updateContributionLabels(Object newValue) { updateChangedLabels(beforeContributionLabel, nowContributionLabel, newValue); }
    public void updateRankLabels(Object newValue) { updateChangedLabels(beforeRankLabel, nowRankLabel, newValue); }
    public void updateMaxRankLabels(Object newValue) { updateChangedLabels(beforeMaxRankLabel, nowMaxRankLabel, newValue); }
    public void updateRatingLabels(Object newValue) { updateChangedLabels(beforeRatingLabel, nowRatingLabel, newValue); }
    public void updateMaxRatingLabels(Object newValue) { updateChangedLabels(beforeMaxRatingLabel, nowMaxRatingLabel, newValue); }
    public void updateLastVisitLabels(Object newValue) { updateChangedLabels(beforeLastVisitLabel, nowLastVisitLabel, newValue); }
    public void updateRegisteredLabels(Object newValue) { updateChangedLabels(beforeRegisteredLabel, nowRegisteredLabel, newValue); }

    public boolean updateUserIfPossible(User userNow) {
        boolean updated = false;
        Object val;

        if (isValueChanged(user.getHandle(), val = userNow.getHandle())) { updated = true; updateHandleLabels(val); }
        if (isValueChanged(user.getEmail(), val = userNow.getEmail())) { updated = true; updateEmailLabels(val); }
        if (isValueChanged(user.getVkId(), val = userNow.getVkId())) { updated = true; updateVkIDLabels(val); }
        if (isValueChanged(user.getOpenId(), val = userNow.getOpenId())) { updated = true; updateOpenIDLabels(val); }
        if (isValueChanged(user.getFirstName(), val = userNow.getFirstName())) { updated = true; updateFirstNameLabels(val); }
        if (isValueChanged(user.getLastName(), val = userNow.getLastName())) { updated = true; updateLastNameLabels(val); }
        if (isValueChanged(user.getCountry(), val = userNow.getCountry())) { updated = true; updateCountryLabels(val); }
        if (isValueChanged(user.getCity(), val = userNow.getCity())) { updated = true; updateCityLabels(val); }
        if (isValueChanged(user.getOrganization(), val = userNow.getOrganization())) { updated = true; updateOrganizationLabels(val); }
        if (isValueChanged(user.getContribution(), val = userNow.getContribution())) { updated = true; updateContributionLabels(val); }
        if (isValueChanged(user.getRank(), val = userNow.getRank())) { updated = true; updateRankLabels(val); }
        if (isValueChanged(user.getMaxRank(), val = userNow.getMaxRank())) { updated = true; updateMaxRankLabels(val); }
        if (isValueChanged(user.getRating(), val = userNow.getRating())) { updated = true; updateRatingLabels(val); }
        if (isValueChanged(user.getMaxRating(), val = userNow.getMaxRating())) { updated = true; updateMaxRatingLabels(val); }
        if (isValueChanged(user.getLastOnlineTimeSeconds(), val = userNow.getLastOnlineTimeSeconds())) { updated = true; updateLastVisitLabels(val); }
        if (isValueChanged(user.getRegistrationTimeSeconds(), val = userNow.getRegistrationTimeSeconds())) { updated = true; updateRegisteredLabels(val); }

        if (updated) user.cloneFieldsFrom(userNow);
        return updated;
    }
    private boolean isValueChanged(Object o1, Object o2) {
        if (o1 == null && o2 == null) return false;
        else if (o1 == null || o2 == null) return true;
        else return !o1.equals(o2);
    }

    private void updateChangedLabels(Label labelBefore, Label labelNow, Object newValue) {
        //  Some work with type of labels like next line
        Platform.runLater(() -> labelNow.setText(newValue == null ? "" : newValue.toString()));

        labelBefore.setId("changedLabelBefore");
        labelNow.setId("changedLabelNow");
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
    private void updateDefaultLabels(Label labelBefore, Label labelNow) {
        labelBefore.setId("defaultBeforeAndNowLabel");
        labelNow.setId("defaultBeforeAndNowLabel");
    }

    public Pane getFullUserPane() {
        return fullUserPane;
    }
}
