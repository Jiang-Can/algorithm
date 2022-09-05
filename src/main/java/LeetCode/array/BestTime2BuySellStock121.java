package LeetCode.array;

public class BestTime2BuySellStock121 {
    public int maxProfit(int[] prices) {
        int min=Integer.MAX_VALUE;
        int max=0;
        for (int price : prices) {
            if (price < min) min = price;
            if (price - min > max) {
                max = price - min;
            }
        }
        return max;
    }

    //可以多次买进卖出
    //可以最低点买进最高点卖出
    //本质上就是买到所有增长值
    public int maxProfit2(int[] prices) {
        int profit=0;
        for(int i=1;i<prices.length;i++){
            if(prices[i]>prices[i-1]){
                profit+=prices[i]-prices[i-1];
            }
        }
        return profit;
    }

}
