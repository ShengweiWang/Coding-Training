import java.util.List;

/**
 * Created by Shengwei_Wang on 9/1/16.
 */
public class _120_Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        int f[] = new int[triangle.size()];
        int i = 0;
        for(List<Integer> line: triangle){
            if(i > 0)
                f[i] = Integer.MAX_VALUE;
            for(int j = i; j >0; --j){
                f[j] = Math.min(f[j], f[j-1]) + line.get(j);
            }
            f[0] += line.get(0);
            ++i;
        }
        int ans = Integer.MAX_VALUE;
        for(i = 0; i < f.length; ++i)
            if(f[i] < ans)
                ans = f[i];
        return ans;
    }
}
