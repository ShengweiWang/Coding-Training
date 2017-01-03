package oa.amazon;

import java.util.*;

/**
 * Created by Shengwei_Wang on 12/29/16.
 */
public class cityConnection {
    public static List<Connection> cityConnection(List<Connection> list) {
        Collections.sort(list, (a,b)->(a.cost - b.cost));
        Map<String, String> map = new HashMap<>();
        for (Connection connection : list) {
            map.put(connection.node1, connection.node1);
            map.put(connection.node2, connection.node2);
        }
        List<Connection> ans = new ArrayList<>();
        for (Connection connection : list) {
            String node1father = find(connection.node1, map);
            String node2father = find(connection.node2, map);
            if (node1father.equals(node2father))
                continue;
            else {
                map.put(node1father, node2father);
                ans.add(connection);
            }
        }
        return null;
    }

    public static String find(String s, Map<String, String> map) {

        if (s.equals(map.get(s)))
            return s;
        String father = find(map.get(s), map);
        map.put(s, father);
        return father;

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
