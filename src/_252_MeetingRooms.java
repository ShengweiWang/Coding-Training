import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by Shengwei_Wang on 9/3/16.
 */
public class _252_MeetingRooms {
    public boolean canAttendMeetings(Interval[] intervals) {
        Arrays.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return Integer.compare();
            }
        }
    }
}
