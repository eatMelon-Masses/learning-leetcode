package _0093;

import java.util.LinkedList;
import java.util.List;

/**
 * @author yiezi
 * url: https://leetcode-cn.com/problems/restore-ip-addresses/
 * tag: string
 */
public class Solution {
        String s ;
    LinkedList<String> train;
    LinkedList<String> result;
    public List<String> restoreIpAddresses(String s) {
        this.s = s;
        this.train = new LinkedList<>();
        this.result = new LinkedList<>();
        changeDots(-1,3);
        return result;
    }
    public void changeDots(int index,int count) {
        if (count == 0 ) return;
        int end = Math.min(index + 4, s.length());

        for (int curr = index+1; curr < end; curr++) {
            String currStr = s.substring(index+1,curr+1);
            if (validate(currStr)) {
                train.add(currStr);
                if (count - 1 == 0) {
                    outputResult(curr);
                }else {
                    changeDots(curr,count-1);
                }

                train.removeLast();
            }
            
        }
        
    }
    public boolean validate(String pre) {
        int len = pre.length();
        if (pre.isEmpty()|len>3) {
            return false;
        }
        boolean result = false;


        if (Integer.parseInt(pre) <= 255) {
            result = true;
        }
        if (pre.charAt(0) == '0' && len > 1) {
            result = false;
        }
        return result;
    }
    public void outputResult(int last) {
        String currStr = s.substring(last+1,s.length());
        if (validate(currStr)) {
            train.add(currStr);
            result.add(String.join(".", train));
            train.removeLast();
        }

    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.restoreIpAddresses("0279245587303"));
    }
}
