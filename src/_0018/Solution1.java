package _0018;


import java.util.*;

public class Solution1 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        ArrayList<List<Integer>> result = new ArrayList<>();
        HashMap<Integer, List<String>> map = new HashMap<>();
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < nums.length-1; i++) {
            for (int j = i+1; j < nums.length; j++) {
                int e = nums[i] + nums[j];
                if (map.containsKey(target-e)) {
                    List<String> indexs = map.get(target - e);
                    for (int k = 0; k < indexs.size(); k++) {
                        HashSet<String> diff = new HashSet<>();
                        List<String> left = Arrays.asList(indexs.get(k).split(","));
                        diff.addAll(left);
                        if (diff.contains(Integer.toString(i)) || diff.contains(Integer.toString(j))) {
                            continue;
                        }


                        Integer[] ints = {nums[i], nums[j], nums[Integer.parseInt(left.get(0))], nums[Integer.parseInt(left.get(1))]};
                        Arrays.sort(ints);
                        if (!set.contains(Arrays.toString(ints))) {
                            List<Integer> integers = Arrays.asList(ints);
                            result.add(integers);
                        }
                        set.add(Arrays.toString(ints));
                    }

                }
                List<String> indexs = map.getOrDefault(e, new ArrayList<>());
                indexs.add( i + "," + j);
                map.put(e,indexs);

            }
        }

        //System.out.println(set);
        return result;
    }
    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        System.out.println(solution1.fourSum(new int[]{1, 0, -1, 0, -2, 2},0));
    }
}
