package base;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.List;

public class ProblemsetProblems {
    private List<Problem> problems;
    private List<ProblemStatistics> problemStatistics;

    public List<Problem> getProblems() {
        return problems;
    }

    public List<ProblemStatistics> getProblemStatistics() {
        return problemStatistics;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("problems", problems)
                .append("problemStatistics", problemStatistics)
                .toString();
    }

}
