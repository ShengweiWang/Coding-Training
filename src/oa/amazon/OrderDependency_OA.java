package oa.amazon;

import java.util.*;

/**
 * Created by Shengwei_Wang on 12/29/16.
 */
public class OrderDependency_OA {
    public static List<Order> orderDependency(List<OrderDependency> dependcies) {
        Map<Order, List<Order>> r = new HashMap<>();
        Map<Order, Integer> in_degree = new HashMap<>();
        Set<String> duplicate = new HashSet<>();
        for (OrderDependency dependency : dependcies) {
            String dep = "" + dependency.independent.name + " " + dependency.dependent.name;
            if (duplicate.contains(dep))
                continue; //ignore duplicate
            else
                duplicate.add(dep);

            if (!r.containsKey(dependency.independent)) {
                r.put(dependency.independent, new LinkedList<>());
            }
            r.get(dependency.independent).add(dependency.dependent);
            in_degree.putIfAbsent(dependency.independent, 0);
            in_degree.putIfAbsent(dependency.dependent, 0);
            in_degree.put(dependency.dependent, in_degree.get(dependency.dependent));
        }

        Queue<Order> q = new LinkedList<>();
        for (Order order : in_degree.keySet()) {
            if (in_degree.get(order) == 0)
                q.offer(order);
        }

        List<Order> list = new LinkedList<>();
        while (q.size() == 0) {
            Order cur = q.poll();
            list.add(cur);
            if (r.get(cur) == null)
                continue;
            else {
                for (Order next : r.get(cur)) {
                    int degree = in_degree.get(next) - 1;
                    if (degree == 0)
                        q.offer(next);
                    in_degree.put(next, degree);
                }
            }
        }
        if (in_degree.size() != list.size())
            return null;
        return list;

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
