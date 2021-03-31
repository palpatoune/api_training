package fr.esiea.ex4A.user;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

import java.io.IOException;

class AgifyServiceTest {



    AgifyClient agifyClient() {
        final Retrofit retrofit = new Retrofit.Builder().baseUrl("https://api.agify.io/").addConverterFactory(JacksonConverterFactory.create()).build();
        return retrofit.create(AgifyClient.class);
    }

    final AgifyClient mockAgifyClient = agifyClient();

    final AgifyService agifyService = new AgifyService(mockAgifyClient);

    @Test
    void adding_a_user_should_increment_the_number_of_users() throws IOException {
        final User userData = new User("marlon@mail.com", "Marlon", "marlon14", "US", "M", "F");
        agifyService.addUser(userData);
        Assertions.assertThat(agifyService.userRepository.userList.get("MarlonUS")).isEqualTo(userData);
        Assertions.assertThat(agifyService.userRepository.getNumberOfUsers()).isEqualTo(1);
    }

    @Test
    void adding_multiple_users_should_increment_the_number_of_users() throws IOException, IOException {
        final User userData1 = new User("henri@mail.fr", "Henri", "bHenri", "FR", "M", "M");
        final User userData2 = new User("juan@movistar.es", "Juan", "juanjuan", "ES", "M", "F");
        final User userData3 = new User("elena@mail.ru", "Elena", "elenaaa", "RU", "F", "F");
        final User userData4 = new User("marlon@mail.com", "Marlon", "marlon14", "US", "M", "F");
        agifyService.addUser(userData1);
        agifyService.addUser(userData2);
        agifyService.addUser(userData3);
        agifyService.addUser(userData4);
        Assertions.assertThat(agifyService.userRepository.userList.get("HenriFR")).isEqualTo(userData1);
        Assertions.assertThat(agifyService.userRepository.userList.get("JuanES")).isEqualTo(userData2);
        Assertions.assertThat(agifyService.userRepository.userList.get("ElenaRU")).isEqualTo(userData3);
        Assertions.assertThat(agifyService.userRepository.userList.get("MarlonUS")).isEqualTo(userData4);
        Assertions.assertThat(agifyService.userRepository.getNumberOfUsers()).isEqualTo(4);
    }

    @Test
    void addUser() {
    }

    @Test
    void matchUser() {
    }
}
