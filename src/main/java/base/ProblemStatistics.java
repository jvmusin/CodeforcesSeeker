package base;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class ProblemStatistics {
    private Integer contestId;
    private String index;
    private Integer solvedCount;

    public Integer getContestId() {
        return contestId;
    }

    public String getIndex() {
        return index;
    }

    public Integer getSolvedCount() {
        return solvedCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (!(o instanceof ProblemStatistics)) return false;

        ProblemStatistics that = (ProblemStatistics) o;

        return new EqualsBuilder()
                .append(getContestId(), that.getContestId())
                .append(getIndex(), that.getIndex())
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(getContestId())
                .append(getIndex())
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("contestId", contestId)
                .append("index", index)
                .append("solvedCount", solvedCount)
                .toString();
    }

}
