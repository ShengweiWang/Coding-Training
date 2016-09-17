/**
 * Created by Shengwei_Wang on 9/7/16.
 */
public class _74_SearchA2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;
        int l = 0;
        int r = n * m - 1;
        while(l < r){
            int mid = l + ((r - l)>>1);
            int i = mid / m;
            int j = mid % m;
            if(matrix[i][j] == target)
                return true;
            else if(matrix[i][j] > target)
                r = mid;
            else
                l = mid + 1;
        }
        int i = l / m;
        int j = l % m;
        if(matrix[i][j] == target)
            return true;
        return false;
    }
}
