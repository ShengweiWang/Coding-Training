/**
 * Created by Shengwei_Wang on 9/12/16.
 */
public class _361_BombEnemy {
    public int maxKilledEnemies(char[][] grid) {
        int n = grid.length;
        if(n == 0)
            return 0;
        int m = grid[0].length;
        int[][] f = new int[n][m];
        int ans = 0;
        for(int i = 0; i < n; ++i){
            int count = 0;
            int start = 0;
            for(int j = 0; j <= m; ++j){
                if(j != m && grid[i][j] == 'E')
                    count++;
                else if(j == m || grid[i][j] == 'W'){
                    for(int k = start; k<j; ++k){
                        if(grid[i][k] == '0')
                            f[i][k] +=count;
                    }
                    start = j + 1;
                    count = 0;
                }
            }
        }
        for(int j = 0; j < m; ++j){
            int count = 0;
            int start = 0;
            for(int i = 0; i <= n; ++i){
                if(i != n && grid[i][j] == 'E')
                    count++;
                else if(i == n || grid[i][j] == 'W'){
                    for(int k = start; k<i; ++k){
                        if(grid[k][j] == '0'){
                            f[k][j] +=count;
                            if(f[k][j] > ans)
                                ans = f[k][j];
                        }
                    }
                    start = i + 1;
                    count = 0;
                }
            }
        }
        // for(int i = 0; i < n; ++i){
        //     for(int j = 0; j < m; ++j)
        //         System.out.print(f[i][j]+ " ");
        //     System.out.println();
        // }
        return ans;
    }
}
