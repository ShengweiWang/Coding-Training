import java.util.HashSet;
import java.util.Set;

/**
 * Created by Shengwei_Wang on 8/24/16.
 */
public class _349_IntersectionOfTwoArrays {
    public int[] intersection(int[] nums1, int[] nums2){
        Set<Integer> s = new HashSet<Integer>();
        Set<Integer> intersection = new HashSet<Integer>();
        for(int i: nums1){
            s.add(i);
        }
        for(int i: nums2){
            if(s.contains(i))
                intersection.add(i);
        }
        int[] ans = new int[intersection.size()];
        int i = 0;
        for(int x:intersection){
            ans[i++] = x;
        }
        return ans;
    }
}
