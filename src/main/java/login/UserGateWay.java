package login;

import entities.UserList;

import java.io.IOException;

public interface UserGateWay {

   UserList getAllUser() throws IOException;

    void saveUser(UserList User) throws IOException;
}

