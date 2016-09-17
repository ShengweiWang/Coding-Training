import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Created by Shengwei_Wang on 9/17/16.
 */
public class _296_BestMeetingPoint {
    public int minTotalDistance(int[][] grid) {
        if(grid.length == 0)
            return 0;
        int vertical = 0;
        int horizontal = 0;
        Queue<Integer> qx = new ArrayDeque<Integer>();
        Queue<Integer> qy = new ArrayDeque<Integer>();
        for(int i = 0; i < grid.length; ++i)
            for(int j = 0; j < grid[0].length; ++j){
                if(grid[i][j] == 1){
                    qx.offer(i);
                    qy.offer(j);
                }
            }
        double mid = qx.size() / 2;
        double mindiff = qx.size();
        double currentCount = 0;
        int xx = 0;
        int yy = 0;
        for(int i = 0; i < grid.length; ++i){
            for(int j = 0; j < grid[0].length; ++j){
                if(grid[i][j] == 1){
                    ++currentCount;
                }
            }
            if(currentCount <= mid){
                mindiff = mid - currentCount;
                xx = i;
            } else {
                if(mid - currentCount < mindiff)
                    xx = i;
                break;
            }
        }
        mindiff = qy.size();
        currentCount = 0;
        for(int j = 0; j < grid[0].length; ++j){
            for(int i = 0; i < grid.length; ++i){
                if(grid[i][j] == 1){
                    ++currentCount;
                }
            }
            if(currentCount <= mid){
                mindiff = mid - currentCount;
                yy = j;
            } else {
                if(mid - currentCount < mindiff)
                    yy = j;
                break;
            }
        }
        int sum = 0;
        //System.out.println(xx + "~~" + yy);
        while(qx.size() > 0){
            sum += (Math.abs(qx.poll() - xx) + Math.abs(qy.poll() - yy));
        }
        return sum;
    }
}
