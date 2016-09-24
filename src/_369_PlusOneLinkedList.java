/**
 * Created by Shengwei_Wang on 9/21/16.
 */
public class _369_PlusOneLinkedList {
    public ListNode plusOne(ListNode head) {
        ListNode lastNot9 = null;
        ListNode cur = head;
        while(cur != null){
            if(cur.val != 9)
                lastNot9 = cur;
            cur = cur.next;
        }
        if(lastNot9 == null){
            ListNode newhead = new ListNode(1);
            newhead.next = head;
            head = newhead;
            lastNot9 = head;
        } else {
            ++lastNot9.val;
        }
        cur = lastNot9.next;
        while(cur != null){
            cur.val = 0;
            cur = cur.next;
        }
        return head;
    }
}
