/**
 * Created by Shengwei_Wang on 9/2/16.
 */
public class _340_LongestSubstringWithAtMostKDistinctCharacters {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if(s.length() == 0 || k == 0)
            return 0;
        int[] f = new int[512];
        f[(int)s.charAt(0)] = 1;
        int diff = 1;
        int start = 0;
        int ans = 0;
        for(int i = 1; i < s.length(); ++i){
            if(f[(int)s.charAt(i)] == 0){
                if(diff == k){
                    while(f[(int)s.charAt(start)] > 1){
                        --f[(int)s.charAt(start)];
                        ++start;
                    }
                    --f[(int)s.charAt(start)];
                    ++start;
                } else {
                    ++diff;
                }
                ++f[(int)s.charAt(i)];
            } else{
                ++f[(int)s.charAt(i)];
            }
            if (i - start > ans)
                ans = i - start;
        }
        return ans + 1;
    }
}
