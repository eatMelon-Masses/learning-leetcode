package _1227;

/**
 * 有趣题解
 * 需要慢慢一个一个人的分析，然后趋向n能够做到自己位置的解相加
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.dg(4));

    }
    public double dg(int n){
        if (n ==1 ) return 1;
        return  1d/n + (double) (n-2)/n * dg(n-1);
    }
}
