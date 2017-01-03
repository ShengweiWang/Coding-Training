package Palindrome;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Shengwei_Wang on 11/9/16.
 */
public class _131_PalindromePartitioning {
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new LinkedList<>();
        List<String> curr = new LinkedList<>();
        dfs(s, 0, ans, curr);
        return ans;
    } // partition


    void dfs (String s, int start, List<List<String>> ans, List<String> curr) {
        if (start == s.length()) {
            ans.add(new LinkedList<>(curr));
            return;
        }
        for (int i = start; i < s.length(); ++i ) {
            if (isPalindrome(s, start, i)) {
                curr.add(s.substring(start, i + 1));
                dfs(s, i + 1, ans, curr);
                curr.remove(curr.size() - 1);
            } // if
        }   // for i
    } // dfs

    boolean isPalindrome(String s, int l, int r) {
        while (l < r) {
            if (s.charAt(l) != s.charAt(r))
                return false;
            ++l;
            --r;
        } //while
        return true;
    }

}
