import java.util.HashSet;
import java.util.Set;

/**
 * Created by Shengwei_Wang on 8/24/16.
 */
public class _387_FirstUniqueCharacterInAString {
    public int firstUniqChar(String s) {
        int[] hash = new int[255];
        for(int i = 0; i < s.length(); ++i)
            ++hash[s.charAt(i)];
        for(int i = 0; i < s.length(); ++i)
            if(hash[s.charAt(i)] == 1)
                return i;
        return -1;
    }
}
