package Google;

import java.util.*;

/**
 * Created by Shengwei_Wang on 11/2/16.
 */
public class _332_ReconstructItinerary {
    Map <String, PriorityQueue<String>> map;
  List<String> ans;
  public List<String> findItinerary(String[][] tickets) {
    map = new HashMap<>();
    for (String[] s : tickets) {
      map.putIfAbsent(s[0], new PriorityQueue<>());
      map.get(s[0]).add(s[1]);
    }
    ans = new LinkedList<>();
    dfs("JFK");
    return ans;
  } // findIt
  void dfs(String s) {
    PriorityQueue<String> pq = map.get(s);
    while (pq != null && !pq.isEmpty())
      dfs(pq.poll());
    ans.add(0, s);
  }
}
