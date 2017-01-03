package Google;

/**
 * Created by Shengwei_Wang on 11/2/16.
 */
public class _411_MinimumUniqueWordAbbreviation {
    String[] dictionary;
    String ans;
    public String minAbbreviation(String target, String[] dictionary) {
        ans = "";
        this.dictionary = dictionary;
        generateAbbreviations (target);
        return ans;
    }


    public void generateAbbreviations(String word) {
        dfs(0, 0, "", word);
    }


    void dfs (int pos, int currn, String currs, String s) {
        if (pos == s.length()) {
            String abbr = currs +(currn == 0?"":currn);
            if (ans.length() == 0 || ans.length() > abbr.length()) {
                for (String word : dictionary) {
                    if (validWordAbbreviation (word, abbr))
                        return;
                }
                ans = abbr;
            }
        } else {
            dfs(pos + 1, currn + 1, currs, s);
            dfs (pos + 1, 0, currs + (currn == 0?"":currn) + s.charAt(pos), s);
        }
    }

    boolean validWordAbbreviation(String word, String abbr) {
        int j = 0;
        int skip = 0;
        for (int i = 0; i < abbr.length(); ++i) {
            char c = abbr.charAt(i);
            if (c >= '0' && c <= '9') {
                skip = c - '0' + skip * 10;
                if (skip == 0)
                    return false;
            }
            else {
                j += skip;
                skip = 0;
                if (j >= word.length() || word.charAt(j) != c)
                    return false;
                ++j;
            }
        }
        return j + skip == word.length();
    }

}
