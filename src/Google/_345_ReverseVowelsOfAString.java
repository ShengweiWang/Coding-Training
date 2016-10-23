package Google;

import java.util.*;

/**
 * Created by Shengwei_Wang on 10/15/16.
 */
public class _345_ReverseVowelsOfAString {
    public String reverseVowels(String s) {
        Set<Character> set = new HashSet<>();
        String vowel = "aeiouAEIOU";
        for(int i = 0; i < vowel.length(); ++i)
            set.add(vowel.charAt(i));
        int l = 0;
        int r = s.length() - 1;
        char[] chars = s.toCharArray();
        while (l < r){
            while (l < r && !set.contains(chars[l]))
                ++l;
            while (l < r && !set.contains(chars[r]))
                --r;
            if (l < r) {
                char temp = chars[l];
                chars[l] = chars[r];
                chars[r] = temp;
                ++l;
                --r;
            }
        }
        return String.copyValueOf(chars);
    }
}
