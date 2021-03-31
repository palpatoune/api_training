package fr.esiea.ex4A.user;

import retrofit2.Call;
import retrofit2.http.*;

import java.security.PublicKey;
import java.util.List;
import java.util.concurrent.Executor;

public interface AgifyClient {
    @GET("/")
    Call<UserAgify> getUserAge(@Query("name") String userName, @Query("country_id") String userCountry);
}
