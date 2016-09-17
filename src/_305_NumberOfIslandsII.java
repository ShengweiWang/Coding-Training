import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Shengwei_Wang on 9/17/16.
 */
public class _305_NumberOfIslandsII {
    int[] father;
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        int[] xit = {1,-1,0,0};
        int[] yit = {0,0,1,-1};
        List<Integer> res = new ArrayList<>();
        father = new int[m * n];
        Arrays.fill(father, -1);
        int count = 0;
        for(int i = 0; i < positions.length; ++i){
            int x = positions[i][0];
            int y = positions[i][1];
            int index = x*n + y;
            father[index] = index;
            ++count;
            for(int k = 0; k < 4; ++k){
                int xi = xit[k] + x;
                int yi = yit[k] + y;
                int subindex = xi *n + yi;
                if(xi < 0 || yi < 0 || xi >=m || yi >=n || father[subindex] == -1)
                    continue;
                if(find(index) != find(subindex)){
                    father[father[index]] = father[subindex];
                    --count;
                }
            }
            // for(int d = 0; d < m*n; ++d)
            //     System.out.print(father[d] + " ");
            // System.out.println();
            res.add(count);
        }
        return res;
    }

    int find(int index) {
        if(father[index] == index)
            return index;
        father[index] = find(father[index]);
        return father[index];
    }
}
