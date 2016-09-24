/**
 * Created by Shengwei_Wang on 9/21/16.
 */
public class _306_AdditiveNumber {
    char[] nums;
    int n;
    public boolean isAdditiveNumber(String num) {
        nums = num.toCharArray();
        n = nums.length;
        long n1 = 0;

        for(int i = 0; i < n - 2; ++i){
            n1 = n1 * 10 + nums[i] - '0';

            long n2 = 0;
            for(int j = i + 1; j < n - 1; ++j){
                n2 = n2 * 10 + nums[j] - '0';
                if (test(n1, n2, j + 1))
                    return true;
                if(n2 == 0)
                    break;
            }
            if(n1 == 0)
                break;
        }
        return false;
    }
    boolean test(long n1, long n2, int pos){
        while(pos < n){
            String s = Long.toString(n1 + n2);
            if(s.length() + pos > n)
                return false;
            for(int i = 0; i < s.length(); ++i)
                if(nums[pos + i] != s.charAt(i))
                    return false;
            pos += s.length();
            n1 = n2;
            n2 = Long.valueOf(s);
        }
        return true;
    }
}
