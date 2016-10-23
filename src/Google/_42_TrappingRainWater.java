package Google;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by Shengwei_Wang on 10/15/16.
 */
public class _42_TrappingRainWater {
    public int trap(int[] height) {
        Deque<Integer> deque = new ArrayDeque<>();
        int ans = 0;
        for (int i = 0; i < height.length; ++i){
            int lastHeight = 0;
            while (deque.size() > 0 && height[deque.getFirst()] <= height[i]){
                int j = deque.pop();
                ans += (height[j] - lastHeight) * (i - j - 1);
                lastHeight = height[j];
            }
            if (deque.size() > 0) {
                ans += (height[i] - lastHeight) * (i - deque.getFirst() - 1);
            }
            deque.push(i);
        }
        return ans;
    }
}
