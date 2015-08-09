package base;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class Submission {
    private Integer id;
    private Integer contestId;
    private Integer creationTimeSeconds;
    private Integer relativeTimeSeconds;
    private Problem problem;
    private Party author;
    private String programmingLanguage;
    private Verdict verdict;
    private Testset testset;
    private Integer passedTestCount;
    private Integer timeConsumedMillis;
    private Integer memoryConsumedBytes;

    public Integer getId() {
        return id;
    }

    public Integer getContestId() {
        return contestId;
    }

    public Integer getCreationTimeSeconds() {
        return creationTimeSeconds;
    }

    public Integer getRelativeTimeSeconds() {
        return relativeTimeSeconds;
    }

    public Problem getProblem() {
        return problem;
    }

    public Party getAuthor() {
        return author;
    }

    public String getProgrammingLanguage() {
        return programmingLanguage;
    }

    public Verdict getVerdict() {
        return verdict;
    }

    public Testset getTestset() {
        return testset;
    }

    public Integer getPassedTestCount() {
        return passedTestCount;
    }

    public Integer getTimeConsumedMillis() {
        return timeConsumedMillis;
    }

    public Integer getMemoryConsumedBytes() {
        return memoryConsumedBytes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (!(o instanceof Submission)) return false;

        Submission that = (Submission) o;

        return new EqualsBuilder()
                .append(getId(), that.getId())
                .append(getContestId(), that.getContestId())
                .append(getCreationTimeSeconds(), that.getCreationTimeSeconds())
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(getId())
                .append(getContestId())
                .append(getCreationTimeSeconds())
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", id)
                .append("contestId", contestId)
                .append("creationTimeSeconds", creationTimeSeconds)
                .append("relativeTimeSeconds", relativeTimeSeconds)
                .append("problem", problem)
                .append("author", author)
                .append("programmingLanguage", programmingLanguage)
                .append("verdict", verdict)
                .append("testset", testset)
                .append("passedTestCount", passedTestCount)
                .append("timeConsumedMillis", timeConsumedMillis)
                .append("memoryConsumedBytes", memoryConsumedBytes)
                .toString();
    }

    public enum Verdict {
        FAILED,
        OK,
        PARTIAL,
        COMPILATION_ERROR,
        RUNTIME_ERROR,
        WRONG_ANSWER,
        PRESENTATION_ERROR,
        TIME_LIMIT_EXCEEDED,
        MEMORY_LIMIT_EXCEEDED,
        IDLENESS_LIMIT_EXCEEDED,
        SECURITY_VIOLATED,
        CRASHED,
        INPUT_PREPARATION_CRASHED,
        CHALLENGED,
        SKIPPED,
        TESTING,
        REJECTED
    }

    public enum Testset {
        SAMPLES,
        PRETESTS,
        TESTS,
        CHALLENGES,
        TESTS1,
        TESTS2,
        TESTS3,
        TESTS4,
        TESTS5,
        TESTS6,
        TESTS7,
        TESTS8,
        TESTS9,
        TESTS10
    }
}
