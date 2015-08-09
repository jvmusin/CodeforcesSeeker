package base;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class Contest {
    private Integer id;
    private String name;
    private Type type;
    private Phase phase;
    private Boolean frozen;
    private Integer durationSeconds;
    private Integer startTimeSeconds;
    private Integer relativeTimeSeconds;
    private String preparedBy;
    private String websiteUrl;
    private String description;
    private Integer difficulty;
    private String kind;
    private String icpcRegion;
    private String country;
    private String city;
    private String season;

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Type getType() {
        return type;
    }

    public Phase getPhase() {
        return phase;
    }

    public Boolean getFrozen() {
        return frozen;
    }

    public Integer getDurationSeconds() {
        return durationSeconds;
    }

    public Integer getStartTimeSeconds() {
        return startTimeSeconds;
    }

    public Integer getRelativeTimeSeconds() {
        return relativeTimeSeconds;
    }

    public String getPreparedBy() {
        return preparedBy;
    }

    public String getWebsiteUrl() {
        return websiteUrl;
    }

    public String getDescription() {
        return description;
    }

    public Integer getDifficulty() {
        return difficulty;
    }

    public String getKind() {
        return kind;
    }

    public String getIcpcRegion() {
        return icpcRegion;
    }

    public String getCountry() {
        return country;
    }

    public String getCity() {
        return city;
    }

    public String getSeason() {
        return season;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (!(o instanceof Contest)) return false;

        Contest contest = (Contest) o;

        return new EqualsBuilder()
                .append(getId(), contest.getId())
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
                .append("name", name)
                .append("type", type)
                .append("phase", phase)
                .append("frozen", frozen)
                .append("durationSeconds", durationSeconds)
                .append("startTimeSeconds", startTimeSeconds)
                .append("relativeTimeSeconds", relativeTimeSeconds)
                .append("preparedBy", preparedBy)
                .append("websiteUrl", websiteUrl)
                .append("description", description)
                .append("difficulty", difficulty)
                .append("kind", kind)
                .append("icpcRegion", icpcRegion)
                .append("country", country)
                .append("city", city)
                .append("season", season)
                .toString();
    }

    public enum Type {
        CF,
        IOI,
        ICPC
    }

    public enum Phase {
        BEFORE,
        CODING,
        PENDING_SYSTEM_TEST,
        SYSTEM_TEST,
        FINISHED
    }

}
