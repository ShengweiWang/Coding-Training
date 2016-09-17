/**
 * Created by Shengwei_Wang on 9/17/16.
 */
public class _327_CountOfRangeSum {
    int count;
    int[] index;
    long[] sums;
    int[] temp;
    int lower;
    int upper;
    public int countRangeSum(int[] nums, int lower, int upper) {
        if(nums.length == 0)
            return 0;
        this.lower = lower;
        this.upper = upper;
        count = 0;
        sums = new long[nums.length + 1];
        temp = new int[nums.length + 1];
        index = new int[nums.length + 1];
        sums[0] = 0;
        for(int i = 0; i < nums.length; ++i){
            sums[i + 1] = sums[i] + nums[i];
            index[i] = i;
        }
        index[nums.length] = nums.length;
        merge(0, nums.length); //sort index from 0 to nums.length
        return count;
    }

    void merge(int l, int r){
        if(l >= r)
            return;
        int mid = l + (r - l)/2;
        merge(l, mid);
        merge(mid + 1, r);
        //count
        int jl = mid + 1;//first available j
        int jh = mid + 1;//first unavailable j
        for(int i = l; i <= mid; ++i){
            while(jl <= r && sums[index[jl]] - sums[index[i]] < lower)
                ++jl;
            while(jh <= r && sums[index[jh]] - sums[index[i]] <= upper)
                ++jh;
            if(jl > r)
                break;
            count+= jh - jl;
        }

        //merge
        int ind = l;
        int j = mid + 1;
        for(int i = l; i <= mid; ++i){
            while(j <= r && sums[index[i]] > sums[index[j]]){
                temp[ind] = index[j];
                ++ind;
                ++j;
            }
            temp[ind] = index[i];
            ++ind;
        }
        for(int i = l; i < ind; ++i)
            index[i] = temp[i];
    }
}
