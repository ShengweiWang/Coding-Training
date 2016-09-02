/**
 * Created by Shengwei_Wang on 9/1/16.
 */
public class _66_PlusOne {
    public int[] plusOne(int[] digits) {
        boolean flag = true;
        for(int i = 0; i < digits.length; ++i)
            if(digits[i] != 9){
                flag = false;
                break;
            }
        if(flag){
            int[] ans = new int[digits.length + 1];
            ans[0] = 1;
            return ans;
        }
        int cur = digits.length - 1;
        ++digits[cur];
        while(digits[cur] > 9){
            digits[cur] -= 10;
            --cur;
            ++digits[cur];
        }
        return digits;
    }
}
