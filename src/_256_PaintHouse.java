/**
 * Created by Shengwei_Wang on 9/14/16.
 */
public class _256_PaintHouse {
    public int minCost(int[][] costs) {
        if(costs.length == 0)
            return 0;
        int[][] f = new int[costs.length][3];
        f[0][0] = costs[0][0];
        f[0][1] = costs[0][1];
        f[0][2] = costs[0][2];
        for(int i = 1; i < costs.length; ++i){
            f[i][0] = Math.min(f[i-1][1], f[i-1][2]) + costs[i][0];
            f[i][1] = Math.min(f[i-1][0], f[i-1][2]) + costs[i][1];
            f[i][2] = Math.min(f[i-1][1], f[i-1][0]) + costs[i][2];
        }
        return Math.min(Math.min(f[costs.length-1][0], f[costs.length-1][1]),f[costs.length-1][2]);

    }
}
