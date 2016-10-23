package Divide_and_Conquer;

/**
 * Created by Shengwei_Wang on 10/9/16.
 */
public class _53_MaximumSubarray {
    public int maxSubArray(int[] nums) {
        if(nums.length == 0)
            return 0;
        ArrayContext res = divideConquer(nums, 0, nums.length - 1);
        return res.max;
    }

    public ArrayContext divideConquer(int[] nums, int l, int r){
        ArrayContext res = new ArrayContext();
        if (l == r){
            res.max = nums[l];
            res.lmax = nums[l];
            res.rmax = nums[l];
            res.sum = nums[l];
        } else {
            int m = l + (r - l) / 2;
            ArrayContext lc = divideConquer(nums, l , m);
            ArrayContext rc = divideConquer(nums, m + 1, r);
            res.max = Math.max(Math.max(lc.max, rc.max), lc.rmax + rc.lmax);
            res.lmax = Math.max(lc.lmax, lc.sum + rc.lmax);
            res.rmax = Math.max(rc.rmax, rc.sum + lc.rmax);
            res.sum = lc.sum + rc.sum;
        }
        return res;
    }

    public class ArrayContext {
        int max;
        int lmax;
        int rmax;
        int sum;
    }
}
