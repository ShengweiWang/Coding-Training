import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Shengwei_Wang on 9/21/16.
 */
public class _51_NQueens {
    List<List<String>> ans;
    int col;
    int diag;
    int anti;
    int[] save;
    public List<List<String>> solveNQueens(int n) {
        col = 0;
        diag = 0;
        anti = 0;
        ans = new ArrayList<>();
        save = new int[n];
        if (n < 3)
            return ans;
        solve(0);
        return ans;
    }

    public void solve(int n){
        if (n == save.length) {
            List<String> cur = new ArrayList<>();
            for(int i = 0; i < save.length; ++i) {
                char[] helper = new char[save.length];
                Arrays.fill(helper, '.');
                helper[save[i]] = 'Q';
                cur.add(new String(helper));
            }
            ans.add(cur);
        } else {
            for(int i = 0; i < 9; ++i){
                int colv = 1 << i;
                int diagv = 1 << (i + n);
                int antiv = 1 << (i - n + save.length - 1);
                if((col | colv) != 0 && (diag | diagv) != 0 && (anti | antiv) != 0) {
                    col ^= colv;
                    diag ^= diagv;
                    anti ^= antiv;
                    save[n] = i;
                    solve(n+1);
                    col ^= colv;
                    diag ^= diagv;
                    anti ^= antiv;
                }
            }
        }
    }
}
