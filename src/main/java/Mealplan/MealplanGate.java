package Mealplan;

import Entities.MealplanList;

import java.io.*;

public class MealplanGate implements MealPlanGateway {
    String filePath = "C:\\Users\\lucia\\Desktop";


    @Override
    public void saveToFile(String filepath, Object mealplans) throws IOException {

        OutputStream file = new FileOutputStream(filepath);
        OutputStream buffer = new BufferedOutputStream(file);
        ObjectOutput output = new ObjectOutputStream(buffer);

        // serialize the Map
        output.writeObject(mealplans);
        output.close();
    }

    @Override
    public MealplanList readFromFile(String filepath) throws IOException, ClassNotFoundException {
        InputStream file = new FileInputStream(filePath);
        InputStream buffer = new BufferedInputStream(file);
        ObjectInput input = new ObjectInputStream(buffer);

        // serialize the Map
        MealplanList mealplans = (MealplanList) input.readObject();
        input.close();
        return mealplans;
    }
}
