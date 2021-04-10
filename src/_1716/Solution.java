package _1716;

/**
 * @author zhouye
 * @date 2021/4/10
 */
public class Solution {
    public int totalMoney(int n) {
        //总存款
        int result = 0;
        int week = 1;
        for (int i = 1; i <= n; i++) {
            int step = 0;
            if (i % 7 == 1) {
                //当前是第几周
                week = week(i);
                step = week;
            }else {
                //当日新增存款=step(周基数)+距离这周一过了几天
                step = week + (i-1)%7;
            }

            result += step;
        }
        return result;
    }

    /**
     * 第n天是第几周
     * @param n
     */
    public int week(int n) {
        return n / 7 + 1;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.totalMoney(20));

    }
}
