/**
 * Created by Shengwei_Wang on 8/29/16.
 */
public class _132_PalindromePartitioningII {
    public int minCut(String s) {
        int [] f = new int [s.length()];
        for(int i = 0; i < f.length; ++i)
            f[i] = Integer.MAX_VALUE;
        for(int i = 0; i < f.length; ++i){
            int j = 0;
            while(i - j > 0 && i + j < s.length() && s.charAt(i-j) == s.charAt(i+j)){
                f[i + j] = Math.min(f[i+j], f[i-j-1] + 1);
                ++j;
            }
            if(i - j == 0 && i + j < s.length() && s.charAt(i-j) == s.charAt(i+j))
                f[i+j] = 1;

            j = 0;
            while(i - j - 1> 0 && i + j < s.length() && s.charAt(i-j-1) == s.charAt(i+j)){
                f[i + j] = Math.min(f[i+j], f[i-j-2] + 1);
                ++j;
            }
            if(i - j -1 == 0 && i + j < s.length() && s.charAt(i-j-1) == s.charAt(i+j))
                f[i+j] = 1;
        }
//        for(int i = 0; i < f.length; ++i)
//            System.out.println(f[i]);
        return f[f.length - 1] - 1;
    }
}
