package linkedlist;

/**
 * Created by Shengwei_Wang on 9/27/16.
 */
public class _21_MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while(l1 != null || l2 != null){
            if(l1 == null || (l2 != null && l1.val > l2.val)){
                cur.next = l2;
                l2 = l2.next;
            } else {
                cur.next = l1;
                l1 = l1.next;
            }
            cur = cur.next;
        }
        cur.next = null;
        return dummy.next;
    }
}
