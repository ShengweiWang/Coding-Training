package Google;

/**
 * Created by Shengwei_Wang on 10/15/16.
 */
public class _66_PlusOne {
    public int[] plusOne(int[] digits) {
        int i = digits.length - 1;
        while(i >= 0){
            ++digits[i];
            if(digits[i] > 9)
                digits[i] -= 10;
            else
                break;
            --i;
        }

        if (i < 0){
            int[] ans = new int[digits.length + 1];
            ans[0] = 1;
            return ans;
        } else
            return digits;
    }
}
