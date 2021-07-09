package _0316;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author zhouye
 * @date 2021年7月7日
 */
public class Solution {
    public String removeDuplicateLetters(final String s) {
        final List<Character> sList = s.chars().mapToObj(c -> (char) c).collect(Collectors.toList());
        final Map<Character, Integer> keyCount = sList.stream().collect(Collectors.toMap(Function.identity(), v -> 1, (sum, cur) -> sum + 1));
        final HashSet<Character> isExist = new HashSet<>();

        final Stack<Character> stack = new Stack<>();
        sList.forEach((t) -> {
            if (isExist.contains(t)) {
                keyCount.computeIfPresent(t, (k, v) -> v - 1);
            } else {
                while (!stack.isEmpty() && stack.peek() >= t && keyCount.get(stack.peek()) > 1) {
                    keyCount.computeIfPresent(stack.peek(), (k, v) -> v - 1);
                    isExist.remove(stack.pop());
                }
                stack.push(t);
                isExist.add(t);

            }

        });

        return stack.stream().map(String::valueOf).collect(Collectors.joining());
    }

    public static void main(final String[] args) {
        final Solution solution = new Solution();
        final String result = solution.removeDuplicateLetters("adabd");
        System.out.println(result);
    }

}
