package _0638;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution1 {
    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        return dg(price, special, needs, 0);
    }

    public int dg(List<Integer> price, List<List<Integer>> special, List<Integer> needs, int before) {
        int cost = Integer.MAX_VALUE;
        for (int i = 0; i < special.size(); i++) {
            if (isBuy(special.get(i), needs)) {
                int gift = subtraction(special.get(i), needs);
                int unit = unit(special.get(i), price);
                if (gift < unit) {
                    cost = Math.min(dg(price, special, needs,before+gift), cost);
                    add(special.get(i), needs);
                }else {
                    cost = Math.min(dg(price, special, needs,before+unit), cost);
                }

            }
        }
        if (cost == Integer.MAX_VALUE) {
            int temp = 0;
            for (int i = 0; i < needs.size(); i++) {
                temp += price.get(i) * needs.get(i);
            }
            cost = temp + before;
            //System.out.println(before + after);
        }
        return cost;
    }


    public boolean isBuy(List<Integer> special, List<Integer> needs) {
        for (int i = 0; i < needs.size(); i++) {
            if (needs.get(i) < special.get(i)) {
                return false;
            }

        }
        return true;
    }

    public int subtraction(List<Integer> special, List<Integer> needs) {
        for (int i = 0; i < needs.size(); i++) {
            needs.set(i, needs.get(i) - special.get(i));
        }
        return special.get(special.size() - 1);
    }

    public int unit(List<Integer> special,List<Integer> prices) {
        int result = 0;
        for (int i = 0; i < special.size() - 1; i++) {
            result += prices.get(i) * special.get(i);
        }
        return result;
    }
    public int add(List<Integer> special, List<Integer> needs) {
        for (int i = 0; i < needs.size(); i++) {
            needs.set(i, needs.get(i) + special.get(i));
        }
        return special.get(special.size() - 1);
    }
    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        List<Integer> prices = Arrays.asList(9, 9);
        ArrayList<List<Integer>> special = new ArrayList<>();
        special.add(Arrays.asList(1,1,1));
        List<Integer> needs = Arrays.asList(2,2);
        System.out.println(solution1.shoppingOffers(prices, special, needs));
        //System.out.println(solution1.isBuy(Arrays.asList(1, 2, 10), Arrays.asList(2, 0)));
    }
}
