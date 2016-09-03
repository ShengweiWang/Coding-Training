import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

/**
 * Created by Shengwei_Wang on 9/3/16.
 */
public class _138_CopyListWithRandomPointer {
    public class RandomListNode{
        int label;
        RandomListNode next, random;
        RandomListNode(int x) { this.label = x;}
    }
    public RandomListNode copyRandomList(RandomListNode head) {
        RandomListNode cur = head;
        while(cur != null){
            RandomListNode ins = new RandomListNode(cur.label);
            ins.next = cur.next;
            cur.next = ins;
            cur = ins.next;
        }
        cur = head;
        while(cur != null){
            cur.next.random = cur.random.next;
            cur = cur.next.next;
        }
        cur = head.next;
        while(cur.next != null){
            cur.next = cur.next.next;
            cur = cur.next;
        }
        return head.next;
    }
}
