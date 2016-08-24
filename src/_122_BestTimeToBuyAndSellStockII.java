/**
 * Created by Shengwei_Wang on 8/24/16.
 */
public class _122_BestTimeToBuyAndSellStockII {
    public int maxProfit(int[] prices){
        int res = 0;
        for(int i = 1; i < prices.length; ++i){
            if(prices[i] > prices[i-1]){
                res += (prices[i] - prices[i-1]);
            }
        }
        return res;
    }
}
