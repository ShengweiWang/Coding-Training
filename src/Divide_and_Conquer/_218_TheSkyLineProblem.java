package Divide_and_Conquer;

import java.util.*;

/**
 * Created by Shengwei_Wang on 10/12/16.
 */
public class _218_TheSkyLineProblem {
    public List<int[]> getSkyline(int[][] buildings) {
        List<int[]> height = new LinkedList<>();
        List<int[]> ans = new LinkedList<>();
        for(int i = 0; i < buildings.length; ++i){
            height.add(new int[]{buildings[i][0], buildings[i][2]});
            height.add(new int[]{buildings[i][1], -buildings[i][2]});
        }

        Collections.sort(height, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] != o2[0])
                    return o1[0] - o2[0];
                else
                    return o2[1] - o1[1];
            }
        });

        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o2, o1);
            }
        });
        pq.offer(0);
        Iterator<int[]> it = height.iterator();
        int pre = 0;
        while(it.hasNext()){
            int[] cur = it.next();
            if(cur[1] > 0)
                pq.offer(cur[1]);
            else
                pq.remove(-cur[1]);
            if (pre != pq.peek()){
                ans.add(new int[]{cur[0], pq.peek()});
                pre = pq.peek();
            }
        }

        return ans;
    }
}
