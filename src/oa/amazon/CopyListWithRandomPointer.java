package oa.amazon;

/**
 * Created by Shengwei_Wang on 12/29/16.
 */
public class CopyListWithRandomPointer {
    public static RandomListNode copyRandom (RandomListNode root) {
        if (root == null)
            return null;

        RandomListNode head = root;
        while (root != null) {
            RandomListNode copy = new RandomListNode(root.label);
            copy.next = root.next;
            root.next = copy;
        }
        root = head;
        while (root != null) {
            root.next.random = root.random.next;
            root = root.next.next;
        }

        RandomListNode newhead = head.next;
        while (root != null) {
            RandomListNode nextRoot = root.next;
            root.next = nextRoot.next;
            if (nextRoot.next != null)
                nextRoot.next = nextRoot.next.next;
            root = root.next;
        }
        return newhead;
    }

    static class RandomListNode {
        int label;
        RandomListNode next, random;
        RandomListNode (int x) { this.label = x; }
    }
}
