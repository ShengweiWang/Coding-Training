package Google;

import java.util.Set;
import java.util.TreeSet;

/**
 * Created by Shengwei_Wang on 10/31/16.
 */
public class _363_MaxSumOfRectangleNoLargerThanK {
    public int maxSumSubmatrix(int[][] matrix, int k) {
        if (matrix.length == 0 || matrix[0].length == 0)
            return 0;
        int n = matrix.length;
        int m = matrix[0].length;
        int res = 0;
        for (int l = 0; l < m; ++l) {
            int[] a= new int[n];
            for (int r = l; r < m; ++r) {
                int sum = 0;
                TreeSet<Integer> set = new TreeSet<>();
                set.add(0);
                for (int i = 0; i < n; ++i) {
                    a[i] += matrix[i][r];
                    sum += a[i];
                    Integer subrec = set.ceiling(sum - k);
                    if (subrec != null) {
                        res = Math.max(res, sum - subrec);
                    }
                    set.add(sum);
                }
            }
        }
        return res;
    }

}
