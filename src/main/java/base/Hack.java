package base;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class Hack {
    private Integer id;
    private Integer creationTimeSeconds;
    private Party hacker;
    private Party defender;
    private Verdict verdict;
    private Problem problem;
    private String test;
    private JudgeProtocol judgeProtocol;

    public Integer getId() {
        return id;
    }

    public Integer getCreationTimeSeconds() {
        return creationTimeSeconds;
    }

    public Party getHacker() {
        return hacker;
    }

    public Party getDefender() {
        return defender;
    }

    public Verdict getVerdict() {
        return verdict;
    }

    public Problem getProblem() {
        return problem;
    }

    public String getTest() {
        return test;
    }

    public JudgeProtocol getJudgeProtocol() {
        return judgeProtocol;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (!(o instanceof Hack)) return false;

        Hack hack = (Hack) o;

        return new EqualsBuilder()
                .append(getId(), hack.getId())
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(getId())
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", id)
                .append("creationTimeSeconds", creationTimeSeconds)
                .append("hacker", hacker)
                .append("defender", defender)
                .append("verdict", verdict)
                .append("problem", problem)
                .append("test", test)
                .append("judgeProtocol", judgeProtocol)
                .toString();
    }

    public enum Verdict {
        HACK_SUCCESSFUL,
        HACK_UNSUCCESSFUL,
        INVALID_INPUT,
        GENERATOR_INCOMPILABLE,
        GENERATOR_CRASHED,
        IGNORED,
        TESTING,
        OTHER
    }
}
