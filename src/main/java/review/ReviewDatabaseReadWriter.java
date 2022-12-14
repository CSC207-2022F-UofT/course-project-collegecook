package review;
import entities.ReviewDatabase;

import java.io.*;

public class ReviewDatabaseReadWriter implements ReadWriter<ReviewDatabase> {

    private static ReviewDatabaseReadWriter reviewReadWriter;
    public static ReviewDatabaseReadWriter getReviewRepo(){
        if (reviewReadWriter == null){
            reviewReadWriter = new ReviewDatabaseReadWriter();
        }
        return reviewReadWriter;
    }


    /**
     * Writes the users to file at filePath.
     *
     * @param filePath the file to write the records to
     * @param reviews  stores the list of users to be serialized
     */
    public void saveToFile(String filePath, ReviewDatabase reviews) throws IOException {

        OutputStream file = new FileOutputStream(filePath);
        OutputStream buffer = new BufferedOutputStream(file);
        ObjectOutput output = new ObjectOutputStream(buffer);

        // serialize the Map
        output.writeObject(reviews);
        output.close();
    }


    /**
     * Store the users to file at filePath.
     *
     * @param filePath file where the user list is stored
     * @return list of reviews
     */
    public ReviewDatabase readFromFile(String filePath) throws IOException, ClassNotFoundException {

        InputStream file = new FileInputStream(filePath);
        InputStream buffer = new BufferedInputStream(file);
        ObjectInput input = new ObjectInputStream(buffer);

        // serialize the Map
        ReviewDatabase reviews = (ReviewDatabase) input.readObject();
        input.close();
        return reviews;
    }
}
