package mealplan;

import entities.MealplanList;

import java.io.*;

public class MealplanGate implements MealplanGateway {
    String filePath;
    private static MealplanGate mealplanGate;

    MealplanGate(){
        this.filePath = "mealplan.sav";
    }

    @Override
    public void saveToFile(MealplanList mealplans){

        OutputStream file;
        try {
            file = new FileOutputStream(this.filePath);
            OutputStream buffer = new BufferedOutputStream(file);
            ObjectOutput output = new ObjectOutputStream(buffer);

            // serialize the Map
            output.writeObject(mealplans);
            output.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public MealplanList readFromFile() throws IOException, ClassNotFoundException {
        InputStream file = new FileInputStream(this.filePath);
        InputStream buffer = new BufferedInputStream(file);
        ObjectInput input = new ObjectInputStream(buffer);

        // serialize the Map
        MealplanList mealplans = (MealplanList) input.readObject();
        input.close();
        return mealplans;
    }

    // Static method to create instance of Singleton class
    public static MealplanGate getInstance()
    {
        if (mealplanGate == null)
            mealplanGate = new MealplanGate();

        return mealplanGate;
    }

}