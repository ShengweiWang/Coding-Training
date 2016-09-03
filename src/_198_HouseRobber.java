/**
 * Created by Shengwei_Wang on 9/3/16.
 */
public class _198_HouseRobber {
    public int rob(int[] nums) {
        int yes = 0;
        int no = 0;
        for(int i = 0; i < nums.length; ++i){
            int temp = no;
            no = Math.max(yes, no);
            yes = temp + nums[i];
        }
        return Math.max(yes, no);
    }
}
