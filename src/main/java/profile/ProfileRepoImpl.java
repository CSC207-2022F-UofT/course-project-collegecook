package profile;

import entities.Profile;
import java.io.*;
import java.util.ArrayList;

public class ProfileRepoImpl implements ProfileRepoGateway {
    /**
     * This class is to read profiles from "Profile.sav" or write profiles into "Profile.sav"
     */
    private static final String file = "Profile.sav";
    private static ProfileRepoImpl profileRepoImpl;

    public static ProfileRepoImpl getProfileRepoImpl() {
        if (profileRepoImpl == null) {
            profileRepoImpl = new ProfileRepoImpl();
        }
        return profileRepoImpl;
    }

    /**
     * @return Return an arraylist of profiles stored in the local file.
     * @throws IOException Will be handled in the UI.
     */
    @Override
    public ArrayList<Profile> getProfile() throws IOException {
        FileInputStream f1 = new FileInputStream(file);
        ObjectInputStream inputStream = new ObjectInputStream(f1);
        try {
            return (ArrayList<Profile>) inputStream.readObject();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        f1.close();
        return null;
    }

    /**
     * @param profiles an arraylist of profiles that needs to be saved in the local file.
     * @throws IOException Will be handled in the UI.
     */
    @Override
    public void saveProfile(ArrayList<Profile> profiles) throws IOException {
        FileOutputStream f2 = new FileOutputStream(file);
        ObjectOutputStream outputstream = new ObjectOutputStream(f2);
        outputstream.writeObject(profiles);
        f2.close();
    }

//    public static void main(String[] args) throws IOException {
//        ArrayList<Profile> profileList = new ArrayList<>();
//        ProfileRepoImpl prl = ProfileRepoImpl.getProfileRepoImpl();
//        prl.saveProfile(profileList);
//    }
}

