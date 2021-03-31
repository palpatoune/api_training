package fr.esiea.ex4A.user;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserAgifyTest {

    @Test
    void getName() {
        String Name = "Bernard";
        UserAgify userAgify = new UserAgify("Bernard",45,4,"Fr");
        Name.equals(userAgify.name);
    }

    @Test
    void getAge() {
        int Age = 45;
        UserAgify userAgify = new UserAgify("Bernard",45,4,"Fr");
        if (Age == userAgify.age){

        }

    }

    @Test
    void getCount() {
        int Count = 4;
        UserAgify userAgify = new UserAgify("Bernard",45,4,"Fr");
        if (Count == userAgify.count){

        }
    }

    @Test
    void getCountry_id() {
        String Country = "Bernard";
        UserAgify userAgify = new UserAgify("Bernard",45,4,"Fr");
        Country.equals(userAgify.country_id);
    }

    @Test
    void getUserId() {
    }
}
