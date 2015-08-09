package api.interfaces;

import api.annotations.GET;
import api.annotations.Query;
import base.CFResponse;
import base.ProblemsetProblems;
import base.Submission;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public interface ProblemsetAPI {
    @GET("problemset.problems")
    CFResponse<ProblemsetProblems> getProblems(
            @Query("tags") String tags
    );

    @GET("problemset.recentStatus")
    CFResponse<List<Submission>> getRecentStatus(
            @NotNull
            @Query("count") Integer count
    );
}
