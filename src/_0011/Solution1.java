package _0011;
/**
 * @author zhouye
 * 计算落雨水槽实际装水量
 */
public class Solution1 {
    public int maxArea( int[] height) {
        return magic(height, 0, height.length - 1);
    }

    public int magic(int[] height, int left, int right) {
        if (left+1>=right) return 0;
       //寻找left 和 right 之间最高的坝位置
        int index = left;
        //left 和 right 之间最高的坝高度
        int tall = 0;
        for (int i = left + 1; i < right; i++) {
            if (height[i] > tall) {
                index = i;
                tall = height[i];
            }
        }
        //矮的一边水坑高度
        int damLength = height[left] < height[right] ? height[left] : height[right];
        //计算每个水坑中的实际水量
        if (tall <= damLength) {
            System.out.println("tail:"+tall);
            //每个水坑最大储水量（没有放石头） damLength * (right - left -1)
            int sum = damLength * (right - left - 1);
            for (int j = left + 1; j < right; j++) {
                sum -= height[j];
            }
            return sum;
        }
        return magic(height, left, index) + magic(height, index, right);
    }
    public static void main(String[] args) {

        Solution1 solution1 = new Solution1();
        int result = solution1.maxArea(new int[]{3,1} );
        System.out.println(result);
    }
}
