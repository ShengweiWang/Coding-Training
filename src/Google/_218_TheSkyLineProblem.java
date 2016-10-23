package Google;

import java.util.*;

/**
 * Created by Shengwei_Wang on 10/15/16.
 */
public class _218_TheSkyLineProblem {
    public List<int[]> getSkyline(int[][] buildings) {
        List<int[]> height = new LinkedList<>();
        List<int[]> ans = new LinkedList<>();
        for(int i = 0; i < buildings.length; ++i){
            height.add(new int[]{buildings[i][0], buildings[i][2]});
            height.add(new int[]{buildings[i][1], -buildings[i][2]});
        }
        Collections.sort(height,(a, b) -> {
            if(a[0] != b[0])
                return a[0] - b[0];
            else
                return b[1] - a[1];
        });
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> (b - a));
        int lastHeight = 0;
        pq.offer(0);
        for(int[] cur : height){
            if(cur[1] > 0)
                pq.offer(cur[1]);
            else
                pq.remove(-cur[1]);
            if (lastHeight != pq.peek()) {
                lastHeight = pq.peek();
                ans.add(new int[]{cur[0], lastHeight});
            }
        }
        return ans;
    }
}
