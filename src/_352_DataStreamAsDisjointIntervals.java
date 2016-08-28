import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Shengwei_Wang on 8/27/16.
 */
public class _352_DataStreamAsDisjointIntervals {
    List<Interval> res;
    public _352_DataStreamAsDisjointIntervals() {
        res = new ArrayList<Interval>();
    }
    public void addNum(int val) {
        if(res.size() == 0){
            res.add(0, new Interval(val, val));
            return;
        }
        int l = 0;
        int r = res.size() - 1;
        int mid;
        while (l < r) {
            mid = l + ((r - l) >> 1);
            if (res.get(mid).start >= val)
                r = mid;
            else
                l = mid + 1;
        } //l will be the first >= val
        if (res.get(l).start < val)
            ++l;
        if (l == 0) {
            if (val == res.get(0).start - 1) {
                --res.get(0).start;
            } else if (val == res.get(0).start)
                return;
            else {
                res.add(0, new Interval(val, val));
            }
        } else if(l == res.size()) {
            if (res.get(l - 1).end >= val)
                return;
            else if (res.get(l - 1).end+1 == val)
                ++res.get(l - 1).end;
            else
                res.add(l, new Interval(val, val));
        } else {
            if (val <= res.get(l - 1).end || val == res.get(l).start) {
                return;
            } else if (val == res.get(l - 1).end + 1) {
                ++res.get(l - 1).end;
            } else if (val == res.get(l).start - 1) {
                --res.get(l).start;
            } else {
                res.add(l, new Interval(val, val));
            }
            if (res.get(l - 1).end == res.get(l).start - 1) {
                res.get(l - 1).end = res.get(l).end;
                res.remove(l);
            }
        }
    }
    public List<Interval> getIntervals() {
            return res;
    }
}
