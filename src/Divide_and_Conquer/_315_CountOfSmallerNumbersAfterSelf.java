package Divide_and_Conquer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Shengwei_Wang on 10/13/16.
 */
public class _315_CountOfSmallerNumbersAfterSelf {
    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        List<Integer> ans = new LinkedList<>();
        if(n < 1)
            return new LinkedList<>();
        int[] index = new int[n];
        int[] helper = new int[n];
        int[] count = new int[n];

        for(int i = 0; i < n; ++i)
            index[i] = i;
        merge(0, n - 1, nums, index, helper, count);

        for(int i = 0; i < n; ++i)
            ans.add(count[i]);
        return ans;

    }

    void merge(int l, int r, int[] nums, int[] index, int[] helper, int[] count){
        if (l == r)
            return;
        int mid = l + (r - l) /2;

        merge(l, mid, nums, index, helper, count);
        merge(mid + 1, r, nums, index, helper, count);

        int j = mid + 1;
        int k = l;
        for(int i = l; i <= mid; ++i){
            while(j <= r && nums[index[i]] > nums[index[j]])
                helper[k++] = index[j++];
            count[index[i]] += (j - mid - 1);
            helper[k++] = index[i];
        }

        while (k <= r)
            helper[k++] = index[j++];

        for(k = l; k <= r; ++k)
            index[k] = helper[k];

    }

}
