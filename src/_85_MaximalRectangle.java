import java.util.Stack;

/**
 * Created by Shengwei_Wang on 9/23/16.
 */
public class _85_MaximalRectangle {
    public int maximalRectangle(char[][] matrix) {
        int n = matrix.length;
        if(n == 0)
            return 0;
        int m = matrix[0].length;
        int[] heights = new int[m + 1];
        int ans = 0;
        for(int row = 0; row < n; ++row){
            Stack<Integer> s = new Stack<Integer>();
            for(int i = 0; i <= m; ++i){
                if ( i < m)
                    if(matrix[row][i] == '1')
                        ++heights[i];
                    else
                        heights[i] = 0;
                int h = heights[i];
                while(s.size() > 0 && heights[s.peek()] > h) {
                    int top = s.pop();
                    int cur = heights[top] * (s.size() == 0 ? i : (i - s.peek() - 1));
                    if(cur > ans)
                        ans = cur;
                }
                s.push(i);
            }
        }
        return ans;
    }
}
