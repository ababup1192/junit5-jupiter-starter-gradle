package com.example.project;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class UserServiceTest {
    UserService service;

    @BeforeEach
    void setUp() {
        final List<User> users
                = Collections.unmodifiableList(Arrays.asList(
                new User("George", "Washington"),
                new User("John", "Adams"),
                new User("Thomas", "Jefferson"),
                new User("John", "Tyler"),
                new User("George", "Bush"),
                new User("Barack", "Obama"),
                new User("Donald", "Trump")

        ));

        this.service = new UserService(users);
    }

    @Test
    @DisplayName("Serviceの持つusersと同一のusersが等しい")
    void getUsers() {
        final List<User> users
                = Collections.unmodifiableList(Arrays.asList(
                new User("George", "Washington"),
                new User("John", "Adams"),
                new User("Thomas", "Jefferson"),
                new User("John", "Tyler"),
                new User("George", "Bush"),
                new User("Barack", "Obama"),
                new User("Donald", "Trump")

        ));

        assertIterableEquals(users, service.getUsers());
    }

    @Test
    @DisplayName("最初のUserはジョージ・ワシントン")
    void getFirstUser() {
        assertEquals(Optional.of(new User("George", "Washington")), service.getFirstUser());
    }

    @Test
    @DisplayName("空のUsersを持つServiceの最初のUserは、empty")
    void getEmptyUser() {
        final UserService emptyService = new UserService(new ArrayList<>());

        assertFalse(emptyService.getFirstUser().isPresent());
    }

    @Nested
    @DisplayName("名前で検索する")
    class FindByNameWithTest {

        @Test
        @DisplayName("FirstNameがJohnである最初のUserは、John Adams")
        void getFirstJohn() {
            assertEquals(Optional.of(new User("John", "Adams")), service.findByFirstName("John"));
        }

        @Test
        @DisplayName("LastNameがTrumpである最初のUserは、Donald Trump")
        void getFirstTrump() {
            assertEquals(Optional.of(new User("Donald", "Trump")), service.findByLastName("Trump"));
        }
    }
}