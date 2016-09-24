import java.util.Stack;

/**
 * Created by Shengwei_Wang on 8/31/16.
 */
public class _84_LargestRectangleInHistogram {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> s = new Stack<Integer>();
        int ans = 0;
        for(int i = 0; i <= heights.length; ++i){
            int h = i < heights.length ? heights[i] : 0;
            while(s.size() > 0 && heights[s.peek()] > h) {
                int top = s.pop();
                int cur = heights[top] * (s.size() == 0 ? i : (i - s.peek() - 1));
                if(cur > ans)
                    ans = cur;
            }
            s.push(i);
        }
        return ans;
    }
}
