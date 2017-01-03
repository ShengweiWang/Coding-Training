package oa.amazon;

import java.util.HashMap;

/**
 * Created by Shengwei_Wang on 12/29/16.
 */
public class TopFiveScore {
    public static HashMap<Integer, Double> findFive(Result[] array) {
        return null;
    }

    class Result {
        int id, score;
        public Result (int id, int score) {
            this.id = id;
            this.score = score;
        }
    }
}
