import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by Shengwei_Wang on 9/19/16.
 */
public class _239_SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums.length == 0){
            return nums;
        }
        int[] ans = new int[nums.length - k + 1];
        Deque<Integer> q = new ArrayDeque<>();
        Deque<Integer> index = new ArrayDeque<>();
        for(int i = 0; i < k; ++i){
            while(q.size()>0 && q.getLast() <nums[i]){
                q.removeLast();
                index.removeLast();
            }
            q.offer(nums[i]);
            index.offer(i);
        }
        ans[0] = q.getFirst();
        for(int i = k; i < nums.length; ++i){
            if(index.getFirst() <= i - k){
                q.poll();
                index.poll();
            }
            while(q.size()>0 && q.getLast() <nums[i]){
                q.removeLast();
                index.removeLast();
            }
            q.offer(nums[i]);
            index.offer(i);
            ans[i - k + 1] = q.getFirst();
        }
        return ans;
    }
}
