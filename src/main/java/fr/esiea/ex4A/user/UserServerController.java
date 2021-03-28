package fr.esiea.ex4A.user;



import java.util.*;
import java.util.ArrayList;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import retrofit2.Call;


@RestController
public class UserServerController {

    final Matches match1 = new Matches("Bob","bobTweeter", "Fr");
    final Matches match2 = new Matches("aucun","aucunTweeter","Fr");

    @GetMapping("/api/matches")
    Matches match(@RequestParam(value = "name", defaultValue = "default", required = false)String userName,
                  @RequestParam(value = "country", defaultValue = "Eng", required = false)String userCountry){
        if (userName.equals(match1.getUserName())){ return match1; }
        return match2;
    }

    @PostMapping("/api/inscription")
    User newUser(@RequestBody User newUser){
        return newUser;
    }



}
