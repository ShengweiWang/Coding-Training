import java.util.Arrays;

/**
 * Created by Shengwei_Wang on 9/21/16.
 */
public class _164_MaximumGap {
    public int maximumGap(int[] nums) {
        if(nums.length < 2)
            return 0;
        int maxn = Integer.MIN_VALUE;
        int minn = Integer.MAX_VALUE;
        for(int num : nums) {
            maxn = Math.max(maxn, num);
            minn = Math.min(minn, num);
        }
        if (maxn == minn)
            return 0;
        int n = nums.length;
        int inter = (int)Math.ceil((double)(maxn - minn)/(nums.length - 1));
        int [] max = new int[n + 1];
        int [] min = new int[n + 1];
        int ans = 0;
        Arrays.fill(max , Integer.MIN_VALUE);
        Arrays.fill(min , Integer.MAX_VALUE);
        for(int i = 0; i < n; ++i){
            int index = (int) (((long) nums[i] - (long) minn) / inter);
            max[index] = Math.max(max[index], nums[i]);
            min[index] = Math.min(min[index], nums[i]);
            ans = Math.max(ans, max[index] - min[index]);
        }
        int l = 0;
        while(max[l] == Integer.MIN_VALUE)
            ++l;
        int r = l + 1;
        while(r <= n){
            while(r <= n && max[r] == Integer.MIN_VALUE)
                ++r;
            if(r > n)
                break;
            ans = Math.max(ans, min[r] - max[l]);
            l = r;
            ++r;
        }
        return ans;

    }
}
