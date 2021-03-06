package _0638;/*
 * @lc app=leetcode.cn id=638 lang=java
 *
 * [638] 大礼包
 *
 * https://leetcode-cn.com/problems/shopping-offers/description/
 *
 * algorithms
 * Medium (55.22%)
 * Likes:    57
 * Dislikes: 0
 * Total Accepted:    2.5K
 * Total Submissions: 4.5K
 * Testcase Example:  '[2,5]\n[[3,0,5],[1,2,10]]\n[3,2]'
 *
 * 在LeetCode商店中， 有许多在售的物品。
 * 
 * 然而，也有一些大礼包，每个大礼包以优惠的价格捆绑销售一组物品。
 * 
 * 现给定每个物品的价格，每个大礼包包含物品的清单，以及待购物品清单。请输出确切完成待购清单的最低花费。
 * 
 * 每个大礼包的由一个数组中的一组数据描述，最后一个数字代表大礼包的价格，其他数字分别表示内含的其他种类物品的数量。
 * 
 * 任意大礼包可无限次购买。
 * 
 * 示例 1:
 * 
 * 输入: [2,5], [[3,0,5],[1,2,10]], [3,2]
 * 输出: 14
 * 解释: 
 * 有A和B两种物品，价格分别为¥2和¥5。
 * 大礼包1，你可以以¥5的价格购买3A和0B。
 * 大礼包2， 你可以以¥10的价格购买1A和2B。
 * 你需要购买3个A和2个B， 所以你付了¥10购买了1A和2B（大礼包2），以及¥4购买2A。
 * 
 * 示例 2:
 * 
 * 输入: [2,3,4], [[1,1,0,4],[2,2,1,9]], [1,2,1]
 * 输出: 11
 * 解释: 
 * A，B，C的价格分别为¥2，¥3，¥4.
 * 你可以用¥4购买1A和1B，也可以用¥9购买2A，2B和1C。
 * 你需要买1A，2B和1C，所以你付了¥4买了1A和1B（大礼包1），以及¥3购买1B， ¥4购买1C。
 * 你不可以购买超出待购清单的物品，尽管购买大礼包2更加便宜。
 * 
 * 
 * 说明:
 * 
 * 
 * 最多6种物品， 100种大礼包。
 * 每种物品，你最多只需要购买6个。
 * 你不可以购买超出待购清单的物品，即使更便宜。
 * 
 * 
 */

import java.util.ArrayList;
import java.util.List;

// @lc code=start
class Solution {
    public int shoppingOffers(final List<Integer> price, final List<List<Integer>> special, final List<Integer> needs) {
        //Map<String,Integer> dp =new HashMap<String,Integer>();
        return dfs(needs,special,price);
    }
    public boolean isVaild(final List<Integer> needs){//当前需求清单是否符合要求
        
        for(int i=0;i<=needs.size()-1;i++){
            if(needs.get(i)<0) return false;
        }
        return true;
    }
    public void purGood(final List<Integer> needs, final List<Integer> assignGood){//需求清单减去欲购买大礼包后的剩余数量
        for(int i=0;i<=needs.size()-1;i++){
            needs.set(i,needs.get(i)-assignGood.get(i));
        }
        
    }
    public int calMoney(final List<Integer> needs, final List<Integer> price){
        int sum=0;
        for(int i=0;i<=needs.size()-1;i++) sum+=price.get(i)*needs.get(i);
        return sum;
    }
    public int dfs(final List<Integer> needs, final List<List<Integer>> spe, final List<Integer> price){
        //不用大礼包时花费的钱
        int val = calMoney(needs,price);

        for(int i=0;i<=spe.size()-1;i++){
            final List<Integer> tempNeeds = new ArrayList<Integer>(needs);
            final List<Integer> good=spe.get(i);
            purGood(tempNeeds,good);
            if(isVaild(tempNeeds)){
                int temp;
                temp=dfs(tempNeeds,spe,price);
                //if(dp.containsKey(tempNeeds.toString()))
                 //   temp=dp.get(tempNeeds.toString());
                temp+=good.get(good.size()-1);
                val=Math.min(val,temp);
            }
        }
        //dp.put(needs.toString(),val);
        return val;
    }
}
// @lc code=end

