package fr.esiea.ex4A.user;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

import java.util.List;

public interface AgifyService {
    @GET("users/")
    Call<List<User>> listUser(@Path("user") String user);

    @POST("users/new")
    Call<User> createUser(@Body User user);
}
