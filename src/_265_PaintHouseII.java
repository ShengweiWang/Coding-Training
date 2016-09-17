/**
 * Created by Shengwei_Wang on 9/5/16.
 */
public class _265_PaintHouseII {
    public int minCostII(int[][] costs) {
        if(costs.length == 0)
            return 0;
        int minIndex = -1;
        int useMin = 0;
        int unuseMin = 0;
        for(int i = 0; i < costs.length; ++i){
            int nextMinIndex = -1;
            int nextUseMin = Integer.MAX_VALUE;
            int nextUnuseMin = Integer.MAX_VALUE;

            for(int k = 0; k < costs[i].length; ++k){
                int curCost;
                if(k == minIndex)
                    curCost = costs[i][k] + unuseMin;
                else
                    curCost = costs[i][k] + useMin;
                if(curCost < nextUseMin){
                    nextUnuseMin = nextUseMin;
                    nextUseMin = curCost;
                    nextMinIndex = k;
                } else if (curCost < nextUnuseMin){
                    nextUnuseMin = curCost;
                }
            }

            minIndex = nextMinIndex;
            useMin = nextUseMin;
            unuseMin = nextUnuseMin;

        }

        return useMin;
    }
}
