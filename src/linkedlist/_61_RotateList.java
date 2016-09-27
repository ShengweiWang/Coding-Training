package linkedlist;

/**
 * Created by Shengwei_Wang on 9/27/16.
 */
public class _61_RotateList {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0)
            return head;

        int len = 1;
        ListNode tail = head;
        //handle k > len
        while(tail.next != null){
            ++len;
            tail = tail.next;
        }
        k = k % len;
        tail.next = head;
        tail = head;
        ++k;
        while(k < len){
            tail = tail.next;
            ++k;
        }
        head = tail.next;
        tail.next = null;
        return head;
    }
}
