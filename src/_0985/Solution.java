package _0985;

import java.util.Arrays;

public class Solution {
    public int[] sumEvenAfterQueries(int[] A, int[][] queries) {
        int sum = 0;
        int[] result = new int[A.length];
        for (int e : A) {
            if ((e & 1) == 0) {
                sum += e;
            }
        }
        for (int i = 0; i < queries.length; i++) {
            int val = queries[i][0];
            int index = queries[i][1];
            if ((A[index] & 1) == 0) {
                sum -= A[index];
            }
            A[index] += val;
            if ((A[index] & 1) == 0) {
                sum += A[index];
            }
            result[i] = sum;
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] A = {1, 2, 3, 4};
        int[][] queries = {{1, 0}, {-3, 1}, {-4, 0}, {2, 3}};
        System.out.println(Arrays.toString(solution.sumEvenAfterQueries(A,queries)));
    }
}
