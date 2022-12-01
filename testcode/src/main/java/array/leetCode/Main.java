package array.leetCode;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Arti.Jadhav
 */
public class Main {
    public static void main(String[] args) {

        System.out.println("max profit...");
        Main m = new Main();
        //int[] prices = {7, 1, 5, 3, 6, 4};
        int[] prices = {2, 4, 1};
        System.out.println(m.maxProfit(prices));
        Integer[] a ={2,3,4};
        List<Integer> b = Arrays.asList(a);
    }

    //Medium
    //https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
    public int maxProfit(int[] prices) {
        List<Integer> pricesList = Arrays.stream(prices).boxed().collect(Collectors.toList());

        List<Integer> profitList = new ArrayList<>();
        Map<Integer, Integer> map = new TreeMap<Integer, Integer>();
        pricesList.stream().forEach(i -> map.put(i, pricesList.indexOf(i)));

        int startIndex = 0;
        int endIndex = pricesList.size()-1;
        for (int i = 0; i < pricesList.size(); i++) {
            if (pricesList.get(startIndex) < pricesList.get(endIndex)) {
                startIndex = i;
                profitList.add(pricesList.get(endIndex) - pricesList.get(i));
            }else {
                startIndex++;
            }
            if (pricesList.get(i) > pricesList.get(endIndex)) {
                endIndex--;
            }
        }
        System.out.println(map);
        System.out.println(profitList);
        return 0;
    }

    //EASY
    //https://leetcode.com/problems/best-time-to-buy-and-sell-stock/submissions/
    public int maxEasyProfit(int[] prices) {
        int profit = 0;
        int max = 0;
        int min = Integer.MAX_VALUE;
        int minIndex = 0;

        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < min) {
                min = prices[i];
                minIndex = i;
            }
            if (prices[i] > max && prices[i] > min && i > minIndex)
                max = prices[i];
            else
                max = 0;
            if (max - min > profit)
                profit = max - min;
        }
        System.out.println("final profit " + profit + " max:" + max + " :min:: " + min);

        return profit;
    }

}
