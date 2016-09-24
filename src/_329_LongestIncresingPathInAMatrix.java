import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by Shengwei_Wang on 9/18/16.
 */
public class _329_LongestIncresingPathInAMatrix {
    public int longestIncreasingPath(int[][] matrix) {
        int[][] dir = {{1,0}, {-1,0}, {0,1}, {0,-1}};
        if(matrix.length == 0)
            return 0;
        int n = matrix.length;
        int m = matrix[0].length;
        int nm = n * m;
        Integer[] index = new Integer[nm];
        int[][] count = new int[n][m];
        for(int i = 0; i < nm; ++i)
            index[i] = i;
        Arrays.sort(index, new Comparator<Integer>(){
            @Override
            public int compare (Integer obj1, Integer obj2){
                return Integer.compare(matrix[obj1/m][obj1%m], matrix[obj2/m][obj2%m]);
            }
        });
        int max = 0;
        for(int i = 0; i < nm; ++i){
            int x = index[i] / m;
            int y = index[i] % m;
            int cur = count[x][y] + 1;
            if(cur > max)
                max = cur;
            for(int k = 0; k < 4; ++k){
                int xi = x + dir[k][0];
                int yi = y + dir[k][1];
                if(xi >= 0 && yi >=0 && xi < n && yi < m && matrix[x][y] < matrix[xi][yi] && cur > count[xi][yi]){
                    count[xi][yi] = cur;

                }
            }
        }
        return max;
    }
}
