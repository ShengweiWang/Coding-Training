import java.util.Stack;

/**
 * Created by Shengwei_Wang on 8/31/16.
 */
public class _84_LargestRectangleInHistogram {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> s = new Stack<Integer>();
        int ans = 0;
        for(int i = 0; i < heights.length; ++i){
            while(s.size() > 0 && s.peek() > heights[i]) {
                int cur = (i - s.peek()) * heights[s.peek()];
                if(cur > ans)
                    ans = cur;
                s.pop();
            }
            s.push(i);
            if(s.size() == 0){
                int cur = (i + 1) * heights[i];
                if(cur > ans)
                    ans = cur;
            }
        }
        while(s.size() > 0){
            int cur = (heights.length - s.peek()) * heights[s.peek()];
            if(cur > ans)
                ans = cur;
            s.pop();
        }
        return ans;
    }
}
