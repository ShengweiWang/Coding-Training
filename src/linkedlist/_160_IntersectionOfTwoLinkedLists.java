package linkedlist;

/**
 * Created by Shengwei_Wang on 9/27/16.
 */
public class _160_IntersectionOfTwoLinkedLists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null)
            return null;
        ListNode a = headA;
        ListNode b = headB;
        while(a != b){
            a = a == null?headB:a.next;
            b = b == null?headA:b.next;
        }
        return a;
    }
}
