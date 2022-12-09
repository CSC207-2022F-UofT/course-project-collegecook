package rank;

import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;

public class RankRequestModelTest {
    @Test
    public void RankRequestTest() {
        String rank = "total followers";
        RankRequestModel rankRequestModel = new RankRequestModel(rank);
        String expected = "total followers";
        String actual = rankRequestModel.getRanking();
        assertEquals(expected, actual);

    }
}