/**
 * Created by Shengwei_Wang on 8/22/16.
 */
public class _260_SingleNumberIII {
    public int[] singleNumber(int[] nums) {
        int diff = 0;
        for (int i = 0; i < nums.length; ++i)
            diff ^= nums[i];

//        System.out.print(diff);
//        System.out.print(" ~ ");
//        System.out.println(diff & - diff);

        diff &= -diff; //get the last set bit

        int[] ans = {0,0};
        for (int i = 0; i < nums.length; ++i){
            if ((nums[i] & diff) == 0)
                ans[0] ^= nums[i];
            else
                ans[1] ^= nums[i];
        }
        return ans;
    }
}
