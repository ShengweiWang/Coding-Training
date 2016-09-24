import java.util.LinkedList;
import java.util.List;

/**
 * Created by Shengwei_Wang on 9/21/16.
 */
public class _57_InsertInterval {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> ans = new LinkedList<>();
        int i = 0;
        while(i < intervals.size() && intervals.get(i).end < newInterval.start){
            ans.add(intervals.get(i++));
        }
        while(i < intervals.size() && intervals.get(i).start <= newInterval.end){
            newInterval = new Interval (
                    Math.min(intervals.get(i).start, newInterval.start),
                    Math.max(intervals.get(i).end, newInterval.end)
            );
            ++i;
        }
        ans.add(newInterval);
        while(i < intervals.size()){
            ans.add(intervals.get(i++));
        }
        return ans;
    }
}
