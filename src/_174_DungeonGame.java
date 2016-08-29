/**
 * Created by Shengwei_Wang on 8/28/16.
 */
public class _174_DungeonGame {
    public int calculateMinimumHP(int[][] dungeon) {
        int [][] f = new int[dungeon.length][dungeon[0].length];
        for(int i = dungeon.length - 1; i >= 0; --i){
            for(int j = dungeon[0].length - 1; j >=0; --j){
                f[i][j] = Integer.MAX_VALUE;
                if(i != dungeon.length - 1){
                    f[i][j] = Math.min(Math.max(1, f[i+1][j] - dungeon[i][j]), f[i][j]);
                }
                if(j != dungeon[0].length - 1){
                    f[i][j] = Math.min(Math.max(1, f[i][j+1] - dungeon[i][j]), f[i][j]);
                }
                if(f[i][j] == Integer.MAX_VALUE)
                    f[i][j] = Math.max(1, 1 - dungeon[i][j]);
            }
        }
        return f[0][0];
    }
}
