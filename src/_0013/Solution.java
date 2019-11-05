package _0013;

import java.util.*;

/**
 * @author yiezi
 * url:https://leetcode-cn.com/problems/roman-to-integer/
 * tag:string
 */
class Solution {
    public int romanToInt(String s) {
        int result = 0;
        Map<Character,Integer> time = new HashMap<>();
        time.put('I',1);time.put('V',5);time.put('X',10);time.put('L',50);time.put('C',100);time.put('D',500);time.put('M',1000);
        Map<Character, Set<Character>> special =new HashMap<Character,Set<Character>>();
        special.put('I', new HashSet<>(Arrays.asList('V','X')));
        special.put('X',new HashSet<>(Arrays.asList('L','C')));
        special.put('C',new HashSet<>(Arrays.asList('D','M')));
        int[] reduce = new int[255];
        reduce['I'] = 2;
        reduce['X'] = 20;
        reduce['C'] =200;
        HashSet<Character> defaultSet = new HashSet<>();
        for(Character c:s.toCharArray()){
            result+=time.getOrDefault(c,0);

        }
        for(int j = 1;j<s.length();j++){
            Character pre = s.charAt(j-1);
            if(special.containsKey(pre)){
                Set<Character> temp = special.getOrDefault(pre,defaultSet);
                if (temp.contains(s.charAt(j))) {
                    result-= reduce[pre];
                    j++;
                }
            }
        }
        return result;
    }
    public static void main(String[] args) {
            Solution solution = new Solution();
            System.out.println(solution.romanToInt("CDCMMMMM"));
        }    
}
