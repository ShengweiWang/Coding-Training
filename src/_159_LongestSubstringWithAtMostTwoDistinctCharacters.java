/**
 * Created by Shengwei_Wang on 9/17/16.
 */
public class _159_LongestSubstringWithAtMostTwoDistinctCharacters {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        if(s.length() <= 2)
            return s.length();
        int[] count = new int[512];
        int has = 0;
        int start = 0;
        int maxlength = 0;
        for(int i = 0; i < s.length(); ++i){
            char c = s.charAt(i);
            if(count[c] == 0 && has < 2){
                ++has;
            } else if (count[c] == 0) {
                while(count[s.charAt(start)] > 1){
                    --count[s.charAt(start)];
                    ++start;
                }
                --count[s.charAt(start)];
                ++start;
            }
            ++count[c];
            if(i - start + 1 > maxlength)
                maxlength = i - start + 1;
        }
        return maxlength;
    }
}
