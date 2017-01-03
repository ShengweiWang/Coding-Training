package Google;

import java.util.Arrays;

/**
 * Created by Shengwei_Wang on 11/9/16.
 */
public class _324_WiggleSortII {
    public void wiggleSort_easy(int[] nums) {
        int[] sorted = nums.clone();
        int n = nums.length;
        Arrays.sort(sorted);
        int l = 1;
        int i = n - 1;
        while (l < n) {
            nums[l] = sorted[i];
            --i;
            l = l + 2;
        }
        l = 0;
        while ( l < n) {
            nums[l] = sorted[i];
            --i;
            l = l + 2;
        }
    } //wiggleSort


    int n;
    public void wiggleSort_virture(int[] nums) {
        n = nums.length;
        int mid = findk(nums, n / 2);
        int i = 0;
        int j = 0;
        int k = n - 1;
        while (j <= k) {
            if (nums[a(j)] > mid)
                swap(nums, a(j++), a(i++));
            else if (nums[a(j)] < mid)
                swap(nums, a(j), a(k--));
            else
                ++j;
        }
    }
    public void wiggleSort(int[] nums) {
        n = nums.length;
        int mid = findk(nums, n / 2);
        int j = 1;
        int i = 1;
        int k = (n % 2 == 0)?n - 2:n - 1;
        for (int count = 0; count < n; ++count) {
            if (j >= n)
                j = 0;
            if (i >= n)
                i = 0;
            if (k < 0)
                k = (n % 2 == 0)?n - 1:n - 2;
            if (nums[j] > mid) {
                swap(nums, i, j);
                i += 2;
                j += 2;
            } else if (nums[j] < mid) {
                swap(nums, j, k);
                k -= 2;
            } else
                j += 2;
        }
    }
    void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    int a(int i) {
        if (i < n / 2)
            return i * 2 + 1;
        else
            return (i - n / 2) * 2;
    }
    int findk(int [] nums, int k) {
        int l = 0;
        int r = nums.length - 1;
        if (k < l || k > r)
            return -1;
        while (true) {
            int i = l;
            int j = r;
            int x = nums[r];
            while (i < j) {
                while (i < j && nums[i] < x)
                    ++i;
                while (i < j && nums[j] >= x)
                    --j;
                swap(nums, i, j);
            }
            swap (nums, i, r);
            if (i == k)
                return x;
            else if (i > k)
                r = i - 1;
            else
                l = i + 1;
        } // while
    }// findk
}
