/**
 * Created by Shengwei_Wang on 9/4/16.
 */
public class _3_LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 0)
            return 0;
        int max = 0;
        int start = 0;
        boolean[] f = new boolean[256];
        for(int i = 0; i < s.length(); ++i){
            if(f[s.charAt(i)]){
                while(f[s.charAt(i)]){
                    f[s.charAt(start)] = false;
                    ++start;
                }
            }
            f[s.charAt(i)] = true;
            if(i - start > max)
                max = i - start;
        }
        return max + 1;
    }
}
