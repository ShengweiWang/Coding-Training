import java.util.LinkedList;
import java.util.List;

/**
 * Created by Shengwei_Wang on 9/21/16.
 */
public class _282_ExpressionAddOperators {
    List<String> ans;
    char[] digits;
    char[] path;
    int target;
    int n;
    public List<String> addOperators(String num, int target) {
        this.target = target;
        this.n = num.length();

        ans = new LinkedList<String>();
        if(n == 0)
            return ans;
        long cn = 0;
        path = new char[num.length() * 2 - 1];
        digits = num.toCharArray();

        for(int i = 0; i < n; ++i){
            cn = cn * 10 + digits[i] - '0';
            path[i] = digits[i];
            dfs(i + 1, i + 1, 0, cn);
            if(cn == 0) break;
        }
        return ans;
    }

    void dfs(int pos, int len, long left, long cur){
        if (pos == n) {
            if(left + cur == target)
                ans.add(new String(path, 0, len));
            return;
        }
        long cn = 0;
        int j = len + 1;
        for(int i = pos; i < n; ++i){
            cn = cn * 10 + digits[i] - '0';
            path[j] = digits[i];
            ++j;
            path[len] = '+';
            dfs(i + 1, j, left + cur, cn);
            path[len] = '-';
            dfs(i + 1, j, left + cur, -cn);
            path[len] = '*';
            dfs(i + 1, j, left, cur * cn);
            if(cn == 0)
                break;
        }
    }
}
