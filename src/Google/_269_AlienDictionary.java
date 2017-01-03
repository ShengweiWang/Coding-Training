package Google;

import java.util.*;

/**
 * Created by Shengwei_Wang on 10/30/16.
 */
public class _269_AlienDictionary {
        public String alienOrder(String[] words) {
            Map<Character, Set<Character>> smallerThan = new HashMap<>();
            Map<Character, Integer> degree = new HashMap<>();   //number of larger
            String prec = "";
            for (String s : words ){
                boolean needCompare = true;

                for (int i = 0; i < s.length(); ++i) {
                    char c = s.charAt(i);
                    degree.put(c, degree.getOrDefault(c, 0));
                    if (smallerThan.containsKey(c)) {
                        smallerThan.put(c, new HashSet<>());
                    }
                    if (needCompare) {
                        if (i >= prec.length()) {
                            needCompare = false;
                        } else if (prec.charAt(i) != c && !smallerThan.get(prec.charAt(i)).contains(c) ) {
                            smallerThan.get(prec.charAt(i)).add(c);
                            degree.put(c, degree.get(c) + 1);
                            needCompare = false;
                        }
                    }
                }
            }

            Queue<Character> q = new LinkedList<>();
            for (char c : degree.keySet() ) {
                if (degree.get(c) == 0)
                    q.offer(c);
            }
            StringBuilder sb = new StringBuilder();
            while (q.size() > 0) {
                char c = q.poll();
                sb.append(c);
                for (char sc : smallerThan.get(c)) {
                    int k = degree.get(sc) - 1;
                    if (k == 0)
                        q.offer(sc);
                    degree.put(sc, k);
                }
            }
            return sb.toString();
        }



}
