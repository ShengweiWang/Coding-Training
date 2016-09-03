/**
 * Created by Shengwei_Wang on 9/3/16.
 */
public class _141_LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        if(head == null)
            return false;
        ListNode slow = head;
        ListNode fast = head.next;
        while(slow != null && fast != null){
            slow = slow.next;
            if(fast.next == null)
                return false;
            else
                fast = fast.next.next;
            if(slow == fast)
                return true;
        }
        return false;
    }
}
