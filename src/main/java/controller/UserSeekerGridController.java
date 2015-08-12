package controller;

import base.User;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import org.apache.commons.lang3.tuple.MutablePair;

import java.net.URL;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

public class UserSeekerGridController implements Initializable {
    @FXML private Pane fullUserSide;

//    @FXML private Label titleUserDataLabel;
//
//    @FXML private Label titleHandleLabel;
//    @FXML private Label titleEmailLabel;
//    @FXML private Label titleVkIDLabel;
//    @FXML private Label titleOpenIDLabel;
//    @FXML private Label titleFirstNameLabel;
//    @FXML private Label titleLastNameLabel;
//    @FXML private Label titleCountryLabel;
//    @FXML private Label titleCityLabel;
//    @FXML private Label titleOrganizationLabel;
//    @FXML private Label titleContributionLabel;
//    @FXML private Label titleRankLabel;
//    @FXML private Label titleMaxRankLabel;
//    @FXML private Label titleRatingLabel;
//    @FXML private Label titleMaxRatingLabel;
//    @FXML private Label titleLastVisitLabel;
//    @FXML private Label titleRegisteredLabel;

    @FXML private Label userHandleLabel;
    @FXML private Label userEmailLabel;
    @FXML private Label userVkIDLabel;
    @FXML private Label userOpenIDLabel;
    @FXML private Label userFirstNameLabel;
    @FXML private Label userLastNameLabel;
    @FXML private Label userCountryLabel;
    @FXML private Label userCityLabel;
    @FXML private Label userOrganizationLabel;
    @FXML private Label userContributionLabel;
    @FXML private HBox userRatingAndRankPane;
    @FXML private HBox userMaxRatingAndMaxRankPane;
    @FXML private Label userLastVisitLabel;
    @FXML private Label userRegisteredLabel;

    private User user;
    private Map<Label, MutablePair<String, String>> labelValues;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        labelValues = new HashMap<>();

