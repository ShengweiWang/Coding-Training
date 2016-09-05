import java.util.ArrayList;
import java.util.List;

/**
 * Created by Shengwei_Wang on 9/4/16.
 */
public class _119_PascalsTriangleII {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> pre = new ArrayList<>();
        pre.add(1);
        for(int i = 1; i <= rowIndex; ++i){
            int k = 0;
            List<Integer> cur = new ArrayList<>();
            for(int curn : pre){
                cur.add(k + curn);
                k = curn;
            }
            cur.add(1);
            pre = cur;
        }
        return pre;
    }
}
