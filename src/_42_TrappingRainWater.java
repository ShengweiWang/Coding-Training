import java.util.Stack;

/**
 * Created by Shengwei_Wang on 9/18/16.
 */
public class _42_TrappingRainWater {
    public int trap(int[] height) {
        Stack<Integer> heights = new Stack<Integer>();
        Stack<Integer> index = new Stack<>();
        int ans = 0;
        for(int i = 0; i < height.length; ++i){
            if(height[i] == 0)
                continue;
            int prev = 0;
            while(heights.size() > 0 && heights.peek() <= height[i]) {
                ans += (heights.peek() - prev) * (i - index.peek() - 1);
                prev = heights.pop();
                index.pop();
            }
            if(heights.size() > 0) {
                ans += (height[i] - prev) * (i - index.peek() - 1);
            }
            heights.push(height[i]);
            index.push(i);
        }
        return ans;
    }
}
