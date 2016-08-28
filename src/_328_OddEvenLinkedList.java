/**
 * Created by Shengwei_Wang on 8/25/16.
 */
public class _328_OddEvenLinkedList {
    public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null)
            return head;
        ListNode first = head;
        ListNode second = head.next;
        ListNode secondHead = second;
        while(second.next != null && second.next.next != null){
            first.next = second.next;
            second.next = second.next.next;
            first = first.next;
            second = second.next;
        }
        first.next = second.next;
        second.next = null;
        if(first.next == null)
            first.next = secondHead;
        else
            first.next.next = secondHead;
        return head;
    }
}
