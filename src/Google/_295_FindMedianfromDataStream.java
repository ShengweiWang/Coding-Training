package Google;

import java.util.PriorityQueue;

/**
 * Created by Shengwei_Wang on 10/16/16.
 */
public class _295_FindMedianfromDataStream {
    PriorityQueue<Integer> small;
    PriorityQueue<Integer> large;
    public _295_FindMedianfromDataStream(){
        small = new PriorityQueue<>((a,b)-> (b - a));
        large = new PriorityQueue<>((a,b)-> (a - b));
    }

    public void addNum (int n) {
        small.offer(n);
        if(small.size() > large.size())
            large.offer(small.poll());

        if (small.size() > 0){
            if (small.peek() > large.peek()){
                small.offer(large.poll());
                large.offer(small.poll());
            }
        }
    }

    public double findMedian() {
        if (small.size() == large.size())
            return (small.peek() + large.peek()) / 2.0;
        else
            return large.peek();
    }
}
