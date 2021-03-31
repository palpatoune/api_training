package fr.esiea.ex4A.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;


public class User {
    public final String userId;
    public final String userEmail;
    public final String userName;
    public final String userTweeter;
    public final String userCountry;
    public final String userSex;
    public final String userSexPref;

    public User(@JsonProperty("userEmail") String userEmail, @JsonProperty("userName") String userName, @JsonProperty("userTweeter") String userTweeter, @JsonProperty("userCountry") String userCountry, @JsonProperty("userSex") String userSex, @JsonProperty("userSexPref") String userSexPref) {
        this.userEmail = userEmail;
        this.userName = userName;
        this.userTweeter = userTweeter;
        this.userCountry = userCountry;
        this.userSex = userSex;
        this.userSexPref = userSexPref;
        this.userId = userName.concat(userCountry);
    }

    public User(String name, String tweeter) {
        this.userEmail = "";
        this.userName = name;
        this.userTweeter = tweeter;
        this.userCountry = "";
        this.userSex = "";
        this.userSexPref = "";
        this.userId = name.concat(userCountry);
    }

    public String getUserEmail() {
        return userEmail;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserTweeter() {
        return userTweeter;
    }

    public String getUserCountry() {
        return userCountry;
    }

    public String getUserSex() {
        return userSex;
    }
    public String getUserId(){
        return this.userId;
    }

    public String getUserSexPref() {
        return userSexPref;
    }




}
