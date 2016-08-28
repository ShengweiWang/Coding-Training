import java.awt.*;

/**
 * Created by Shengwei_Wang on 8/25/16.
 */
public class _52_N_QueensII {
    int ans;
    int column;
    int diag;
    int diagMinus;
    int nn;
    public int totalNQueens(int n){
        nn = n;
        ans = 0;
        column = 0;
        diag = 0;
        diagMinus = 0;
        dfs(0);
        return ans;
    }
    public void dfs(int n){
//        System.out.println("~~~~");
//        System.out.println(n);
//        System.out.println(column);
//        System.out.println(diag);
//        System.out.println(diagMinus);
//        System.out.println("~~~~");
        if(n == nn){
            ++ans;
            return;
        }
        for(int i = 0; i < nn; ++i){
            if(((column & (1 << i)) == 0)&&
                    ((diag & ((1<<n)<<i)) == 0) &&
                    ((diagMinus & (((1<<nn)<<i)>>n)) == 0)){
                column ^= (1 << i);
                diag ^= ((1<<n)<<i);
                diagMinus ^= (((1<<nn)<<i)>>n);
                dfs(n+1);
                column ^= (1 << i);
                diag ^= ((1<<n)<<i);
                diagMinus ^= (((1<<nn)<<i)>>n);
            }
        }
    }
}
