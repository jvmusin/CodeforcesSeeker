package base;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class CFResponse<T> {
    private Status status;
    private ExtendedStatus extendedStatus;
    private String comment;
    private T result;

    private CFResponse() {}

    public static CFResponse getFailedCFResponse(String comment, ExtendedStatus extendedStatus) {
        CFResponse response = new CFResponse();
        response.status = Status.FAILED;
        response.extendedStatus = extendedStatus;
        response.comment = comment;
        return response;
    }

    public Status getStatus() {
        return status;
    }
    public ExtendedStatus getExtendedStatus() {
        return extendedStatus;
    }
    public String getComment() {
        return comment;
    }
    public T getResult() {
        return result;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("status", status)
                .append("comment", comment)
                .append("result", result)
                .toString();
    }

    public enum Status {
        OK,
        FAILED
    }

    public enum ExtendedStatus {
        USER_NOT_FOUND,
        SERVER_ERROR
    }
}
