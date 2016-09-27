package linkedlist;

/**
 * Created by Shengwei_Wang on 9/26/16.
 */
public class _19_RemoveNthNodeFromEndOfList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode cur = head;
        int k = 0;
        while(cur != null){
            ++k;
            cur = cur.next;
        }
        if(n == k)
            return head.next;
        cur = head;
        while(n + 1 < k){
            cur = cur.next;
            ++n;
        }
        cur.next = cur.next.next;
        return head;
    }
}
