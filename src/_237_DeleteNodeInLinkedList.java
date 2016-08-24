/**
 * Created by Shengwei_Wang on 8/24/16.
 */
public class _237_DeleteNodeInLinkedList {
    public void deleteNode(ListNode node){
        if (node.next == null)
            return;
        while(node.next.next != null){
            node.val = node.next.val;
            node = node.next;
        }
        node.val = node.next.val;
        node.next = null;
    }
}
