import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Shengwei_Wang on 9/3/16.
 */
public class _350_IntersectionOfTwoArraysII {
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> ans = new ArrayList<Integer>();
        int i = 0;
        int j = 0;
        while(i < nums1.length && j < nums2.length){
            if(nums1[i] == nums2[j]){
                ans.add(nums1[i]);
                ++i;
                ++j;
            } else if (nums1[i] > nums2[j]){
                ++j;
            } else {
                ++i;
            }
        }
        int[] nums = new int[ans.size()];
        for(i = 0; i < ans.size(); ++i)
            nums[i] = ans.get(i);
        return nums;
    }
}
