import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Shengwei_Wang on 8/24/16.
 */
public class _237_DeleteNodeInLinkedListTest {

    @Test
    public void testDeleteNode() throws Exception {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        ListNode l6 = new ListNode(6);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l6;
        l6.next = null;
        (new _237_DeleteNodeInLinkedList()).deleteNode(l3);
        while(l1 != null){
            System.out.println(l1.val);
            l1 = l1.next;
        }
    }
}