package base;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class ProblemResult {
    private Double points;
    private Integer penalty;
    private Integer rejectedAttemptCount;
    private Type type;
    private Integer bestSubmissionTimeSeconds;

    public Double getPoints() {
        return points;
    }

    public Integer getPenalty() {
        return penalty;
    }

    public Integer getRejectedAttemptCount() {
        return rejectedAttemptCount;
    }

    public Type getType() {
        return type;
    }

    public Integer getBestSubmissionTimeSeconds() {
        return bestSubmissionTimeSeconds;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (!(o instanceof ProblemResult)) return false;

        ProblemResult that = (ProblemResult) o;

        return new EqualsBuilder()
                .append(getPoints(), that.getPoints())
                .append(getPenalty(), that.getPenalty())
                .append(getRejectedAttemptCount(), that.getRejectedAttemptCount())
                .append(getType(), that.getType())
                .append(getBestSubmissionTimeSeconds(), that.getBestSubmissionTimeSeconds())
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(getPoints())
                .append(getPenalty())
                .append(getRejectedAttemptCount())
                .append(getType())
                .append(getBestSubmissionTimeSeconds())
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("points", points)
                .append("penalty", penalty)
                .append("rejectedAttemptCount", rejectedAttemptCount)
                .append("type", type)
                .append("bestSubmissionTimeSeconds", bestSubmissionTimeSeconds)
                .toString();
    }

    public enum Type {
        PRELIMINARY,
        FINAL;
    }
}
