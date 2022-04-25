package _0313;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        int l = primes.length;
        int[] points = new int[l];
        List<Integer> list = Arrays.stream(primes).boxed().collect(toList());
        Set<Integer> set = new HashSet<Integer>(list);
        Arrays.fill(points,1);
        Arrays.sort(primes);
        int[] dp = new int[n+1];
        dp[0] = 1;
        for(int i = 1;i<=n;i++){
            System.out.println(1);;
            for(int j = 0;j<l;j++){
                int next = points[j] * primes[j]; 
                boolean isReturn = false;
                int temp = next;

                for(int k = 2; k< next/2+1;k++){
                    boolean sign = false;

                    while (temp % k == 0) {
                        temp = temp/k;
                        sign = true;
                    }
                    if(sign&& ! set.contains(k)){
                        isReturn = true;
                        break;
                    }
                }
                if(dp[i]==0 || dp[i] >= next){
                    points[j]=points[j]+1;
                }
                if(isReturn) continue;
                if(dp[i]==0){
                    dp[i] = next;
                }else{
                    dp[i] = Math.min(next,dp[i]);
                }

            }

        }
        return dp[n -1];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.nthSuperUglyNumber(12, new int[]{2, 7, 13, 19});
    }
}