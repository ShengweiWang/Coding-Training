/**
 * Created by Shengwei_Wang on 9/3/16.
 */
public class _389_FindTheDifference {
    public char findTheDifference(String s, String t) {
        int[] f = new int[512];
        for(int i = 0; i < s.length(); ++i){
            ++f[s.charAt(i)];
        }
        for(int i = 0; i < t.length(); ++i){
            if(--f[t.charAt(i)] < 0)
                return t.charAt(i);
        }
        return '0';
    }
}
