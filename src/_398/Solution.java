package _398;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class Solution {
        int[] box;
        Random r = new Random();
    public Solution(int[] nums) {
        box = nums;
    }
    
    public int pick(int target) {
        List<Integer> list = new ArrayList<>();
        for(int i = 0;i<box.length;i++){
            if(box[i] == target)
                list.add(box[i]);
        }
        //System.out.println(list.size());
        if(list.size()==1) return list.get(0);
        return list.get(r.nextInt(list.size()-1));
    }

    public static void main(String[] args) {
//        Solution solution = new Solution(new int[]{1,2,3,3,3});
//        System.out.println(solution.pick(1));
        Random random = new Random();
        for (int i = 0; i < 30; i++) {
            System.out.println(random.nextInt(20));
        }
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */