package fr.esiea.ex4A.user;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserAgifyTest {

    @Test
    void getName() {
        final String Name = "Bernard";
        final UserAgify userAgify = new UserAgify("Bernard",45,4,"Fr");
        Name.equals(userAgify.name);
    }

    @Test
    void getAge() {
        final int Age = 45;
        final UserAgify userAgify = new UserAgify("Bernard",45,4,"Fr");
        if (Age == userAgify.age){

        }

    }

    @Test
    void getCount() {
        final int Count = 4;
        final UserAgify userAgify = new UserAgify("Bernard",45,4,"Fr");
        if (Count == userAgify.count){

        }
    }

    @Test
    void getCountry_id() {
        final String Country = "Bernard";
        final UserAgify userAgify = new UserAgify("Bernard",45,4,"Fr");
        Country.equals(userAgify.country_id);
    }

    @Test
    void getUserId() {
    }
}
