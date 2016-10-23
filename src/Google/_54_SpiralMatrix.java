package Google;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Shengwei_Wang on 10/18/16.
 */
public class _54_SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new LinkedList<>();
        if (matrix.length == 0 || matrix[0].length == 0)
            return ans;
        rec(0, 0, matrix.length - 1, matrix[0].length - 1, matrix, ans);
        return ans;
    }

    void rec(int up, int left, int down, int right, int[][] matrix, List<Integer> ans) {
        if (up > down || left > right)
            return;
        for (int i = left; i <= right; ++i) {
            ans.add(matrix[up][i]);
        }
        ++up;
        for (int i = up; i <= down; ++i) {
            ans.add(matrix[i][right]);
        }
        --right;
        if (up <= down) {
            for (int i = right; i >= left; --i) {
                ans.add(matrix[down][i]);
            }
            --down;
        }
        if (left <= right) {
            for (int i = down; i >= up; --i) {
                ans.add(matrix[i][left]);
            }
            ++left;
        }
        rec(up, left, down, right, matrix, ans);

    }

}
