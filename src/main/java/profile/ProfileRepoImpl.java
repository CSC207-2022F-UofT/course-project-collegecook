package profile;

import entities.Profile;
import recipe.RecipeReadWriter;

import java.io.*;
import java.util.ArrayList;

public class ProfileRepoImpl implements ProfileRepoGateway{
    private static final String file = "Profile.sav";
    private static ProfileRepoImpl prl;

    public static ProfileRepoImpl getPrl(){
        if (prl == null){
            prl = new ProfileRepoImpl();
        }
        return prl;
    }

    @Override
    public ArrayList<Profile> getProfile() throws IOException {
        FileInputStream f1 = new FileInputStream(file);
        ObjectInputStream inputStream = new ObjectInputStream(f1);
        try{
            return (ArrayList<Profile>) inputStream.readObject();
        } catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        f1.close();
        return null;
    }

    @Override
    public void saveProfile(ArrayList<Profile> pro) throws IOException {
        FileOutputStream f2 = new FileOutputStream(file);
        ObjectOutputStream outputstream = new ObjectOutputStream(f2);
        outputstream.writeObject(pro);
        f2.close();
    }

    public static void main(String[] arg) throws IOException {
        ProfileRepoImpl profileRepo = ProfileRepoImpl.getPrl();
        Profile p = new Profile("Peter");
//        ArrayList<Profile> ap = new ArrayList<>();
//        ap.add(p);
//        profileRepo.saveProfile(ap);
        for (Profile pp :profileRepo.getProfile()){
            System.out.println(pp.getUsername());
        }

    }
}
