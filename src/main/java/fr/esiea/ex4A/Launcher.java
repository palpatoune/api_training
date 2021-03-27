package fr.esiea.ex4A;

import fr.esiea.ex4A.user.AgifyService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import retrofit2.Retrofit;

@SpringBootApplication
public class Launcher {
    @Bean
    AgifyService agifyService() {
        Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://api.github.com/")
            .build();

        return retrofit.create(AgifyService.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(Launcher.class, args);
    }
}


