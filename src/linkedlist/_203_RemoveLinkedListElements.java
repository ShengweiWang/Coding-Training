package linkedlist;

/**
 * Created by Shengwei_Wang on 9/27/16.
 */
public class _203_RemoveLinkedListElements {
    public ListNode removeElements(ListNode head, int val) {
        ListNode cur = head;
        ListNode pre = null;
        while(cur != null){
            if(cur.val == val) {
                if(pre == null)
                    head = cur.next;
                else
                    pre.next = cur.next;
            } else
                pre = cur;
            cur = cur.next;
        }
        return head;
    }
}
