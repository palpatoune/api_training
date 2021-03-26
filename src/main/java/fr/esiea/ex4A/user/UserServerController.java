package fr.esiea.ex4A.user;



import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserServerController {

    @GetMapping("/api/matches")
    String match(@RequestParam(value = "userName", defaultValue = "Bobibob", required = false)String userName){
        return userName;
    }

    @PostMapping("/api/inscription")
    User newUser(@RequestBody User newUser){
        return newUser;
    }
}
