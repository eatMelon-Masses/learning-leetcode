package _0056;


import java.util.Arrays;
import java.util.LinkedList;

class Solution {
	public int[][] merge(int[][] intervals) {
		Arrays.sort(intervals,(o1,o2)-> o1[0]-o2[0]);
		LinkedList<Integer> starts = new LinkedList<>();
		LinkedList<Integer> ends = new LinkedList<>();
		for (int i = 0; i < intervals.length; i++) {
			int curStart = intervals[i][0];
			int curEnd = intervals[i][1];
			if (starts.isEmpty() ) {
				starts.add(curStart);
				ends.add(curEnd);
			} else if (ends.getLast() < curStart) {
				starts.add(curStart);
				ends.add(curEnd);
			} else {
				ends.add(Math.max((ends.removeLast()), curEnd));
			}
		}
		int[][] res = new int[starts.size()][2];
		for (int i = 0; i < starts.size(); i++) {
			res[i][0] = starts.get(i);
			res[i][1] = ends.get(i);
		}
		System.out.println(Arrays.toString(intervals));
		return res;
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		int[][] arr = {{1, 3}, {5, 7}, {2, 2}, {4, 6}};
		solution.merge(arr);
	}
}
