/**
 * Created by Shengwei_Wang on 9/22/16.
 */
public class _87_ScrambleString {
    public boolean isScramble(String s1, String s2) {
        if(s1.length() != s2.length())
            return false;
        if(s1.equals(s2))
            return true;
        int[] letters = new int[512];
        for(int i = 0; i < s1.length(); ++i){
            ++letters[s1.charAt(i)];
        }
        for(int i = 0; i < s2.length(); ++i){
            if(--letters[s2.charAt(i)] < 0)
                return false;
        }
        for(int i = 1; i < s2.length(); ++i)
            if((isScramble(s1.substring(0, i), s2.substring(0, i))&& isScramble(s1.substring(i), s2.substring(i)))
                    ||(isScramble(s1.substring(0, i), s2.substring(s2.length() - i)) && isScramble(s1.substring(i), s2.substring(0, s2.length() - i))))
                return true;
        return false;

    }
}
