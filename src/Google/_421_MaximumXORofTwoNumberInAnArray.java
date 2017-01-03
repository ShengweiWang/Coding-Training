package Google;

/**
 * Created by Shengwei_Wang on 11/10/16.
 */
public class _421_MaximumXORofTwoNumberInAnArray {
    class TrieNode {
        TrieNode[] a;
        public TrieNode () {
            a = new TrieNode[2];
        }
    }
    public int findMaximumXOR(int[] nums) {
        int max = 0;
        TrieNode root = new TrieNode();
        for (int num : nums) {
            TrieNode curr = root;
            TrieNode find = root;
            int temp = 0;
            for (int i = 30; i >=0; --i) {
                int digit = ((num >> i) & 1);
                if (find != null) {
                    if (find.a[1 - digit] != null ) {
                        temp |= (1 << i);
                        find  = find.a[1 - digit];
                    } else
                        find = find.a[digit];
                }
                if (curr.a[digit] == null )
                    curr.a[digit] = new TrieNode();
                curr = curr.a[digit];
            }
            max = Math.max(max, temp);
        }
        return max;

    }
}
