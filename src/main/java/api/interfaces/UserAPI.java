package api.interfaces;

import api.annotations.GET;
import api.annotations.Query;
import base.CFResponse;
import base.RatingChange;
import base.Submission;
import base.User;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public interface UserAPI {
    @GET("user.info")
    CFResponse<List<User>> getInfo(
            @NotNull
            @Query("handles") String handles
    );

    @GET("user.ratedList")
    CFResponse<List<User>> getRatedList(
            @Query("activeOnly") Boolean activeOnly
    );

    @GET("user.rating")
    CFResponse<List<RatingChange>> getRating(
            @NotNull
            @Query("handle") String handle
    );

    @GET("user.status")
    CFResponse<List<Submission>> getStatus(
            @NotNull
            @Query("handle") String handle,
            @Query("from") Integer from,
            @Query("count") Integer count
    );
}
