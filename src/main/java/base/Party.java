package base;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.List;

public class Party {
    private Integer contestId;
    private List<Member> members;
    private ParticipantType participantType;
    private Integer teamId;
    private String teamName;
    private Boolean ghost;
    private Integer room;
    private Integer startTimeSeconds;

    public Integer getContestId() {
        return contestId;
    }

    public List<Member> getMembers() {
        return members;
    }

    public ParticipantType getParticipantType() {
        return participantType;
    }

    public Integer getTeamId() {
        return teamId;
    }

    public String getTeamName() {
        return teamName;
    }

    public Boolean isGhost() {
        return ghost;
    }

    public Integer getRoom() {
        return room;
    }

    public Integer getStartTimeSeconds() {
        return startTimeSeconds;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (!(o instanceof Party)) return false;

        Party party = (Party) o;

        return new EqualsBuilder()
                .append(getContestId(), party.getContestId())
                .append(getMembers(), party.getMembers())
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(getContestId())
                .append(getMembers())
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("contestId", contestId)
                .append("members", members)
                .append("participantType", participantType)
                .append("teamId", teamId)
                .append("teamName", teamName)
                .append("ghost", ghost)
                .append("room", room)
                .append("startTimeSeconds", startTimeSeconds)
                .toString();
    }

    public enum ParticipantType {
        CONTESTANT,
        PRACTICE,
        VIRTUAL,
        MANAGER,
        OUT_OF_COMPETITION
    }
}
