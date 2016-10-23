package Google;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Shengwei_Wang on 10/20/16.
 */
public class _253_MeetingRoomsII {
    public int minMeetingRooms(Interval[] intervals) {
        List<int[]> list = new LinkedList<>();
        for (Interval interval : intervals) {
            list.add (new int[] {0, interval.start});
            list.add (new int[] {1, interval.end});
        }
        Collections.sort(list, (a, b) -> {
            if (a[1] != b[1])
                return a[1] - b[1];
            else
                return b[0] - a[0];
            });
        int max = 0;
        int cur = 0;
        for (int[] curr : list) {
            if (curr[0] == 0)
                max = Math.max(max, ++cur);
            else
                --cur;
        }
        return max;
    }
}
