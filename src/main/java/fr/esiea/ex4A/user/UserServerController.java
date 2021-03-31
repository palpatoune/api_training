package fr.esiea.ex4A.user;



import java.io.IOException;
import java.util.*;
import java.util.ArrayList;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import retrofit2.Call;


@RestController
public class UserServerController {
    private final AgifyService agifyService;
    final Matches match1 = new Matches("Bob","bobTweeter");
    final Matches match2 = new Matches("aucun","aucunTweeter");

    public UserServerController(AgifyService agifyService) {
        this.agifyService = agifyService;
    }

    @GetMapping(path = "/api/matches", produces = MediaType.APPLICATION_JSON_VALUE)
    List<Matches> getMatch(@RequestParam(value = "userName", required = true)String userName,
                        @RequestParam(value = "userCountry", required = true)String userCountry){
        System.out.println(userName);
        final List<Matches> userList = this.agifyService.matchUser(userName, userCountry);
        return userList;
    }

    @PostMapping("/api/inscription")
    public void newUser(@RequestBody User newUser) throws IOException {
        this.agifyService.addUser(newUser);
    }



}
