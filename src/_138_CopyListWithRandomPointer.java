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
        if(head == null)
            return head;
        RandomListNode cur = head;
        while(cur != null){
            RandomListNode ins = new RandomListNode(cur.label);
            ins.next = cur.next;
            cur.next = ins;
            cur = ins.next;
        }
        cur = head;
        while(cur != null){
            if(cur.random == null)
                cur.next.random = null;
            else
                cur.next.random = cur.random.next;
            cur = cur.next.next;
        }
        RandomListNode newhead = head.next;
        cur = head;
        while(cur != null){
            RandomListNode copied = cur.next;
            cur.next = copied.next;
            cur = cur.next;
            if(cur != null)
                copied.next = cur.next;
        }
        return newhead;
    }
}
