package base;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.List;

public class ContestStandings {
    private Contest contest;
    private List<Problem> problems;
    private List<RanklistRow> rows;

    public Contest getContest() {
        return contest;
    }

    public List<Problem> getProblems() {
        return problems;
    }

    public List<RanklistRow> getRows() {
        return rows;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (!(o instanceof ContestStandings)) return false;

        ContestStandings that = (ContestStandings) o;

        return new EqualsBuilder()
                .append(getContest(), that.getContest())
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(getContest())
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("contest", contest)
                .append("problems", problems)
                .append("rows", rows)
                .toString();
    }

}
