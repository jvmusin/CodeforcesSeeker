package base;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class JudgeProtocol {
    private Boolean manual;
    private String protocol;
    private String verdict;

    public Boolean getManual() {
        return manual;
    }

    public String getProtocol() {
        return protocol;
    }

    public String getVerdict() {
        return verdict;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (!(o instanceof JudgeProtocol)) return false;

        JudgeProtocol that = (JudgeProtocol) o;

        return new EqualsBuilder()
                .append(getManual(), that.getManual())
                .append(getProtocol(), that.getProtocol())
                .append(getVerdict(), that.getVerdict())
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(getManual())
                .append(getProtocol())
                .append(getVerdict())
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("manual", manual)
                .append("protocol", protocol)
                .append("verdict", verdict)
                .toString();
    }

}
