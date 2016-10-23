package Google;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by Shengwei_Wang on 10/17/16.
 */
public class _239_SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0)
            return nums;
        Deque<Integer> maxIndex = new ArrayDeque<>();
        for (int i = 0; i < k; ++i){
            while (maxIndex.size() > 0 && nums[maxIndex.getLast()] <= nums[i] )
                maxIndex.removeLast();
            maxIndex.addLast(i);
        }
        int [] ans = new int[nums.length - k + 1];
        ans[0] = nums[maxIndex.getFirst()];
        for (int i = k; i < nums.length; ++i){
            while (maxIndex.size() > 0 && maxIndex.getFirst() <= i - k)
                maxIndex.removeFirst();
            while (maxIndex.size() > 0 && nums[maxIndex.getLast()] <= nums[i] )
                maxIndex.removeLast();
            maxIndex.addLast(i);
            ans[i - k + 1] = nums[maxIndex.getFirst()];
        }
        return ans;
    }
}
