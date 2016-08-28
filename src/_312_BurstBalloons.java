/**
 * Created by Shengwei_Wang on 8/25/16.
 */
public class _312_BurstBalloons {
    public int maxCoins(int[] nums) {
        int[][] f = new int[nums.length + 2][nums.length + 2];
        int mul1;
        for(int len = 2; len < nums.length + 2; ++len){
            for(int i = -1; i <= nums.length -len; ++i){
                if ( i == -1)
                    mul1 = 1;
                else
                    mul1 = nums[i];
                int j = i + len;
                if (j == nums.length)
                    mul1 *= nums[j];
                for(int k = i + 1; k < j; ++k){
                    int temp = f[i + 1][k + 1] + f[k + 1][j + 1] + mul1 * nums[k];
                    if (temp > f[i + 1][j + 1])
                        f[i + 1][j + 1] = temp;

                }
            }
        }
        return f[0][nums.length + 1];
    }
}
