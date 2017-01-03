package Google;

/**
 * Created by Shengwei_Wang on 10/25/16.
 */
public class _408_ValidWordAbbreviation {
    public boolean validWordAbbreviation(String word, String abbr) {
        int k = 0;
        int curr = 0;
        for (int i = 0; i < abbr.length(); ++i) {
            char c = abbr.charAt(i);
            if (c >= 'a' && c <= 'z') {
                k += curr;
                if (k < word.length() && c == word.charAt(k))
                    ++k;
                else
                    return false;
                curr = 0;
            } else {
                if (curr == 0 && c == '0')
                    return false;
                curr = curr * 10 + c - '0';
                if (k + curr > word.length())
                    return false;
            }
        }
        if (k + curr == word.length())
            return true;
        else
            return false;
    }
}
