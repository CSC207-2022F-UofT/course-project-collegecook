package login;

import entities.UserList;
import java.io.*;

public class UserRepoImpl implements UserGateWay {

    /**
     * This class is used to read user from "user.sav" or write recipe into "user.sav"
     */

    private static final String file = "user.sav";
    private static UserRepoImpl userRepoImpl;


    public UserRepoImpl(){}
    /**
     *
     * @return userRepoImpl. The Singleton Design Pattern is used here to control the initialization of gateway.
     */
    public static UserRepoImpl getUserRepoImpl(){
        if (userRepoImpl == null){
            userRepoImpl = new UserRepoImpl();
        }
        return userRepoImpl;
    }
    /**
     *to return the UserList in the local file
     * @return Return the UserList stored in the local file.
     * @throws IOException The IOException for serialization and readWriter
     */
    @Override
    public UserList getAllUser() throws IOException {
        FileInputStream f = new FileInputStream(file);
        ObjectInputStream inputStream = new ObjectInputStream(f);
        try{
            return (UserList) inputStream.readObject();
        } catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        f.close();
        return null;
    }

    /**
     *
     * @param userlist The userlist that needs to be stored.
     * @throws IOException The IOException for serialization and readWriter
     */
    @Override
    public void saveUser(UserList userlist) throws IOException {
        FileOutputStream f2 = new FileOutputStream(file);
        ObjectOutputStream outputStream = new ObjectOutputStream(f2);
        outputStream.writeObject(userlist);
        f2.close();

    }

}
