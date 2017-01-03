package Google;

/**
 * Created by Shengwei_Wang on 10/27/16.
 */
public class _308_ {
    public static void main (String[] argv) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8};
        _308_ solution = new _308_(nums);
        for (int i = -1; i < nums.length; ++i)
            System.out.println(solution.sum(i));
    }
        int[] tree;
    int n;
    int pow;
    public _308_ (int[] nums) {
        n = nums.length;
        if (n == 0)
            return;
        pow = 1;
        while (pow < n) {
            pow *= 2;
        }
        --pow;
        tree = new int[pow + n];
        for (int i = 0; i < n; ++i) {
            update (i, nums[i]);
        }
    }
    void update (int i, int val) {
        i += pow;
        int delta = val - tree[i];
        for ( ; i >= 0; i = (i - 1) >> 1) {
            tree[i] += delta;
        }
    }


    public int sumRange (int i, int j) {
        return sum(j) - sum(i - 1);
    }


    public int sum (int i) {
        if (i < 0)
            return 0;
        i += pow;
        int ans = tree[i];
        for (; i > 0; i = (i - 1) >> 1) {
            if ((i & 1) == 0)
                ans += tree[i - 1];
        }
        return ans;
    }
    }

