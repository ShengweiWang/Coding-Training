package linkedlist;

/**
 * Created by Shengwei_Wang on 9/26/16.
 */
public class _234_PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        int k = 0;
        ListNode cur = head;
        while(cur != null){
            cur = cur.next;
            ++k;
        }
        cur = head;
        for(int i = 0 ; i < k/2; ++i)
            cur = cur.next;
        ListNode mid = cur;
        ListNode pre = cur;
        while(cur != null){
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        cur = head;
        while(cur != mid){
            if(pre.val != cur.val)
                return false;
            pre = pre.next;
            cur = cur.next;
        }
        return true;
    }
}
