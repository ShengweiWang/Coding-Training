/**
 * Created by Shengwei_Wang on 9/3/16.
 */
public class _24_SwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null)
            return head;

        ListNode cur = head;
        head = head.next;
        cur.next = head.next;
        head.next = cur;

        while(cur.next != null && cur.next.next != null){
            ListNode temp = cur.next;
            cur.next = cur.next.next;
            temp.next = cur.next.next;
            cur.next.next = temp;
            cur = temp;
        }
        return head;
    }
}
