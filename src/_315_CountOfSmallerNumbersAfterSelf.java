import java.util.ArrayList;
import java.util.List;

/**
 * Created by Shengwei_Wang on 9/17/16.
 */
public class _315_CountOfSmallerNumbersAfterSelf {
    int[] count;
    int[] index;
    int[] temp;
    int[] nums;
    public List<Integer> countSmaller(int[] nums) {
        count = new int[nums.length];
        index = new int[nums.length];
        temp = new int[nums.length];
        this.nums = nums;
        for(int i = 0; i < nums.length; ++i)
            index[i] = i;
        merge(0, nums.length - 1);
        List<Integer> res = new ArrayList<>();
        for(int i = 0; i < nums.length; ++i)
            res.add(count[i]);
        return res;
    }
    void merge(int l , int r){
        if(l >= r)
            return;
        int mid = l + (r - l)/2;
        merge(l , mid);
        merge(mid + 1 , r);
        int ind = l;
        int j = mid + 1;
        for(int i = l; i <= mid; ++i){
            while(j <= r && nums[index[i]] > nums[index[j]]){
                temp[ind] = index[j];
                ++ind;
                ++j;
            }
            count[index[i]] += j - (mid + 1);
            temp[ind] = index[i];
            ++ind;
        }
        for(int i = l; i < ind; ++i)
            index[i] = temp[i];
    }
}
