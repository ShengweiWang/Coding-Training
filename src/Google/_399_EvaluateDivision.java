package Google;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Shengwei_Wang on 10/21/16.
 */
public class _399_EvaluateDivision {
    Map<String, Node> map;
    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        map = new HashMap<>();
        for (int i = 0; i < equations.length; ++i) {
            map.putIfAbsent (equations[i][0], new Node());
            map.putIfAbsent (equations[i][1], new Node());
            Node node1 = map.get(equations[i][0]);
            Node node2 = map.get(equations[i][1]);
            if (find(node1) != find(node2))
                union(node1, node2, values[i]);
        } // for i
        double[] ans = new double[queries.length];
        for (int i = 0; i < queries.length; ++i) {
            Node node1 = map.getOrDefault(queries[i][0], null);
            Node node2 = map.getOrDefault(queries[i][1], null);
            if (node1 == null || node2 == null || find(node1) != find(node2))
                ans[i] = -1;
            else
                ans[i] = node1.value / node2.value;
        }//for i
        return ans;
    } // calc
    public void union (Node node1, Node node2, double value) {
        Node node1_father = find(node1);
        Node node2_father = find(node2);
        node2_father.father = node1_father;
        node2_father.value = node1.value / node2.value / value;
    }
    Node find (Node node1) {
        if (node1.father == node1)
            return node1;
        Node newFather = find(node1.father);
        node1.value *= node1.father.value;
        node1.father = newFather;
        return newFather;
    }
    class Node {
        double value;
        Node father;
        public Node() {
            this.father = this;
            value = 1;
        }
    }
}



//    Map<String, Node> map;
//    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
//        map = new HashMap<>();
//        Node node1;
//        Node node2;
//        for (int i = 0; i < equations.length; ++i) {
//            if (map.containsKey(equations[i][0]))
//                node1 = map.get(equations[i][0]);
//            else {
//                node1 = new Node(equations[i][0]);
//                map.put(equations[i][0], node1);
//            }
//
//            if (map.containsKey(equations[i][1]))
//                node2 = map.get(equations[i][1]);
//            else {
//                node2 = new Node(equations[i][1]);
//                map.put(equations[i][1], node2);
//            }
//
//            if (find(node1) != find(node2))
//                union(node1, node2, values[i]);
//        }
//        double[] ans = new double[queries.length];
//        for (int i = 0 ; i < queries.length; ++i) {
//            node1 = map.getOrDefault(queries[i][0], null);
//            node2 = map.getOrDefault(queries[i][1], null);
//            if (node1 == null || node2 == null || find(node1) != find(node2))
//                ans[i] = -1.0;
//            else {
//                ans[i] = node1.father.path.get(node1) / node2.father.path.get(node2);
//            }
//        }
//        return ans;
//    }
//
//    public Node find(Node curr) {
//        Node formerFather = curr.father;
//        if (formerFather == curr)
//            return curr;
//        else {
//            Node newFather = find(formerFather);
//            newFather.path.put(curr, newFather.path.get(formerFather) * formerFather.path.get(curr));
//            curr.father = newFather;
//            return newFather;
//        }
//    }
//
//    public void union(Node node1, Node node2, double value) {
//        Node node1_father = find(node1);
//        Node node2_father = find(node2);
//        node1_father.path.put(node2_father, node1_father.path.get(node1) / node2_father.path.get(node2) / value);
//        node2_father.father = node1_father;
//    }
//
//    class Node{
//        String name;
//        Map<Node, Double> path;
//        Node father;
//        public Node(String name) {
//            this.name = name;
//            father = this;
//            path = new HashMap<>();
//            path.put(this, 1.0);
//        }
//    }
