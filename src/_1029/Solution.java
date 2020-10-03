package _1029;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {

    public int twoCitySchedCost(int[][] costs) {
        //第i个人飞往a和b市费用差值
        Arrays.sort(costs, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o1[1] - (o2[0] - o2[1]);
            }
        });
        int total = 0;
        int n = costs.length / 2;
        for (int i = 0; i < n; i++) {
            total += costs[i][0] + costs[i + n][1];
        }
        return total;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.twoCitySchedCost(new int[][]{{259,770},{448,54},{926,667},{184,139},{840,118},{577,469}}));
    }
}
