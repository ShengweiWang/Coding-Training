/**
 * Created by Shengwei_Wang on 8/24/16.
 */
public class _238_ProductOfArrayExceptSelf {
    public int[] productExceptSelf(int[] nums){
        int[] ans = nums.clone();
        for(int i = 1; i < ans.length; ++i)
            ans[i] = ans[i-1] * ans[i];
//        for(int i = 0; i < ans.length; ++i)
//            System.out.println(ans[i]);
//        System.out.println("~~~~");
        int mul = 1;
        for(int i = ans.length - 1; i > 0; --i){
            ans[i] = ans[i-1] * mul;
            mul *= nums[i];
        }
        ans[0] = mul;

        return ans;
    }
}
