/**
 * Created by Shengwei_Wang on 9/21/16.
 */
public class _25_ReverseNodesInK_Group {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(k < 2)
            return head;
        ListNode pre = null;
        ListNode headn = head;
        while(headn != null) {
            // System.out.println(heaxdn.val);
            ListNode cur = headn;
            int count = 1;
            while(count < k && cur.next != null) {
                cur = cur.next;
                ++count;
            }
            if( count < k)
                break;
            ListNode tailn = cur;
            ListNode succNext = tailn.next;
            if(pre == null) {
                head = tailn;
            } else {
                pre.next = tailn;
            }
            // System.out.println(headn.val + " " + tailn.val);
            cur = headn;
            while(cur != tailn){
                ListNode temp = cur.next;
                cur.next = succNext;
                succNext = cur;
                cur = temp;
            }
            tailn.next = succNext;
            pre = headn;
            headn = headn.next;
        }
        return head;
    }
}
