import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Created by Shengwei_Wang on 9/14/16.
 */
public class _286_WallsAndGates {
    public void wallsAndGates(int[][] rooms) {
        Queue<Integer> x = new ArrayDeque<>();
        Queue<Integer> y = new ArrayDeque<>();
        for(int i = 0; i < rooms.length; ++i)
            for(int j = 0; j < rooms[0].length; ++j)
                if(rooms[i][j] == 0){
                    x.offer(i);
                    y.offer(j);
                }
        while(x.size()!=0){
            int i = x.poll();
            int j = y.poll();
            int cur = rooms[i][j] + 1;
            if(i > 0 && cur < rooms[i-1][j]) {
                rooms[i-1][j] = cur;
                x.offer(i-1);
                y.offer(j);
            }
            if(i < rooms.length-1 && cur < rooms[i+1][j]) {
                rooms[i+1][j] = cur;
                x.offer(i+1);
                y.offer(j);
            }
            if(j > 0 && cur < rooms[i][j-1]) {
                rooms[i][j-1] = cur;
                x.offer(i);
                y.offer(j-1);
            }
            if(j < rooms[0].length-1 && cur < rooms[i][j+1]) {
                rooms[i][j+1] = cur;
                x.offer(i);
                y.offer(j+1);
            }
        }
    }
}
