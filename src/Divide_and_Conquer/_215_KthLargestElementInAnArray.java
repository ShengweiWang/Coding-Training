package Divide_and_Conquer;

/**
 * Created by Shengwei_Wang on 10/9/16.
 */
public class _215_KthLargestElementInAnArray {
    void swap(int[] a, int l, int r){
        int temp = a[l];
        a[l] = a[r];
        a[r] = temp;
    }
    public int findKthLargest(int[] nums, int k) {
        if(nums.length == 0)
            return 0;
        int l = 0;
        int r = nums.length - 1;
        int x = nums[0];
        k = nums.length - k;
        while(l < r){
            int i = l;
            int j = r;
            x = nums[r];
            while(i < j){
                while(i < j && nums[i] < x)
                    ++i;
                while(i < j && nums[j] >= x)
                    --j;
                swap(nums, i, j);
            }
            swap(nums, i, r);
            if(i == k)
                return x;
            else {
                if(i < k){
                    l = i + 1;
                } else
                    r = i - 1;
            }
        }
        return nums[l];
    }
}
