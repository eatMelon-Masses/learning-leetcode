package _0932;

import java.util.*;

/**
 *
 */
public class Solution {
    public int[] beautifulArray(int N) {
        if (N == 1) {
            return new int[]{1};
        }
        if (N == 2) {
            return new int[]{1, 2};
        }
        if (N == 3) {
            return new int[]{1, 3, 2};
        }
        List<Integer> result = new ArrayList<>(Arrays.asList(1, 3, 2));
        while (result.size() < N) {
            Iterator<Integer> iterator = result.iterator();
            ArrayList<Integer> left = new ArrayList<>();
            ArrayList<Integer> right = new ArrayList<>();
            while (iterator.hasNext()) {
                Integer next = iterator.next();
                left.add(next * 2 - 1);
                right.add(next * 2);
            }
            result.clear();
            result.addAll(left);
            result.addAll(right);
        }
        System.out.println();
        result.removeIf(integer -> integer > N);
        int[] ints = new int[result.size()];
        int i = 0;
        Iterator<Integer> iterator = result.iterator();
        while (iterator.hasNext()) {
            ints[i++] = iterator.next();
        }
        return ints;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.beautifulArray(4)));
    }
}
