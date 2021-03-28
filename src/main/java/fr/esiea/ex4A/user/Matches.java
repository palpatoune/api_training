package fr.esiea.ex4A.user;

public class Matches {
    private final String userName;
    private final String userTweeter;
    private final String userCountry;

    public String getUserCountry() {
        return userCountry;
    }


    public String getUserName() {
        return userName;
    }

    public String getUserTweeter() {
        return userTweeter;
    }

    public Matches(String userName, String userTweeter, String userCountry) {
        this.userName = userName;
        this.userTweeter = userTweeter;
        this.userCountry = userCountry;
    }

}

