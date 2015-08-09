package base;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.List;

public class RanklistRow {
    private Party party;
    private Integer rank;
    private Double points;
    private Integer penalty;
    private Integer successfulHackCount;
    private Integer unsuccessfulHackCount;
    private List<ProblemResult> problemResults;
    private Integer lastSubmissionTimeSeconds;

    public Party getParty() {
        return party;
    }

    public Integer getRank() {
        return rank;
    }

    public Double getPoints() {
        return points;
    }

    public Integer getPenalty() {
        return penalty;
    }

    public Integer getSuccessfulHackCount() {
        return successfulHackCount;
    }

    public Integer getUnsuccessfulHackCount() {
        return unsuccessfulHackCount;
    }

    public List<ProblemResult> getProblemResults() {
        return problemResults;
    }

    public Integer getLastSubmissionTimeSeconds() {
        return lastSubmissionTimeSeconds;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (!(o instanceof RanklistRow)) return false;

        RanklistRow that = (RanklistRow) o;

        return new EqualsBuilder()
                .append(getParty(), that.getParty())
                .append(getRank(), that.getRank())
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(getParty())
                .append(getRank())
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("party", party)
                .append("rank", rank)
                .append("points", points)
                .append("penalty", penalty)
                .append("successfulHackCount", successfulHackCount)
                .append("unsuccessfulHackCount", unsuccessfulHackCount)
                .append("problemResults", problemResults)
                .append("lastSubmissionTimeSeconds", lastSubmissionTimeSeconds)
                .toString();
    }

}
