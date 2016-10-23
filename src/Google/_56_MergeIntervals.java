package Google;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Shengwei_Wang on 10/15/16.
 */
public class _56_MergeIntervals {
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> ans = new LinkedList<>();
        if (intervals.size() == 0)
            return ans;
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2){
                return o1.start - o2.start;
            }
        });
        Interval cur = intervals.get(0);
        for(Interval iterator : intervals){
            if (cur.end >= iterator.start)
                cur.end = Math.max(cur.end, iterator.end);
            else {
                ans.add(cur);
                cur = iterator;
            }
        }
        ans.add(cur);
        return ans;
    }
}
