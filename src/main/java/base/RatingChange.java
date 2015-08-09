package base;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class RatingChange {
    private Integer contestId;
    private String contestName;
    private Integer rank;
    private Integer ratingUpdateTimeSeconds;
    private Integer oldRating;
    private Integer newRating;

    public Integer getContestId() {
        return contestId;
    }

    public String getContestName() {
        return contestName;
    }

    public Integer getRank() {
        return rank;
    }

    public Integer getRatingUpdateTimeSeconds() {
        return ratingUpdateTimeSeconds;
    }

    public Integer getOldRating() {
        return oldRating;
    }

    public Integer getNewRating() {
        return newRating;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("contestId", contestId)
                .append("contestName", contestName)
                .append("rank", rank)
                .append("ratingUpdateTimeSeconds", ratingUpdateTimeSeconds)
                .append("oldRating", oldRating)
                .append("newRating", newRating)
                .toString();
    }

}
