package login;

import entities.UserList;
import java.io.*;

public class UserRepoImpl implements UserGateWay {

    private static final String file = "user.sav";
    private static UserRepoImpl userRepoImpl;


    private UserRepoImpl(){}

    public static UserRepoImpl getUserRepoImpl(){
        if (userRepoImpl == null){
            userRepoImpl = new UserRepoImpl();
        }
        return userRepoImpl;
    }

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

    @Override
    public void saveUser(UserList userlist) throws IOException {
        FileOutputStream f2 = new FileOutputStream(file);
        ObjectOutputStream outputStream = new ObjectOutputStream(f2);
        outputStream.writeObject(userlist);
        f2.close();

    }
}
