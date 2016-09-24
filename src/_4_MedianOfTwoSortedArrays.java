/**
 * Created by Shengwei_Wang on 8/28/16.
 */
public class _4_MedianOfTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length > nums2.length){
            int[] temp = nums2;
            nums2 = nums1;
            nums1 = temp;
        }
        int n = nums1.length;
        int m = nums2.length;
        int il = 0;
        int ir = n;

        while(il <= ir){
            int i = (il + ir) >> 1;
            int j = (m + n + 1) / 2 - i;
            if(i > 0 && j < m && nums1[i-1] > nums2[j])
                ir = i - 1;
            else if (i < n && j > 0 && nums2[j-1] > nums1[i])
                il = i + 1;
            else {
                int max_of_left;
                if (i == 0)
                    max_of_left = nums2[j-1];
                else if (j == 0)
                    max_of_left = nums1[i-1];
                else
                    max_of_left = Math.max(nums1[i-1], nums2[j-1]);

                if ((m + n) % 2 == 1)
                    return max_of_left;

                int min_of_right;
                if (i == n)
                    min_of_right = nums2[j];
                else if (j == m)
                    min_of_right = nums1[i];
                else
                    min_of_right = Math.min(nums1[i], nums2[j]);

                return (max_of_left + min_of_right)/2.0;
            }


        }
        return 0;

    }

}
