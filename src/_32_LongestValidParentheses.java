/**
 * Created by Shengwei_Wang on 8/29/16.
 */
public class _32_LongestValidParentheses {
    public int longestValidParentheses(String s) {
        int max = 0;
        int f[] = new int[s.length()];
        int open = 0;
        for(int i = 0; i < s.length(); ++i){
            if(s.charAt(i) == '(')
                ++open;
            else{
                if(open > 0){
                    f[i] = f[i-1] + 2;
                    if(i - f[i] >= 0)
                        f[i] += f[i - f[i]];
                    --open;
                    if (max < f[i])
                        max = f[i];
                }
            }
        }
        return max;
    }
}
