import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by Shengwei_Wang on 8/29/16.
 */
public class _295_FindMedianFromDataStream {
    PriorityQueue<Integer> small;
    PriorityQueue<Integer> large;
    public _295_FindMedianFromDataStream(){
        small = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        large = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });

    }
    // Adds a number into the data structure.
    public void addNum(int num) {
        small.offer(num);

        if(small.size() > large.size()){
            large.offer(small.poll());
        }

//        System.out.println(large.peek());
        if(small.size() > 0) {
            if (small.peek() > large.peek()) {
//                System.out.println("change");
                large.offer(small.poll());
                small.offer(large.poll());
            }
        }
    }

    // Returns the median of current data stream
    public double findMedian() {
        if(small.size() == large.size())
            return (small.peek() + large.peek())/2;
        else
            return (double)large.peek();
    }
}
