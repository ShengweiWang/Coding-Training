package Google;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * Created by Shengwei_Wang on 11/1/16.
 */
public class _451_SortCharactersByFrequency {
    public String frequencySort(String s) {
        int[] f = new int[512];
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); ++i){
            set.add(s.charAt(i));
            ++f[s.charAt(i)];
        }
        PriorityQueue<Character> pq = new PriorityQueue<>((a,b)->(f[b] -f[a]));
        for (char ch : set) {
            pq.offer(ch);
        }
        StringBuilder sb = new StringBuilder();
        while (pq.size() > 0) {
            char c = pq.poll();
            for (int i = 0; i < f[c]; ++i)
                sb.append(c);
        }
        return sb.toString();
    }
}
