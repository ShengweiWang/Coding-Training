import java.util.*;

/**
 * Created by Shengwei_Wang on 9/2/16.
 */
public class _56_MergeIntervals {
    public class Interval {
        int start;
        int end;
        Interval() {start = 0; end = 0;}
        Interval(int s, int e) {start = s; end = e;}
    }
    public List<Interval> merge(List<Interval> intervals) {
        if(intervals.size() == 0)
            return new ArrayList<Interval>();
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return Integer.compare(o1.start, o2.start);
            }
        });
        List<Interval> ans = new ArrayList<>();
        int start = intervals.get(0).start;
        int end = intervals.get(0).end;
        for(Interval it : intervals){
            if(it.start <= end){
                end = Math.max(it.end, end);
            } else {
                ans.add(new Interval(start, end));
                start = it.start;
                end = it.end;
            }
        }
        ans.add(new Interval(start, end));
        return ans;
    }
}
