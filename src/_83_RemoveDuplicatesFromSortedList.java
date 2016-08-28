/**
 * Created by Shengwei_Wang on 8/27/16.
 */
public class _83_RemoveDuplicatesFromSortedList {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode cur = head;
        while(cur != null){
            ListNode next = cur.next;
            while (next != null && next.val == cur.val)
                next = next.next;
            cur.next = next;
            cur = next;
        }
        return head;
    }
}
