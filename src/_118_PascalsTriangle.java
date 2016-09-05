import java.util.ArrayList;
import java.util.List;

/**
 * Created by Shengwei_Wang on 9/4/16.
 */
public class _118_PascalsTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        if(numRows == 0)
            return ans;
        List<Integer> pre = new ArrayList<>();
        pre.add(1);
        ans.add(pre);
        if(numRows == 1)
            return ans;
        for(int i = 1; i < numRows; ++i){
            int k = 0;
            List<Integer> cur = new ArrayList<>();
            for(int curn : pre){
                cur.add(k + curn);
                k = curn;
            }
            cur.add(1);
            pre = cur;
            ans.add(cur);
        }
        return ans;
    }
}
