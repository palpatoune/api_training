package fr.esiea.ex4A.user;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.json.GsonTester;
import org.springframework.http.codec.json.Jackson2JsonDecoder;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

import java.util.List;



public class AgifyServiceIT {
  /*  @Test
    public void getUser () {
        Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://api.agify.io/")
            .addConverterFactory(JacksonConverterFactory.create())
            .build();

        AgifyClient agifyClient = retrofit.create(AgifyClient.class);
        Call <UserAgify> call = agifyClient.userList("michael");
        call.enqueue(new Callback<UserAgify>() {
            @Override
            public void onResponse(Call<UserAgify> call, Response<UserAgify> response) {
                if (!response.isSuccessful()){
                    System.out.println("code d'erreur : " + response.code());
                    return;
                }

                UserAgify userTest = response.body();
                System.out.println(userTest);
            }

            @Override
            public void onFailure(Call<UserAgify> call, Throwable throwable) {
                System.out.println("Bug");
            }
        });

    }*/
}
