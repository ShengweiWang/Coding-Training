package Google;

import java.util.PriorityQueue;

/**
 * Created by Shengwei_Wang on 10/16/16.
 */
public class _23_MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b) -> (a.val - b.val));
        for(ListNode list : lists) {
            if (list != null) {
                pq.offer(list);
            }
        }
        ListNode head = new ListNode(0);
        ListNode prev = head;
        while (pq.size() > 0){
            ListNode curr = pq.poll();
            prev.next = curr;
            prev = curr;
            if (curr.next != null)
                pq.offer(curr.next);
        }
        prev.next = null;
        return head.next;
    }
}
