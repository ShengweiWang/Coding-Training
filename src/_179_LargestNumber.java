import java.util.PriorityQueue;

/**
 * Created by Shengwei_Wang on 11/4/16.
 */
public class _179_LargestNumber {
    public String largestNumber(int[] nums) {
        PriorityQueue<String> q = new PriorityQueue<>((a,b) -> ((b+a).compareTo(a+b)));
        for (int num : nums) {
            q.offer(Integer.toString(num));
        }
        StringBuilder sb = new StringBuilder();
        while (q.size() > 0)
            sb.append(q.poll());
        while (sb.length() > 1 && sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        }
        return sb.toString();
    }
}
