import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * Created by Shengwei_Wang on 11/9/16.
 */
public class _127_WordLadder {
    public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        Queue<String> q = new LinkedList<>();
        q.offer(beginWord);
        int level = 1;
        while (q.size() > 0) {
            int size = q.size();
            ++level;
            for (int k = 0; k < size; ++k) {
                char[] s = q.poll().toCharArray();
                for (int i = 0; i < s.length; ++i) {
                    char word = s[i];
                    for (int j = 0; j < 26; ++j) {
                        s[i] =  (char)('a' + j);
                        String curr = new String(s);
                        if (curr.compareTo(endWord) == 0)
                            return level;
                        if (wordList.contains(curr)) {
                            q.offer(curr);
                            wordList.remove(curr);
                        }
                    }
                    s[i] = word;
                }
            }
        }
        return 0;
    }
}
