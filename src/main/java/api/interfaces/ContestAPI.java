package api.interfaces;

import api.annotations.GET;
import api.annotations.Query;
import base.*;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public interface ContestAPI {
    @GET("contest.hacks")
    CFResponse<List<Hack>> getHacks(
            @NotNull
            @Query("contestId") Integer contestId
    );

    @GET("contest.list")
    CFResponse<List<Contest>> getList(
            @Query("gym") Boolean gym
    );

    @GET("contest.standings")
    CFResponse<ContestStandings> getStandings(
            @NotNull
            @Query("contestId") Integer contestId,
            @Query("from") Integer from,
            @Query("count") Integer count,
            @Query("handles") String handles,
            @Query("room") Integer room,
            @Query("showUnofficial") Boolean showUnofficial
    );

    @GET("contest.status")
    CFResponse<List<Submission>> getStatus(
            @NotNull
            @Query("contestId") Integer contestId,
            @Query("handle") String handle,
            @Query("from") Integer from,
            @Query("count") Integer count
    );
}