        labelValues.put(userHandleLabel, new MutablePair<>());
        labelValues.put(userEmailLabel, new MutablePair<>());
        labelValues.put(userVkIDLabel, new MutablePair<>());
        labelValues.put(userOpenIDLabel, new MutablePair<>());
        labelValues.put(userFirstNameLabel, new MutablePair<>());
        labelValues.put(userLastNameLabel, new MutablePair<>());
        labelValues.put(userCountryLabel, new MutablePair<>());
        labelValues.put(userCityLabel, new MutablePair<>());
        labelValues.put(userOrganizationLabel, new MutablePair<>());
        labelValues.put(userContributionLabel, new MutablePair<>());
        labelValues.put(userLastVisitLabel, new MutablePair<>());
        labelValues.put(userRegisteredLabel, new MutablePair<>());
    }

    public void setUser(User user) {
        this.user = user;

        updateLabelValue(userHandleLabel, user.getHandle());
        updateLabelValue(userEmailLabel, user.getEmail());
        updateLabelValue(userVkIDLabel, user.getVkId());
        updateLabelValue(userOpenIDLabel, user.getOpenId());
        updateLabelValue(userFirstNameLabel, user.getFirstName());
        updateLabelValue(userLastNameLabel, user.getLastName());
        updateLabelValue(userCountryLabel, user.getCountry());
        updateLabelValue(userCityLabel, user.getCity());
        updateLabelValue(userOrganizationLabel, user.getOrganization());
        updateLabelValue(userContributionLabel, user.getContribution());
        updateLabelValue(userLastVisitLabel, user.getLastOnlineTimeSeconds());
        updateLabelValue(userRegisteredLabel, user.getRegistrationTimeSeconds());

        updateRatingAndRankValue(userRatingAndRankPane, user.getRating(), user.getRank());
        updateRatingAndRankValue(userMaxRatingAndMaxRankPane, user.getMaxRating(), user.getMaxRank());
    }

    public boolean tryUpdateUser(User userNow) {
        boolean updated = false;
        Object val;

        if (isValueChanged(user.getHandle(), val = userNow.getHandle())) { updated = true; updateHandleLabel(val); }
        if (isValueChanged(user.getEmail(), val = userNow.getEmail())) { updated = true; updateEmailLabel(val); }
        if (isValueChanged(user.getVkId(), val = userNow.getVkId())) { updated = true; updateVkIDLabel(val); }
        if (isValueChanged(user.getOpenId(), val = userNow.getOpenId())) { updated = true; updateOpenIDLabel(val); }
        if (isValueChanged(user.getFirstName(), val = userNow.getFirstName())) { updated = true; updateFirstNameLabel(val); }
        if (isValueChanged(user.getLastName(), val = userNow.getLastName())) { updated = true; updateLastNameLabel(val); }
        if (isValueChanged(user.getCountry(), val = userNow.getCountry())) { updated = true; updateCountryLabel(val); }
        if (isValueChanged(user.getCity(), val = userNow.getCity())) { updated = true; updateCityLabel(val); }
        if (isValueChanged(user.getOrganization(), val = userNow.getOrganization())) { updated = true; updateOrganizationLabel(val); }
        if (isValueChanged(user.getContribution(), val = userNow.getContribution())) { updated = true; updateContributionLabel(val); }
        if (isValueChanged(user.getLastOnlineTimeSeconds(), val = userNow.getLastOnlineTimeSeconds())) { updated = true; updateLastVisitLabel(val); }
        if (isValueChanged(user.getRegistrationTimeSeconds(), val = userNow.getRegistrationTimeSeconds())) { updated = true; updateRegisteredLabel(val); }

        Integer newRating;
        if (isValueChanged(user.getRating(), newRating = userNow.getRating())) {
            updated = true;
            updateRatingAndRankValue(userRatingAndRankPane, newRating, userNow.getRank());
        }
        if (isValueChanged(user.getMaxRating(), newRating = userNow.getMaxRating())) {
            updated = true;
            updateRatingAndRankValue(userMaxRatingAndMaxRankPane, newRating, userNow.getMaxRank());
        }

        if (updated) user.cloneFieldsFrom(userNow);
        return updated;
    }
    private boolean isValueChanged(Object o1, Object o2) {
        if (o1 == null && o2 == null) return false;
        else if (o1 == null || o2 == null) return true;
        else return !o1.equals(o2);
    }

    private void updateHandleLabel(Object newValue) { updateLabelValue(userHandleLabel, newValue); }
    private void updateEmailLabel(Object newValue) { updateLabelValue(userEmailLabel, newValue); }
    private void updateVkIDLabel(Object newValue) { updateLabelValue(userVkIDLabel, newValue); }
    private void updateOpenIDLabel(Object newValue) { updateLabelValue(userOpenIDLabel, newValue); }
    private void updateFirstNameLabel(Object newValue) { updateLabelValue(userFirstNameLabel, newValue); }
    private void updateLastNameLabel(Object newValue) { updateLabelValue(userLastNameLabel, newValue); }
    private void updateCountryLabel(Object newValue) { updateLabelValue(userCountryLabel, newValue); }
    private void updateCityLabel(Object newValue) { updateLabelValue(userCityLabel, newValue); }
    private void updateOrganizationLabel(Object newValue) { updateLabelValue(userOrganizationLabel, newValue); }
    private void updateContributionLabel(Object newValue) { updateLabelValue(userContributionLabel, newValue); }
    private void updateLastVisitLabel(Object newValue) { updateLabelValue(userLastVisitLabel, newValue); }
    private void updateRegisteredLabel(Object newValue) { updateLabelValue(userRegisteredLabel, newValue); }

    @FXML public void rememberChanges(ActionEvent event) {
        resetLabelToDefault(userHandleLabel);
        resetLabelToDefault(userEmailLabel);
        resetLabelToDefault(userVkIDLabel);
        resetLabelToDefault(userOpenIDLabel);
        resetLabelToDefault(userFirstNameLabel);
        resetLabelToDefault(userLastNameLabel);
        resetLabelToDefault(userCountryLabel);
        resetLabelToDefault(userCityLabel);
        resetLabelToDefault(userOrganizationLabel);
        resetLabelToDefault(userContributionLabel);
        resetPaneToDefault(userRatingAndRankPane);
        resetPaneToDefault(userMaxRatingAndMaxRankPane);
        resetLabelToDefault(userLastVisitLabel);
        resetLabelToDefault(userRegisteredLabel);
    }
    private void resetLabelToDefault(Label label) {
        MutablePair<String, String> values = labelValues.get(label);

        if (values.getRight() == null) return;

        values.setLeft(values.getRight());

        label.setText(values.getLeft());

        setUpdatedStyle(label, false);
    }
    private void resetPaneToDefault(Pane pane) {
        ObservableList<Node> children = pane.getChildren();

        if (children.size() != 5) return;

        Node ratingNow = children.get(3);
        Node rankNow = children.get(4);

        children.setAll(ratingNow, rankNow);

        setUpdatedStyle(pane, false);
    }

    @SuppressWarnings("all")
    private void updateRatingAndRankValue(Pane ratingAndRankPane, Integer newRating, String newRank) {
        String ratingStyle = getRatingStyle(newRating);

        ObservableList<Node> children = ratingAndRankPane.getChildren();
        Label t1;
        Label t2;

        if (children.size() == 5) {
            t1 = (Label) children.get(3);
            t2 = (Label) children.get(4);
            t1.setText(newRating.toString());
            t2.setText(newRank);
        } else {
            if (children.size() == 2) children.add(getDelimiter());
            t1 = new Label(newRating.toString());
            t2 = new Label(newRank);
            t1.setStyle("-fx-alignment: center-right");
            t2.setStyle("-fx-alignment: center-left");
            children.addAll(t1, t2);
        }

        t1.getStyleClass().add(ratingStyle);
        t2.getStyleClass().add(ratingStyle);

        if (children.size() == 5) {
            Label before = (Label) children.get(0);
            Label now = (Label) children.get(3);
            if (before.getText().equals(now.getText())) {
                resetPaneToDefault(ratingAndRankPane);
            } else {
                setUpdatedStyle(ratingAndRankPane, true);
            }
        }
    }
    private void updateLabelValue(Label label, Object newValue) {
        if (newValue == null) {
            newValue = "";
        } else if (label == userLastVisitLabel || label == userRegisteredLabel) {
            LocalDateTime ldt = LocalDateTime.ofEpochSecond((Integer) newValue, 0, OffsetDateTime.now().getOffset());
            newValue = ldt.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM, FormatStyle.MEDIUM));
        }

        MutablePair<String, String> values = labelValues.get(label);
        if (values.getLeft() == null) {
            values.setLeft(newValue.toString());
            label.setText(values.getLeft());
        } else {
            values.setRight(newValue.toString());
            if (values.getLeft().equals(values.getRight())) {
                resetLabelToDefault(label);
            } else {
                label.setText(values.getLeft() +  " \u2192 " + values.getRight());
                setUpdatedStyle(label, true);
            }
        }
    }
    private void setUpdatedStyle(Node node, boolean isUpdated) {
        ObservableList<String> styleClass = node.getStyleClass();
        String styleName = "user-data-updated-cell";

        if (isUpdated) styleClass.add(styleName);
        else styleClass.removeIf(s -> s.equals(styleName));
    }
    private Node getDelimiter() {
        Label label = new Label("=>");
        label.setTextFill(Color.WHITE);
        return label;
    }
    private String getRatingStyle(int rating) {
        if (rating >= 2600) return "rankInternationalGrandmaster";
        else if (rating >= 2200) return "rankGrandmaster";
        else if (rating >= 2050) return "rankInternationalMaster";
        else if (rating >= 1900) return "rankMaster";
        else if (rating >= 1700) return "rankCandidateMaster";
        else if (rating >= 1500) return "rankExpert";
        else if (rating >= 1350) return "rankSpecialist";
        else if (rating >= 1200) return "rankPupil";
        else if (rating >= 0) return "rankNewbie";
        else return "rankNobody";
    }

    public Pane getFullUserSide() {
        return fullUserSide;
    }
}
