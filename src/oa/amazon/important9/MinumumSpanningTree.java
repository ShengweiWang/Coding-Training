package oa.amazon.important9;

import java.util.*;

/**
 * Created by Shengwei_Wang on 12/31/16.
 */
public class MinumumSpanningTree {
    public static List<Connection> cityConnection(List<Connection> list) {
        Collections.sort (list, (a,b) -> (a.cost - b.cost));
        Map<String, String> map = new HashMap<String, String>();
        for (Connection connection : list) {
            map.put(connection.node1, connection.node1);
            map.put(connection.node2, connection.node2);
        }
        List<Connection> ans = new LinkedList<>();
        for (Connection connection : list) {
            if (union(map, connection.node1, connection.node2))
                ans.add(connection);
        }

        if (ans.size() != map.size() - 1)
            return null;
        Collections.sort(ans, (a,b) -> {
            if (a.node1.equals(b.node1))
                return a.node2.compareTo(b.node2);
            else
                return a.node1.compareTo(b.node1);
        });
        return ans;
    }

    static boolean union(Map<String, String> map, String node1, String node2) {
        String fa1 = find(map, node1);
        String fa2 = find(map, node2);
        if (fa1.equals(fa2))
            return false;
        map.put(fa2, fa1);
        return true;
    }

    static String find(Map<String, String> map, String node) {
        if (map.get(node).equals(node))
            return node;
        map.put(node, find(map, map.get(node)));
        return map.get(node);
    }

    class Connection {
        String node1;
        String node2;
        int cost;
        public Connection (String a, String b, int c) {
            node1 = a;
            node2 = b;
            cost = c;
        }
    }
}

