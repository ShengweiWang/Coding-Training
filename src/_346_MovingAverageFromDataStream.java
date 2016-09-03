import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Created by Shengwei_Wang on 9/3/16.
 */
public class _346_MovingAverageFromDataStream {
    Queue<Integer> q;
    int sum;
    int size;
    /** Initialize your data structure here. */
    public _346_MovingAverageFromDataStream(int size) {
        sum = 0;
        this.size = size;
        q = new ArrayDeque<Integer>();
    }

    public double next(int val) {
        sum += val;
        q.offer(val);
        if(q.size() > size){
            sum -= q.poll();
        }
        return (double) sum/q.size();
    }
}
