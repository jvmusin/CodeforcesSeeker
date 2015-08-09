package base;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.List;

public class Problem {
    private Integer contestId;
    private String index;
    private String name;
    private Type type;
    private Double points;
    private List<String> tags;

    public Integer getContestId() {
        return contestId;
    }

    public String getIndex() {
        return index;
    }

    public String getName() {
        return name;
    }

    public Type getType() {
        return type;
    }

    public Double getPoints() {
        return points;
    }

    public List<String> getTags() {
        return tags;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (!(o instanceof Problem)) return false;

        Problem problem = (Problem) o;

        return new EqualsBuilder()
                .append(getContestId(), problem.getContestId())
                .append(getIndex(), problem.getIndex())
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
                .append("name", name)
                .append("type", type)
                .append("points", points)
                .append("tags", tags)
                .toString();
    }

    public enum Type {
        PROGRAMMING,
        QUESTION
    }
}
