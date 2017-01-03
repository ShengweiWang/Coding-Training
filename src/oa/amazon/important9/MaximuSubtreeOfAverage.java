package oa.amazon.important9;

import java.util.ArrayList;
import java.util.DoubleSummaryStatistics;

/**
 * Created by Shengwei_Wang on 12/31/16.
 */
public class MaximuSubtreeOfAverage {
    public static Node findMaxTree (Node root) {
        if (root == null || root.children.isEmpty())
            return root;

        return helper(root).maxNode;
    }

    static Result helper (Node root) {
        Result result = new Result(root.val, 1, Double.MIN_VALUE, null);
        if (root.children.isEmpty())
            return result;

        for (Node node : root.children) {
            Result subresult = helper(node);
            result.sum += subresult.sum;
            result.num += subresult.num;
            if (result.maxAvg < subresult.maxAvg) {
                result.maxAvg = subresult.maxAvg;
                result.maxNode = subresult.maxNode;
            }
        }
        if ((double) result.sum / result.num > result.maxAvg) {
            result.maxAvg = (double) result.sum / result.num;
            result.maxNode = root;
        }
        return result;
    }
    static class Result {
        int sum;
        int num;
        double maxAvg;
        Node maxNode;
        public Result(int sum, int num, double maxAvg, Node maxNode) {
            this.sum = sum;
            this.num = num;
            this.maxAvg = maxAvg;
            this.maxNode = maxNode;
        }
    }

    class Node {
        int val;
        ArrayList<Node> children;
        public Node (int val) {
            this.val = val;
            children = new ArrayList<Node>();
        }

        @Override
        public String toString() {
            return val + "";
        }
    }
}
