package review;

import entities.AverageRatings;

import java.io.*;

public class AverageRatingReadWriter implements ReadWriter<AverageRatings> {
    /**
     * Writes the users to file at filePath.
     *
     * @param filePath the file to write the records to
     * @param ratings  stores the map of ratings to be serialized
     */
    public void saveToFile(String filePath, AverageRatings ratings) throws IOException {

        OutputStream file = new FileOutputStream(filePath);
        OutputStream buffer = new BufferedOutputStream(file);
        ObjectOutput output = new ObjectOutputStream(buffer);

        // serialize the Map
        output.writeObject(ratings);
        output.close();
    }


    /**
     * Store the users to file at filePath.
     *
     * @param filePath file where the user list is stored
     * @return list of reviews
     */
    public AverageRatings readFromFile(String filePath) throws IOException, ClassNotFoundException {

        InputStream file = new FileInputStream(filePath);
        InputStream buffer = new BufferedInputStream(file);
        ObjectInput input = new ObjectInputStream(buffer);

        // serialize the Map
        AverageRatings reviews = (AverageRatings) input.readObject();
        input.close();
        return reviews;
    }
}
