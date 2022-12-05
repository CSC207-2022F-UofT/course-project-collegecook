package review;

import java.util.ArrayList;

public interface ReviewViewBox {

    void success(ArrayList<String> reviews);

    void fail();
}
