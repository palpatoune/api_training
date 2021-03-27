package fr.esiea.ex4A.user;



import java.util.*;
import java.util.ArrayList;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;



@RestController
public class UserServerController {

    Matches match1 = new Matches("Bob","bobTweeter", "Fr");
    Matches match2 = new Matches("rick","rickTweeter","Fr");
    Matches match3 = new Matches("aucun","aucunTweeter","Fr");



    @GetMapping("/api/matches")
    Matches match(@RequestParam(value = "name", defaultValue = "default", required = false)String userName,
                  @RequestParam(value = "country", defaultValue = "Eng", required = false)String userCountry){
        System.out.println(userName);
        System.out.println(match1.getUserName());
        if (userName.equals(match1.getUserName())){
             return match1;
        }
        if (userName.equals(match2.getUserName())){
             return match2;
        }
        return match3;

    }

    @PostMapping("/api/inscription")
    User newUser(@RequestBody User newUser){
        return newUser;
    }
}
