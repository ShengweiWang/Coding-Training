import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by Shengwei_Wang on 9/12/16.
 */
public class _253_MeetingRoomsII {
    public int minMeetingRooms(Interval[] intervals) {
        Arrays.sort(intervals, new Comparator<Interval>(){
            @Override
            public int compare(Interval o1, Interval o2){
                return Integer.compare(o1.start, o2.start);
            }
        });


        PriorityQueue<Integer> q = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2){
                return Integer.compare(o1, o2);
            }
        });

        for(int i = 0; i < intervals.length; ++i){
            if(q.size() != 0 && q.peek() <= intervals[i].start){
                q.poll();
            }
            q.offer(intervals[i].end);
        }
        return q.size();
    }
}
