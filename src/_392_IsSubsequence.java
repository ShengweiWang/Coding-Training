/**
 * Created by Shengwei_Wang on 9/14/16.
 */
public class _392_IsSubsequence {
    public boolean isSubsequence(String t, String s) {
        int j = 0;
        int maxj = s.length();
        for(int i = 0; i < t.length(); ++i){
            while(j < maxj && s.charAt(j) != t.charAt(i))
                ++j;
            if(j == maxj)
                return false;
            ++j;
        }
        return true;
    }
}
