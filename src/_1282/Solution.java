package _1282;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
       // List<List<Integer>>  groups = new ArrayList<>(500);
        ArrayList<Integer>[] groups = new ArrayList[500];
        List<List<Integer>> result = new ArrayList<>();
        for(int i =0;i<groupSizes.length;i++){
            int index = groupSizes[i];
            if (groups[index] == null) {
                groups[index] = new ArrayList<>();
            }
            groups[index].add(i);
        }
        for (int i = 0; i < groups.length; i++) {
            List<Integer> temp = groups[i];
            if (temp == null) {
                continue;
            }
            for (int j = 0; j < temp.size(); j=j+i) {
                result.add(temp.subList(j,j+i));

            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.groupThePeople(new int[]{1}));
    }
}