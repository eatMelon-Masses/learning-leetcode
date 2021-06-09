package _1202;
/**
 * 给你一个字符串 s，以及该字符串中的一些「索引对」数组 pairs，其中 pairs[i] = [a, b] 表示字符串中的两个索引（编号从 0 开始）。
 *
 * 你可以 任意多次交换 在 pairs 中任意一对索引处的字符。
 *
 * 返回在经过若干次交换后，s 可以变成的按字典序最小的字符串。
 *
 *  
 *
 * 示例 1:
 *
 * 输入：s = "dcab", pairs = [[0,3],[1,2]]
 * 输出："bacd"
 * 解释：
 * 交换 s[0] 和 s[3], s = "bcad"
 * 交换 s[1] 和 s[2], s = "bacd"

 */



import java.util.*;

public class Solution {
    int[] fa;
    int[] rank;
    HashMap<Integer, PriorityQueue<Character>> map = new HashMap<>();

    //初始化秩 元素序列
    public void init() {
        for (int i = 0; i < fa.length; i++) {
            fa[i] = i;
            rank[i] = 1;
        }
    }
    //查找根节点，压缩路径
    public int find(int x) {
        return x == fa[x] ? x : (fa[x] = find(fa[x]));

    }
    //合并子数
    public void merge(int i, int j) {
        int x = find(i);
        int y = find(j);
        if (rank[x] <= rank[y]) {
            fa[x] = fa[y];
        }else {
            fa[y] = fa[x];
        }
        if ((rank[x] == rank[y]) && x!=y) {
            rank[x]++;
        }
    }

    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        fa = new int[s.length()];
        rank = new int[s.length()];
        init();
        //建立查并集
        for (int i = 0; i < pairs.size(); i++) {
            int x = pairs.get(i).get(0);
            int y = pairs.get(i).get(1);
            merge(x, y);
        }
        //根节点为key value为优先队列 对同一个根节点里所有元素排序
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int fa = find(i);
            PriorityQueue<Character> p = map.getOrDefault(fa, new PriorityQueue<>());
            p.add(c);
            map.put(fa, p);
        }
        char[] result = new char[s.length()];
        //输出
        for (int i = 0; i < s.length(); i++) {
            PriorityQueue<Character> p = map.get(fa[i]);

            result[i] = p.poll();
        }
        return new String(result);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String string = "dcab";
        ArrayList<List<Integer>> lists = new ArrayList<>();
        lists.add(Arrays.asList(0, 3));
        lists.add(Arrays.asList(1, 2));
        lists.add(Arrays.asList(0, 2));
        String s = solution.smallestStringWithSwaps(string, lists);
        System.out.println(s);
        

    }

}
