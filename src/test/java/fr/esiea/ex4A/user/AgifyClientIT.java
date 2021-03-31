package fr.esiea.ex4A.user;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

class AgifyClientIT {
    private final AgifyClient agifyClient;

    AgifyClientIT() {
        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://api.agify.io")
            .addConverterFactory(JacksonConverterFactory.create()).build();
        this.agifyClient = retrofit.create(AgifyClient.class);
    }

    @ParameterizedTest
    @CsvSource({
        "michael, US, 69",
        "josh, CA, 41",
        "franck, FR, 48",
        "ramon, ES, 65"
    })
    void getAgeFromNames(String userName, String userCountry, int expectedAge) {
        final Call<UserAgify> call = this.agifyClient.getUserAge(userName, userCountry);
        call.enqueue(new Callback<>() {
            @Override
            final public void onResponse(Call<UserAgify> call, Response<UserAgify> response) {
                if (response.isSuccessful() && response.body() != null) {
                    final UserAgify userAgify = response.body();
                    getAge(userAgify, expectedAge);
                }
            }

            @Override
            final public void onFailure(Call<UserAgify> call, Throwable throwable) {
                System.out.println("Error on API");
            }
        });
    }

    private void getAge(UserAgify userAgify, int expectedAge) {
        Assertions.assertThat(userAgify.getAge()).isEqualTo(expectedAge);
    }
}
