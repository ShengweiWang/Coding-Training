import java.util.Arrays;

/**
 * Created by Shengwei_Wang on 11/5/16.
 */
public class _435_NonOverLappingIntervals {
    public int eraseOverlapIntervals(Interval[] intervals) {
        if (intervals.length <= 1)
            return 0;
        Arrays.sort(intervals, (a, b) -> (a.start - b.start));
        int curr = intervals[0].start;
        int ans = 0;
        for (Interval i : intervals) {
            if(i.start < curr) {
                ++ans;
                curr = Math.min(curr, i.end);
            } else
                curr = i.end;
        }
        return ans;
    }
}
