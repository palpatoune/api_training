package fr.esiea.ex4A.user;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class AgifyService {

    public final AgifyClient agifyClient;
    public final UserRepository userRepository = new UserRepository();

    public AgifyService(AgifyClient agifyClient) {
        this.agifyClient = agifyClient;
    }

    public void addUser (User user) throws IOException {
        final UserAgify userAgify;
        if(!userRepository.userAlreadyExist(user)){
            userAgify = this.agifyClient.getUserAge(user.getUserName(), user.getUserCountry()).execute().body();
            userRepository.addNewUser(user, userAgify);
        }
    }

    public ArrayList<Matches> matchUser (String userName, String userCountry){
        final User userMatch = userRepository.getUser(userName, userCountry);
        if(userMatch != null){
            return userRepository.matchUser(userMatch);
        } else {
            return new ArrayList<>();
        }
    }


}
