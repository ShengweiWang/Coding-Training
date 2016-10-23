package Google;

/**
 * Created by Shengwei_Wang on 10/15/16.
 */
public class _4_MedianOfTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
        }
        int n = nums1.length;
        int m = nums2.length;
        int l = 0;
        int r = n;
        while(true){
            int i = l + (r - l) / 2;
            int j = (n + m + 1) / 2 - i;
            if (i > 0 && nums1[i - 1] > nums2[j])
                r = i;
            else if (i < n && nums1[i] < nums2[j - 1])
                l = i + 1;
            else {

                double max_of_left = Math.max(i == 0 ? Integer.MIN_VALUE : nums1[i - 1],
                        j == 0 ? Integer.MIN_VALUE : nums2[j - 1]);

                if ((m + n) % 2 == 1)
                    return max_of_left;

                max_of_left += Math.min(i == n ? Integer.MAX_VALUE : nums1[i],
                        j == m ? Integer.MAX_VALUE : nums2[j]);

                return max_of_left / 2;

            }
        }

    }
}
