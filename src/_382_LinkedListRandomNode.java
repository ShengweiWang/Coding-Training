import java.util.Random;

/**
 * Created by Shengwei_Wang on 8/22/16.
 */
public class _382_LinkedListRandomNode {

    Random random;
    ListNode head;
    public _382_LinkedListRandomNode(ListNode head) {
        this.head = head;
        this.random = new Random();
    }

    public int getRandom(){
        ListNode cur = head;
        ListNode result = head;
        for (int i = 1; cur!= null; ++i){
            if (random.nextInt(i) == 0) {
                result = cur;
            }
            cur = cur.next;
        }
        return result.val;
    }
}
