package Divide_and_Conquer;

/**
 * Created by Shengwei_Wang on 10/9/16.
 */
public class _4_MedianOfTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            int[] temp = nums2;
            nums2 = nums1;
            nums1 = temp;
        }
        int n = nums1.length;
        int m = nums2.length;
        int il = 0;
        int ir = n;
        while (il <= ir) {
            int i = il + (ir - il) /2;
            int j = (n + m + 1) / 2 - i;
            if(i > 0 && nums1[i-1] > nums2[j])
                ir = i - 1;
            else if (j > 0 && nums2[j-1] > nums1[i])
                il = i + 1;
            else {
                double maxLeft;
                if(i == 0)
                    maxLeft = nums2[j - 1];
                else if (j == 0)
                    maxLeft = nums1[i - 1];
                else
                    maxLeft = Math.max(nums1[i-1], nums2[j - 1]);
                if ( ((n + m) & 1) == 1)
                    return maxLeft;
                double minRight;
                if( i == n)
                    minRight = nums2[j];
                else if (j == m)
                    minRight = nums1[i];
                else
                    minRight = Math.min(nums1[i], nums2[j]);
                return (maxLeft + minRight) / 2;
            }
        }
        return 0;
    }

}
