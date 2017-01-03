import java.util.*;

/**
 * Created by Shengwei_Wang on 11/9/16.
 */
public class _126_WordLadderII {
    public List<List<String>> findLadders(String beginWord, String endWord, Set<String> wordList) {
        Map<String, List<List<String>>> map = new HashMap<>();
        Queue<String> q = new LinkedList<>();
        List<String> initLs = new LinkedList<>();
        List<List<String>> initLsLs = new LinkedList<>();
        initLs.add(beginWord);
        initLsLs.add(initLs);
        map.put(beginWord, initLsLs);
        q.offer(beginWord);
        boolean found = false;
        while (q.size() > 0) {
            int size = q.size();
            if (found)
                break;
            for (int k = 0; k < size; ++k) {
                String curr = q.poll();
                List<List<String>> currLsLs = map.get(curr);
                char[] s = curr.toCharArray();
                for (int i = 0; i < s.length; ++i) {
                    char c = s[i];
                    for (char j = 'a'; j <= 'z'; ++j) {
                        s[i] = j;
                        String next = new String(s);
                        if (next.compareTo(endWord) == 0)
                            found = true;
                        if (wordList.contains(next) || found) {
                            List<List<String>> nextLsLs = map.getOrDefault(next, new LinkedList<>());
                            if (nextLsLs.size() == 0
                                    || nextLsLs.get(0).size() == currLsLs.get(0).size() + 1) {
                                if (nextLsLs.size() == 0) {
                                    q.offer(next);
                                    map.put(next, nextLsLs);
                                }


                                Iterator<List<String>> it = currLsLs.iterator();
                                while (it.hasNext()) {
                                    List<String> tempLs = new LinkedList<>(it.next());
                                    tempLs.add(next);
                                    nextLsLs.add(tempLs);
                                }
                            }
                        }
                    } //for j
                    s[i] = c;
                } // for i
            } // for k


        } //while
        return map.getOrDefault(endWord, new LinkedList<>());
    }



}
