package review;

import java.io.IOException;

public interface ReadWriter<T> {
    /**
     * @param filepath location of ser file
     * @param o object to be serialized
     */
    void saveToFile(String filepath, T o) throws IOException;

    /**
     * @param filepath location of ser file
     */
    T readFromFile(String filepath) throws IOException, ClassNotFoundException;
}