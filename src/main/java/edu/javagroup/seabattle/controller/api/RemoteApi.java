package edu.javagroup.seabattle.controller.api;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

import static edu.javagroup.seabattle.controller.PathConstants.*;

public interface RemoteApi {

    @GET(API_PATH + LAN_TEST)
    Call<Boolean> lanTest();

    @GET(API_PATH + IM_READY)
    Call<Boolean> areYouReady();

    @POST(API_PATH + SET_BOMB)
    Call<Boolean> sendBomb(@Query("row") int row, @Query("col") int col);
}
