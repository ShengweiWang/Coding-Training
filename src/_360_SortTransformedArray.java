/**
 * Created by Shengwei_Wang on 9/14/16.
 */
public class _360_SortTransformedArray {
    public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        int[] ans = new int[nums.length];
        if(a == 0){
            if(b > 0){
                for(int i = 0; i < nums.length; ++i)
                    ans[i] = nums[i] * b + c;
            } else {
                for(int i = 0; i < nums.length; ++i)
                    ans[i] = nums[nums.length - i - 1] * b + c;
            }
        } else {
            int[] temp = new int[nums.length];
            if(a > 0) {
                for(int i = 0; i < nums.length; ++i){
                    temp[i] = - (nums[i] * nums[i] * a + nums[i] * b + c);
                }
            } else {
                for(int i = 0; i < nums.length; ++i){
                    temp[i] = nums[i] * nums[i] * a + nums[i] * b + c;
                }
            }
            int l = 0;
            int r = nums.length - 1;
            int i = 0;
            while(l <= r){
                if(temp[l] < temp[r]){
                    ans[i] = temp[l];
                    ++l;
                }
                else {
                    ans[i] = temp[r];
                    --r;
                }
                ++i;
            }
            if(a > 0){
                l = 0;
                r = nums.length - 1;
                while(l < r){
                    int temp1 = -ans[l];
                    ans[l] = -ans[r];
                    ans[r] = temp1;
                    ++l;
                    --r;
                }
                if(l==r)
                    ans[l] = -ans[l];
            }
        }

        return ans;
    }
}
