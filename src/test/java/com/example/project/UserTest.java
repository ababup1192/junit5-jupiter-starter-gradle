package com.example.project;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @Test
    @DisplayName("UserのFirstNameが取れる")
    void getFirstName() {
        User user = new User("firstName", "lastName");
        assertEquals("firstName", user.getFirstName(), "User's first name should equal firstName");
    }

    @Test
    @DisplayName("UserのLastNameが取れる")
    void getLastName() {
        User user = new User("firstName", "lastName");
        assertEquals("lastName", user.getLastName(), "User's last name should equal lastName");
    }

    @Test
    @DisplayName("UserのFirstNameとLastNameが取れる")
    void getFirstAndLastName() {
        User user = new User("firstName", "lastName");

        assertAll("user",
                () -> assertEquals("firstName", user.getFirstName()),
                () -> assertEquals("lastName", user.getLastName())
        );
    }

    @Test
    @DisplayName("同じFirstNameとLastNameを持つユーザは等しい")
    void equalUser() {
        User user1 = new User("firstName", "lastName");
        User user2 = new User("firstName", "lastName");
        assertEquals(user1, user2, "user1 should equal user2");
    }

    @Test
    @DisplayName("名前が型の場合、例外を投げる")
    void bothNameEmpty(){
        EmptyNameException ex =
                assertThrows(EmptyNameException.class,
                        () -> new User("", ""));
        assertEquals(ex.getMessage(), "firstName or lastName is empty.");
    }
}