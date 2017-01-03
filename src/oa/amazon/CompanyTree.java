package oa.amazon;

import java.util.ArrayList;

/**
 * Created by Shengwei_Wang on 12/29/16.
 */
public class CompanyTree {
    public static Node findMaxTree(Node root) {
        return null;
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
