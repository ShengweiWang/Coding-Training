package Google;

/**
 * Created by Shengwei_Wang on 10/16/16.
 */
public class _289_GameOfLife {
    public void gameOfLife(int[][] board) {
        if (board.length == 0 || board[0].length == 0)
            return;
        for (int i = 0; i < board.length; ++i){
            for (int j = 0; j < board[0].length; ++i){
                int liveNeighbor = count(board, i, j);
                if ((board[i][j] & 1) == 0){
                    if (liveNeighbor == 3)
                        board[i][j] |= 2;
                } else {
                    if (liveNeighbor == 2 || liveNeighbor == 3)
                        board[i][j] |= 2;
                }
            }
        }
        for (int i = 0; i < board.length; ++i)
            for (int j = 0; j < board[0].length; ++j) {
                board[i][j] >>= 1;
            }
    }

    public int count(int[][] board, int x, int y){
        int[] xk = {1, 1, 1, 0, 0, -1, -1, -1};
        int[] yk = {-1, 0, 1, -1, 1, -1, 0, 1};
        int ans = 0;
        for(int k = 0; k < 8; ++k){
            int xi = xk[k] + x;
            int yi = yk[k] + y;
            if (xi >=0 && xi < board.length && yi >= 0 && yi < board[0].length && (board[xi][yi] & 1) == 1){
                ++ans;
            }
        }
        return ans;
    }
}
