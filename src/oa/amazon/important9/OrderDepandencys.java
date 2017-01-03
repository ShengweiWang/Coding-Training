package oa.amazon.important9;

import java.util.*;

/**
 * Created by Shengwei_Wang on 12/31/16.
 */
public class OrderDepandencys {
    public static List<Order> orderDependency (List<OrderDependency> dependcies) {
        Map<Order, Integer> in_degree = new HashMap<Order, Integer>();
        Map<Order, List<Order>> sub = new HashMap<Order, List<Order>>();
        Set<String> dup = new HashSet<String>();
        for (OrderDependency dependency : dependcies) {
            String duptest = "" + dependency.dependent.toString() + dependency.independent.toString();
            if (dup.contains(duptest))
                continue;
            else
                dup.add(duptest);
            in_degree.put(dependency.dependent, in_degree.getOrDefault(dependency.dependent, 0) + 1);
            in_degree.put(dependency.independent, in_degree.getOrDefault(dependency.independent, 0));
            if (!sub.containsKey(dependency.independent))
                sub.put(dependency.independent, new LinkedList<Order>());
            sub.get(dependency.independent).add(dependency.dependent);
        }

        Queue<Order> q = new LinkedList<Order>();
        List<Order> ans = new LinkedList<Order>();
        for (Order cur : in_degree.keySet()) {
            if (in_degree.get(cur) == 0)
                q.offer(cur);
        }

        while (!q.isEmpty()) {
            Order cur = q.poll();
            List<Order> list = sub.get(cur);
            if (list == null)
                continue;
            for (Order next : list) {
                in_degree.put(next, in_degree.get(next) - 1);
                if (in_degree.get(next) == 0)
                    q.offer(next);
            }
        }

        if (ans.size() == in_degree.size())
            return ans;
        else
            return null;

    }

    class Order {
        String name;
        public Order (String name) {
            this.name = name;
        }
        @Override
        public String toString() {
            return name;
        }
    }


    class OrderDependency {
        Order independent;
        Order dependent;
        public OrderDependency (Order independent, Order dependent) {
            this.independent = independent;
            this.dependent = dependent;
        }
    }
}
