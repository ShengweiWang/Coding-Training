package oa.amazon.important9;

import com.apple.concurrent.Dispatch;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Created by Shengwei_Wang on 12/31/16.
 */
public class HighFiveP {
    public static HashMap<Integer, Double> findFive(Result[] array) {
        Map<Integer, PriorityQueue<Integer>> scoreTable = new HashMap<Integer, PriorityQueue<Integer>>();
        HashMap<Integer, Double> res = new HashMap<Integer, Double>();
        for (Result result : array) {
            if (!scoreTable.containsKey(result.id))
                scoreTable.put(result.id, new PriorityQueue<Integer>());
            PriorityQueue<Integer> pq = scoreTable.get(result.id);
            pq.offer(result.score);
        }

        for (Integer id : scoreTable.keySet()) {
            PriorityQueue<Integer> pq = scoreTable.get(id);
            double f = 0;
            for (int i = 0; i < 5; ++i) {
                f += pq.poll();
            }
            res.put(id, f / 5);
        }
        return res;
    }

    class Result {
        int id, score;
        public Result (int id, int score) {
            this.id = id;
            this.score = score;
        }
    }
}
