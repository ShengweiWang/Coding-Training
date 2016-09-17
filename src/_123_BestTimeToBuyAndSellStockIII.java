/**
 * Created by Shengwei_Wang on 9/17/16.
 */
public class _123_BestTimeToBuyAndSellStockIII {
    public int maxProfit(int[] prices) {
        if(prices.length < 2)
            return 0;
        int oneBuy = -prices[0];
        int oneSell = 0;
        int twoBuy = -prices[0];
        int twoSell = 0;
        for(int i = 1; i < prices.length; ++i){
            twoSell = Math.max(twoSell, twoBuy + prices[i]);
            twoBuy = Math.max(twoBuy, oneSell - prices[i]);
            oneSell = Math.max(oneSell, oneBuy + prices[i]);
            oneBuy = Math.max(oneBuy, -prices[i]);
        }
        return twoSell;

    }
}
