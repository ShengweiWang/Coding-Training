package Google;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Created by Shengwei_Wang on 11/2/16.
 */
public class _373_FindKPairsWithSmallestSums {
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<int[]> ans = new LinkedList<>();
        if (nums1.length == 0 || nums2.length == 0)
            return ans;

        int[] f = new int[nums1.length];
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->(nums1[a] + nums2[f[a]] - (nums1[b] + nums2[f[b]]))); //store index;
        for (int i = 0; i < Math.min(nums1.length, k); ++i) {
            pq.offer(i);
        }
        for (int i = 0; i < k; ++i) {
            if (pq.size() == 0)
                return ans;
            int j = pq.poll();
            ans.add(new int[]{nums1[j], nums2[f[j]]});
            if (++f[j] < nums2.length)
                pq.offer(j);
        }
        return ans;
    }
}
