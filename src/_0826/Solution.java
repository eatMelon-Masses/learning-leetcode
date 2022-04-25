package _0826;

import java.awt.Point;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int l = difficulty.length;
        Point[] p = new Point[difficulty.length];
        for(int i =0;i<difficulty.length;i++){
            p[i] = new Point(difficulty[i],profit[i]);
        }
        Arrays.sort(worker);
        Arrays.sort(p, Comparator.comparingInt(a -> a.x));
        int ans = 0;
        for(int i = 0;i<worker.length;i++){
            int best =0;
            for(int j = 0;j<p.length;j++){
                if(p[j].x <= worker[i]){
                    best =Math.max(best,p[j].y);
                }else{
                    ans+=best;
                    best = 0;
                    break;
                }

            }
            if (best > 0) {
                ans += best;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Set<Character> set = new HashSet<Character>(Arrays.asList('a','e','i','o','u'));
        System.out.println("set.contains('a') = " + set.contains("abc".charAt(0)));
//        Solution solution = new Solution();
//        solution.maxProfitAssignment(new int[]{13,37}, new int[]{4,90}, new int[]{34,73});
    }
}