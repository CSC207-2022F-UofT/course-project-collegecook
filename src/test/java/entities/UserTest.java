package entities;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

public class UserTest {
    User a;
    User b;

    @BeforeEach
    void setUp() {
        a = new User("a","12345");
        b = new User("b","12345");
    }

    @AfterEach
    void tearDown() {
        b = null;
        a = null;}

    @Test
    void getUsername() {
        String expected = "a";
        String actual = a.getUsername();
        assertEquals(expected, actual);
    }

    @Test
    void getPassword() {
        String expected = "12345";
        String actual = a.getPassword();
        assertEquals(expected, actual);
    }

    @Test
    void addFollowers() {
        a.addFollowers(b);
        int expected = 1;
        int actual = a.GetNumberOfFollowers();
        assertEquals(expected, actual);
    }

    @Test
    void addFollowed() {
        b.addFollowed(a);
        int expected = 1;
        int actual = b.GetNumberOfFollowed();
        assertEquals(expected, actual);
    }


    @Test
    void RemoveFollowers() {
        a.addFollowers(b);
        a.RemoveFollowers(b);
        int expected = 0;
        int actual = a.GetNumberOfFollowers();
        assertEquals(expected, actual);
    }

    @Test
    void RemoveFollowed() {
        b.addFollowed(a);
        b.RemoveFollowed(a);
        int expected = 0;
        int actual = b.GetNumberOfFollowed();
        assertEquals(expected, actual);
    }

    @Test
    void getFollowers() {
    }

    @Test
    void getFollowed() {
    }


}
