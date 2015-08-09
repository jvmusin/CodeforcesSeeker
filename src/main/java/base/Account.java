package base;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class Account {
    private String userName = "NoName";
    private String apiKey;
    private String secret;
    private String language = "en";

    private static Account account = new Account();

    public static Account getInstance() {
        return account;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = "ru".equals(language) ? "ru" : "en";
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("userName", userName)
                .append("apiKey", apiKey)
                .append("secret", secret)
                .append("language", language)
                .toString();
    }
}
