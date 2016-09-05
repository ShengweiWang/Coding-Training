/**
 * Created by Shengwei_Wang on 9/4/16.
 */
public class _36_ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        boolean[][] row = new boolean[9][10];
        boolean[][] col = new boolean[9][10];
        boolean[][][] group = new boolean[3][3][10];
        for(int i = 0; i < 9; ++i){
            for(int j = 0; j < 9; ++j){
                char c = board[i][j];
                if(c == '.')
                    continue;
                else {
                    int k = c - '0';
                    if(k <= 0 || k >9)
                        return false;
                    if(row[i][k])
                        return false;
                    if(col[j][k])
                        return false;
                    if(group[i/3][j/3][k])
                        return false;
                    row[i][k] = true;
                    col[j][k] = true;
                    group[i/3][j/3][k] = true;
                }
            }
        }
        return true;
    }
}
