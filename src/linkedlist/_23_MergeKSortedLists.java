package linkedlist;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by Shengwei_Wang on 9/27/16.
 */
public class _23_MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> q = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode l1, ListNode l2){
                return Integer.compare(l1.val, l2.val);
            }
        });
        for(int i = 0; i < lists.length;++i){
            if(lists[i] != null)
                q.offer(lists[i]);
        }
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while(q.size()>0){
            ListNode next = q.poll();
            cur.next = next;
            cur = cur.next;
            if(next.next != null)
                q.offer(next.next);
        }
        cur.next = null;
        return dummy.next;
    }
}
