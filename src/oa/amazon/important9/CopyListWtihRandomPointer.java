package oa.amazon.important9;

/**
 * Created by Shengwei_Wang on 12/31/16.
 */
public class CopyListWtihRandomPointer {
    public static RandomListNode copyRandom(RandomListNode root) {
        RandomListNode head = root;
        if (root == null)
            return root;
        while (root != null) { //make copy
            RandomListNode newNode = new RandomListNode(root.label);
            newNode.next = root.next;
            root.next = newNode;
            root = root.next.next;
        }
        while (root != null) {
            if (root.random == null)
                root.next.random = null;
            else
                root.next.random = root.random.next;
            root = root.next.next;
        }

        RandomListNode newHead = head.next;
        RandomListNode newRoot = newHead;
        while (root != null) {
            root.next = newRoot.next;
            if (newRoot.next != null)
                newRoot.next = newRoot.next.next;
            root = root.next;
            newRoot = newRoot.next;
        }
        return newHead;
    }

    static class RandomListNode {
        int label;
        RandomListNode next, random;
        RandomListNode (int x) { this.label = x;}
    }
}


