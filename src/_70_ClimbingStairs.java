/**
 * Created by Shengwei_Wang on 9/3/16.
 */
public class _70_ClimbingStairs {
    public int climbStairs(int n) {
        int ans1 = 0;
        int ans2 = 1;
        for(int i = 0; i < n; ++i){
            ans2 += ans1;
            ans1 = ans2 - ans1;
        }
        return ans2;
    }
}
