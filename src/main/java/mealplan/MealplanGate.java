package mealplan;

import entities.MealplanList;

import java.io.*;
/**
 * This class is used to read recipe from "mealplan.sav" or write recipe into "mealplan.sav"
 */
public class MealplanGate implements MealplanGateway {
    String filePath;
    private static MealplanGate mealplanGate;

    MealplanGate(){
        this.filePath = "mealplan.sav";
    }

    /**
     * Save the MealplanList.
     * @param mealplans The MealplanList that the user wants to store.
     */
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

    /**
     * Get the stored MealplanList
     * @return The MealplanList stored in the database.
     */
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

    /**
     * Construct the RecipeReadWriter
     * @return mealplangate. The Singleton Design Pattern is used here to control the initialization of gateway.
     */
    public static MealplanGate getInstance()
    {
        if (mealplanGate == null)
            mealplanGate = new MealplanGate();

        return mealplanGate;
    }

}