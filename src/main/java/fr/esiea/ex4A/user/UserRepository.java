package fr.esiea.ex4A.user;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class UserRepository {
    final HashMap<String, User> userList = new HashMap<>();
    final HashMap<String, Matches> matchesList = new HashMap<>();
    final HashMap<String, UserAgify> userListWithAge = new HashMap<>();


    int getNumberOfUsers(){
        return this.userList.size();
    }

    void addNewUser(User user, UserAgify userWithAge){
        this.userList.put(user.getUserId(), user);
        this.matchesList.put(user.getUserId(), new Matches(user.userName, user.userTweeter));
        this.userListWithAge.put(user.getUserId(), userWithAge);
    }

    boolean userAlreadyExist(User user){
        return this.userList.containsKey(user.getUserId());
    }

    User getUser(String userName, String countryId){
        return this.userList.get(userName.concat(countryId));
    }

    ArrayList<Matches> matchUser(User userData){
        ArrayList<Matches> matchingUsers = new ArrayList<>();
        for(Map.Entry<String, UserAgify> userEntry : this.userListWithAge.entrySet()){
            if(Math.abs(userEntry.getValue().getAge() - this.userListWithAge.get(userData.getUserId()).getAge()) <= 5){
                User preferenceCheck = this.userList.get(userEntry.getValue().getUserId());
                if(preferenceCheck.getUserSex().equals(userData.getUserSexPref()) && userData.getUserSex().equals(preferenceCheck.getUserSexPref())) {
                    matchingUsers.add(this.matchesList.get(userEntry.getValue().getUserId()));
                }
            }
        }
        return matchingUsers;
    }

}
