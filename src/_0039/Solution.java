package _0039;/*
 * @lc app=leetcode.cn id=39 lang=java
 * tag: array
 * [39] 组合总和
 */

import java.util.ArrayList;
import java.util.List;

// @lc code=start
class Solution {
    public List<List<Integer>> combinationSum(final int[] candidates, final int target) {
        final List<List<Integer>> result = new ArrayList<List<Integer>>();
        for(int i = 0; i<= candidates.length-1;i++){
            List<List<Integer>> dp = init(candidates[i]); 
             while(!dp.isEmpty()){
                dp=functionDp(dp,candidates,target,result);
             }       
        }
    

        return result;
    }
    public List<List<Integer>> init(final int firstNum){
        final List<List<Integer>> tempList = new ArrayList<List<Integer>>();
        final List<Integer> temp = new ArrayList<Integer>();
        temp.add(firstNum);
        tempList.add(temp);
        return tempList;
    }
    public int sum(final List<Integer> list){
        int sum = 0;
        for(final int e: list){
            sum+=e;
        }
        return sum;
    }
    public List<List<Integer>> functionDp(final List<List<Integer>> dp, final int[]  candidates, final int target, final List<List<Integer>> result){
        final List<List<Integer>> nextDp = new ArrayList<List<Integer>>();
        for(final List<Integer> temp : dp){
            final int sum =sum(temp);
            if(sum == target){
                final List<Integer> currOneResult = new ArrayList<Integer>();
                currOneResult.addAll(temp);
                result.add(currOneResult);
                continue;
            }
            final int lastE =temp.get(temp.size()-1);
            for(int i =findIndex(lastE,candidates) ;i<=candidates.length-1;i++){
                final int currentSum = candidates[i]+sum;
                final List<Integer> currentList = new ArrayList<Integer>();
                currentList.addAll(temp);
                currentList.add(candidates[i]);
                if(currentSum < target){
                    nextDp.add(currentList);
                }else if(currentSum == target){
                    result.add(currentList);
                }
            }   
        }
        return nextDp;
    }
    public int findIndex(final int e, final int[] array){
        for(int i = 0 ;i<=array.length-1;i++){
            if(e==array[i]) return i;
        }
        return 0;
    }
}
// @lc code=end

