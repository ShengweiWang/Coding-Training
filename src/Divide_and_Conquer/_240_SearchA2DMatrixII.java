package Divide_and_Conquer;

/**
 * Created by Shengwei_Wang on 10/9/16.
 */
public class _240_SearchA2DMatrixII {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rowStart = 0;
        int rowEnd = matrix.length - 1;
        int colStart = 0;
        int colEnd = matrix[0].length - 1;
        while (true) {
            if (matrix[rowStart][colEnd] == target)
                return true;
            else if (matrix[rowStart][colEnd] < target)
                ++rowStart;
            else
                --colEnd;

            if (matrix[rowEnd][colStart] == target)
                return true;
            else if (matrix[rowStart][colEnd] < target)
                ++colStart;
            else
                --rowEnd;

            if (rowStart > rowEnd || colStart > colEnd)
                return false;
        }
    }
}
