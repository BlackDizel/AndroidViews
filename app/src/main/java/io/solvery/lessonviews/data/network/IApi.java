package io.solvery.lessonviews.data.network;

import io.solvery.lessonviews.model.SomeModel;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface IApi {

    @GET("somepath/")
    Call<SomeModel> getData(@Query("something") String something);

    @GET("tokenupdate/")
    Call<String> getToken();
}
