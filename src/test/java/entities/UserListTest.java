package entities;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserListTest {
    UserList l;
    User a;
    User b;



    @BeforeEach
    void setUp() {
        a = new User("a","12345");
        b = new User("b","12345");
        l = new UserList();
        l.AddAllUser(a.getUsername(),a.getPassword());
    }

    @AfterEach
    void tearDown() {
        b = null;
        a = null;
        l = null;
    }
    @Test
    void checkAllUser() {
        Boolean expected = true;
        Boolean actual = l.CheckAllUser("c");
        assertEquals(expected, actual);
    }

    @Test
    void addAllUser() {
        l.AddAllUser("c","12345");
        Boolean expected = false;
        Boolean actual = l.CheckAllUser("c");
        assertEquals(expected, actual);
    }

    @Test
    void contains() {
        l.AddAllUser("c","12345");
        Boolean expected = true;
        Boolean actual = l.contains("c");
        assertEquals(expected, actual);
    }

    @Test
    void getUser() {
        User expected = (User) a;
        User actual = l.getUser("a");
        assertEquals(expected, actual);
    }
    @Test
    void getUser2() {
        User expected = null;
        User actual = l.getUser("d");
        assertEquals(null, actual);
    }

    @Test
    void getAllUser() {
        List<User> expected = new ArrayList<>();
        expected.add(a);
        List<User> actual = l.getAllUser();
        assertEquals(expected, actual);

    }

}