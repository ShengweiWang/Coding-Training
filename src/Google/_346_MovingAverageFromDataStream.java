package Google;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Shengwei_Wang on 10/18/16.
 */
public class _346_MovingAverageFromDataStream {
    /** Initialize your data structure here. */
    Queue<Integer> q;
    double sum;
    int size;
    public _346_MovingAverageFromDataStream(int size) {
        this.size = size;
        q = new LinkedList<>();
    }

    public double next(int val) {
        if (q.size() == size) {
            sum -= q.poll();
        }
        q.offer(val);
        sum += val;
        return sum / q.size();
    }
}
