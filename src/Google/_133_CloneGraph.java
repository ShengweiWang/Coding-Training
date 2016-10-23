package Google;

import java.util.*;

/**
 * Created by Shengwei_Wang on 10/18/16.
 */
public class _133_CloneGraph {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null)
            return null;
        Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
        Queue<UndirectedGraphNode> q = new LinkedList<>();
        Set<UndirectedGraphNode> visited = new HashSet<>();
        q.offer(node);
        visited.add(node);
        while (q.size() > 0) {
            UndirectedGraphNode curr = q.poll();
            UndirectedGraphNode newCurr;
            if (map.containsKey(curr))
                newCurr = map.get(curr);
            else {
                newCurr = new UndirectedGraphNode(curr.label);
                map.put(curr, newCurr);
            }

            for (UndirectedGraphNode neighbor : curr.neighbors) {

                if (!visited.contains(neighbor)) {    //next layer
                    q.offer(neighbor);
                    visited.add(neighbor);
                }

                UndirectedGraphNode newNeighbor;           //copy neighbor
                if (map.containsKey(neighbor))
                    newNeighbor = map.get(neighbor);
                else {
                    newNeighbor = new UndirectedGraphNode(neighbor.label);
                    map.put(neighbor, newNeighbor);
                }
                newCurr.neighbors.add(newNeighbor);        //add neighbor

            }
        }
        return map.get(node);
    }
}
