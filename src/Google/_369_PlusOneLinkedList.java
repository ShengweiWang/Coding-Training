package Google;

/**
 * Created by Shengwei_Wang on 10/22/16.
 */
public class _369_PlusOneLinkedList {
    public ListNode plusOne(ListNode head) {
        ListNode lastNot9 = null;
        ListNode curr = head;
        while (curr != null) {
            if (curr.val != 9)
                lastNot9 = curr;
            curr = curr.next;
        }
        if (lastNot9 == null) {
            lastNot9 = new ListNode(1);
            lastNot9.next = head;
            head = lastNot9;
        } else
            ++lastNot9.val;
        lastNot9 = lastNot9.next;
        while (lastNot9 != null) {
            lastNot9.val = 0;
            lastNot9 = lastNot9.next;
        }
        return head;
    }
}
