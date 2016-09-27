package linkedlist;

/**
 * Created by Shengwei_Wang on 9/27/16.
 */
public class _92_ReverseLinkedListII {
    public ListNode reverseBetween(ListNode head, int m, int n) {

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode tail = dummy;

        for(int i = 1; i < m; ++i)
            tail = tail.next;
        ListNode pre = tail;
        ListNode cur = pre.next;
        for(int i = m; i <= n; ++i){
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        tail.next.next = cur;
        tail.next = pre;
        return dummy.next;
    }
}
