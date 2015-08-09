package controller;

import base.User;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

import java.net.URL;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ResourceBundle;
import java.util.TimeZone;
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
    public void initialize(URL location, ResourceBundle resources) {}

    public void setUser(User user) {
        this.user = user;

        updateChangedLabels(beforeHandleLabel, nowHandleLabel, user.getHandle());
        updateChangedLabels(beforeEmailLabel, nowEmailLabel, user.getEmail());
        updateChangedLabels(beforeVkIDLabel, nowVkIDLabel, user.getVkId());
        updateChangedLabels(beforeOpenIDLabel, nowOpenIDLabel, user.getOpenId());
        updateChangedLabels(beforeFirstNameLabel, nowFirstNameLabel, user.getFirstName());
        updateChangedLabels(beforeLastNameLabel, nowLastNameLabel, user.getLastName());
        updateChangedLabels(beforeCountryLabel, nowCountryLabel, user.getCountry());
        updateChangedLabels(beforeCityLabel, nowCityLabel, user.getCity());
        updateChangedLabels(beforeOrganizationLabel, nowOrganizationLabel, user.getOrganization());
        updateChangedLabels(beforeContributionLabel, nowContributionLabel, user.getContribution());
        updateChangedLabels(beforeRankLabel, nowRankLabel, user.getRank());
        updateChangedLabels(beforeMaxRankLabel, nowMaxRankLabel, user.getMaxRank());
        updateChangedLabels(beforeRatingLabel, nowRatingLabel, user.getRating());
        updateChangedLabels(beforeMaxRatingLabel, nowMaxRatingLabel, user.getMaxRating());
        updateChangedLabels(beforeLastVisitLabel, nowLastVisitLabel, user.getLastOnlineTimeSeconds());
        updateChangedLabels(beforeRegisteredLabel, nowRegisteredLabel, user.getRegistrationTimeSeconds());

        rememberChanges(null);
    }

    private void updateHandleLabels(Object newValue) { updateChangedLabels(beforeHandleLabel, nowHandleLabel, newValue); }
    private void updateEmailLabels(Object newValue) { updateChangedLabels(beforeEmailLabel, nowEmailLabel, newValue); }
    private void updateVkIDLabels(Object newValue) { updateChangedLabels(beforeVkIDLabel, nowVkIDLabel, newValue); }
    private void updateOpenIDLabels(Object newValue) { updateChangedLabels(beforeOpenIDLabel, nowOpenIDLabel, newValue); }
    private void updateFirstNameLabels(Object newValue) { updateChangedLabels(beforeFirstNameLabel, nowFirstNameLabel, newValue); }
    private void updateLastNameLabels(Object newValue) { updateChangedLabels(beforeLastNameLabel, nowLastNameLabel, newValue); }
    private void updateCountryLabels(Object newValue) { updateChangedLabels(beforeCountryLabel, nowCountryLabel, newValue); }
    private void updateCityLabels(Object newValue) { updateChangedLabels(beforeCityLabel, nowCityLabel, newValue); }
    private void updateOrganizationLabels(Object newValue) { updateChangedLabels(beforeOrganizationLabel, nowOrganizationLabel, newValue); }
    private void updateContributionLabels(Object newValue) { updateChangedLabels(beforeContributionLabel, nowContributionLabel, newValue); }
    private void updateRankLabels(Object newValue) { updateChangedLabels(beforeRankLabel, nowRankLabel, newValue); }
    private void updateMaxRankLabels(Object newValue) { updateChangedLabels(beforeMaxRankLabel, nowMaxRankLabel, newValue); }
    private void updateRatingLabels(Object newValue) { updateChangedLabels(beforeRatingLabel, nowRatingLabel, newValue); }
    private void updateMaxRatingLabels(Object newValue) { updateChangedLabels(beforeMaxRatingLabel, nowMaxRatingLabel, newValue); }
    private void updateLastVisitLabels(Object newValue) { updateChangedLabels(beforeLastVisitLabel, nowLastVisitLabel, newValue); }
    private void updateRegisteredLabels(Object newValue) { updateChangedLabels(beforeRegisteredLabel, nowRegisteredLabel, newValue); }

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

    @FXML public void rememberChanges(ActionEvent event) {
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
        Paint newLabelColor = labelNow.getTextFill();
        labelBefore.setTextFill(newLabelColor);
        String defaultLabelStyle = "-fx-background-color: C4BA62";
        labelBefore.setStyle(defaultLabelStyle);
        labelNow.setStyle(defaultLabelStyle);
    }
    private void updateChangedLabels(Label labelBefore, Label labelNow, Object newValue) {
        labelBefore.setStyle("-fx-background-color: red;");
        labelNow.setStyle("-fx-background-color: lawngreen;");

        if (newValue == null) {
            labelNow.setText("");
            return;
        } else {
            labelNow.setText(newValue.toString());
        }

        if (labelNow == nowRatingLabel || labelNow == nowMaxRatingLabel) {
            int rating = Integer.parseInt(newValue.toString());
            Color ratingColor = getRatingColor(rating);

            if (labelNow == nowRatingLabel) {
                nowRatingLabel.setTextFill(ratingColor);
                nowRankLabel.setTextFill(ratingColor);
            } else {    //  labelNow == nowMaxRatingLabel
                nowMaxRatingLabel.setTextFill(ratingColor);
                nowMaxRankLabel.setTextFill(ratingColor);
            }

            return;
        }

        if (labelNow == nowLastVisitLabel || labelNow == nowRegisteredLabel) {
            Long time = Long.parseLong(newValue.toString());
            ZoneOffset offset = OffsetDateTime.now().getOffset();
            LocalDateTime ldt = LocalDateTime.ofEpochSecond(time, 0, offset);
            ZonedDateTime zdt = ZonedDateTime.of(ldt, ZoneId.systemDefault());
            String formattedTime = zdt.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.LONG, FormatStyle.MEDIUM));

            if (labelNow == nowLastVisitLabel) {
                nowLastVisitLabel.setText(formattedTime);
            } else {
                nowRegisteredLabel.setText(formattedTime);
            }
        }

        labelNow.setTextFill(Color.web("#313131"));
    }
    private Color getRatingColor(int rating) {
        if (rating >= 2600) return Color.web("#F00");
        else if (rating >= 2200) return Color.web("#F00");
        else if (rating >= 2050) return Color.web("#FF8C00");
        else if (rating >= 1900) return Color.web("#FF8C00");
        else if (rating >= 1700) return Color.web("#A0A");
        else if (rating >= 1500) return Color.web("#00F");
        else if (rating >= 1350) return Color.web("#008000");
        else if (rating >= 1200) return Color.web("#008000");
        else if (rating >= 0) return Color.web("#008000");
        else return Color.web("#FFFFFF");
    }

    public Pane getFullUserPane() {
        return fullUserPane;
    }
}
