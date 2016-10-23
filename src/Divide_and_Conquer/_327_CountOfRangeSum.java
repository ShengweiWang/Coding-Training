package Divide_and_Conquer;

/**
 * Created by Shengwei_Wang on 10/13/16.
 */
public class _327_CountOfRangeSum {
    public int countRangeSum(int[] nums, int lower, int upper) {
        long[] s = new long[nums.length + 1];
        s[0] = 0;
        for(int i = 0; i < nums.length; ++i)
            s[i + 1] = s[i] + nums[i];

        return merge(0, s.length - 1, s, new long[s.length], lower, upper);

    }

    int merge(int l, int r, long[] s, long[] helper, int lower, int upper) {
        if (l == r)
            return 0;
        int mid = l + (r - l)/2;
        int ans = merge(l, mid, s, helper, lower, upper);
        ans += merge(mid + 1, r, s, helper, lower, upper);

        //count
        int k = l;
        int li = l;
        int ui = l;
        for(int j = mid + 1; j <= r; ++j){
            while(li <= mid && s[j] - s[li] >= lower)
                ++li;
            while(ui <= mid && s[j] - s[ui] > upper)
                ++ui;
            ans += (li - ui);
        }

        //merge
        k = l;
        int j = mid + 1;
        for(int i = l; i <= mid; ++i){
            while(j <= r && s[i] > s[j])
                helper[k++] = s[j++];
            helper[k++] = s[i];
        }
        while(j <= r)
            helper[k ++] = s[j ++];
        k = l;
        while(k <= r){
            s[k] = helper[k];
            ++k;
        }
        return ans;
    }
}
