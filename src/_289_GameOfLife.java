/**
 * Created by Shengwei_Wang on 9/2/16.
 */
public class _289_GameOfLife {
    public void gameOfLife(int[][] board) {
        for(int i = 0; i < board.length; ++i)
            for(int j = 0; j < board[0].length; ++j){
                int temp = liveNeighbor(board, i, j);
                if((board[i][j] & 1) == 1){
                    if(temp == 3 || temp == 2)
                        board[i][j] = 3;
                } else {
                    if(temp == 3)
                        board[i][j] = 2;
                }
            }
        for(int i = 0; i < board.length; ++i)
            for(int j = 0; j < board[0].length; ++j){
                board[i][j] >>= 1;
            }
    }
    public int liveNeighbor(int[][] board, int i, int j){
        int lives = 0;
        for(int x = Math.max(i - 1, 0); x <= Math.min(i + 1, board.length - 1); x++) {
            for(int y = Math.max(j - 1, 0); y <= Math.min(j + 1, board[0].length - 1); y++) {
                lives += board[x][y] & 1;
            }
        }
        lives -= board[i][j] & 1;
        return lives;
    }
}
