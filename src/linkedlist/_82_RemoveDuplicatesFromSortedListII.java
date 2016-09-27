package linkedlist;

/**
 * Created by Shengwei_Wang on 9/27/16.
 */
public class _82_RemoveDuplicatesFromSortedListII {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode cur = head;
        while(cur != null){
            if(cur.next != null && cur.val == cur.next.val){
                while(cur.next != null && cur.val == cur.next.val)
                    cur = cur.next;
                cur = cur.next;
                continue;
            }
            pre.next = cur;
            pre = cur;
            cur = cur.next;
        }
        pre.next = cur;
        return dummy.next;
    }
}
