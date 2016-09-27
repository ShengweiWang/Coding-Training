package linkedlist;

/**
 * Created by Shengwei_Wang on 9/26/16.
 */
public class _147_InsertionSortList {
    public ListNode insertionSortList(ListNode head) {
        if(head == null)
            return null;
        ListNode next = head.next;
        head.next = null;
        while(next != null){
            ListNode temp = next.next;
            next.next = null;
            if(next.val <= head.val){
                next.next = head;
                head = next;
            } else{
                ListNode prev = head;
                ListNode cur = head.next;
                while(cur != null && next.val > cur.val){
                    prev = cur;
                    cur = cur.next;
                }
                prev.next = next;
                next.next = cur;
            }
            next = temp;
        }
        return head;


//        Better Solution:
//        public ListNode insertionSortList(ListNode head) {
//            if(head == null)
//                return null;
//
//            ListNode dummy = new ListNode(Integer.MIN_VALUE);
//            ListNode cur = head;
//            while(cur != null){
//                ListNode pre = dummy;
//                ListNode arr = dummy.next;
//                ListNode next = cur.next;
//                while(arr != null && arr.val < cur.val){
//                    pre = arr;
//                    arr = arr.next;
//                }
//                cur.next = arr;
//                pre.next = cur;
//                cur = next;
//            }
//            return dummy.next;
//        }
    }
}
