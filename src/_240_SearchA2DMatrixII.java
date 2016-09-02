/**
 * Created by Shengwei_Wang on 9/1/16.
 */
public class _240_SearchA2DMatrixII {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rowStart = 0;
        int rowEnd = matrix.length - 1;
        int colStart = 0;
        int colEnd = matrix[0].length - 1;
        int lastSize = (colEnd + 1) * (rowEnd + 1);
        while(true){
            if(matrix[rowStart][colEnd] < target)
                ++rowStart;
            if(rowStart > rowEnd || colStart > colEnd)
                return false;
            if(matrix[rowEnd][colStart] < target)
                ++colStart;
            if(rowStart > rowEnd || colStart > colEnd)
                return false;
            if(matrix[rowStart][colEnd] > target)
                --colEnd;
            if(rowStart > rowEnd || colStart > colEnd)
                return false;
            if(matrix[rowEnd][colStart] > target)
                --rowEnd;
            if(rowStart > rowEnd || colStart > colEnd)
                return false;
            int cur = (colEnd - colStart + 1) * (rowEnd - rowStart + 1);
            if(cur == lastSize)
                return true;
            else
                lastSize = cur;
        }
    }
}
