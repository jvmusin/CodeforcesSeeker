package base;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class User {
    private String handle;
    private String email;
    private String vkId;
    private String openId;
    private String firstName;
    private String lastName;
    private String country;
    private String city;
    private String organization;
    private Integer contribution;
    private String rank;
    private String maxRank;
    private Integer rating;
    private Integer maxRating;
    private Integer lastOnlineTimeSeconds;
    private Integer registrationTimeSeconds;

    public User() {}
    public User(String handle) {
        this.handle = handle;
    }

    public String getHandle() {
        return handle;
    }
    public String getEmail() {
        return email;
    }
    public String getVkId() {
        return vkId;
    }
    public String getOpenId() {
        return openId;
    }
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public String getCountry() {
        return country;
    }
    public String getCity() {
        return city;
    }
    public String getOrganization() {
        return organization;
    }
    public Integer getContribution() {
        return contribution;
    }
    public String getRank() {
        return rank;
    }
    public String getMaxRank() {
        return maxRank;
    }
    public Integer getRating() {
        return rating;
    }
    public Integer getMaxRating() {
        return maxRating;
    }
    public Integer getLastOnlineTimeSeconds() {
        return lastOnlineTimeSeconds;
    }
    public Integer getRegistrationTimeSeconds() {
        return registrationTimeSeconds;
    }

    public void cloneFieldsFrom(User anotherUser) {
        this.handle = anotherUser.handle;
        this.email = anotherUser.email;
        this.vkId = anotherUser.vkId;
        this.openId = anotherUser.openId;
        this.firstName = anotherUser.firstName;
        this.lastName = anotherUser.lastName;
        this.country = anotherUser.country;
        this.city = anotherUser.city;
        this.organization = anotherUser.organization;
        this.contribution = anotherUser.contribution;
        this.rank = anotherUser.rank;
        this.maxRank = anotherUser.maxRank;
        this.rating = anotherUser.rating;
        this.maxRating = anotherUser.maxRating;
        this.lastOnlineTimeSeconds = anotherUser.lastOnlineTimeSeconds;
        this.registrationTimeSeconds = anotherUser.registrationTimeSeconds;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (!(o instanceof User)) return false;

        User user = (User) o;

        return getHandle().equals(user.getHandle());
    }

    @Override
    public int hashCode() {
        return getHandle().hashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("handle", handle)
                .append("email", email)
                .append("vkId", vkId)
                .append("openId", openId)
                .append("firstName", firstName)
                .append("lastName", lastName)
                .append("country", country)
                .append("city", city)
                .append("organization", organization)
                .append("contribution", contribution)
                .append("rank", rank)
                .append("maxRank", maxRank)
                .append("rating", rating)
                .append("maxRating", maxRating)
                .append("lastOnlineTimeSeconds", lastOnlineTimeSeconds)
                .append("registrationTimeSeconds", registrationTimeSeconds)
                .toString();
    }
}
