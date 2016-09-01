import java.util.HashSet;
import java.util.Set;

/**
 * Created by Shengwei_Wang on 8/31/16.
 */
public class _345_ReverseVowelsOfAString {
    public String reverseVowels(String s) {
        Set<Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        set.add('A');
        set.add('E');
        set.add('I');
        set.add('O');
        set.add('U');
        int l = 0;
        int r = s.length() -1;
        char[] s1 = s.toCharArray();
        while(l < r){
            while(l < r && !set.contains(s1[l]))
                ++l;
            while(l < r && !set.contains(s1[r]))
                --r;
            char temp = s1[l];
            s1[l] = s1[r];
            s1[r] = temp;
            ++l;
            --r;
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s1.length; ++i)
            sb.append(s1[i]);
        return sb.toString();
    }
}
