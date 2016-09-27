/**
 * Created by Shengwei_Wang on 9/25/16.
 */
public class _148_SortList {
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null)
            return head;
        ListNode mid = head;
        ListNode cur = head;
        ListNode pre = head;
        while(cur != null && cur.next != null){
            pre = mid;
            mid = mid.next;
            cur = cur.next.next;
        }
        pre.next = null;
        if(head!=null)
            head = sortList(head);
        if(mid != null)
            mid = sortList(mid);
        return merge(head, mid);
    }
    ListNode merge(ListNode h1, ListNode h2){
        if(h1 == null)
            return h2;
        if(h2 == null)
            return h1;
        if(h1.val < h2.val){
            h1.next = merge(h1.next, h2);
            return h1;
        }
        else{
            h2.next = merge(h1, h2.next);
            return h2;
        }
    }
}
