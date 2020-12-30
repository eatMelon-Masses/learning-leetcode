package _1528.java;

public class Solution {
    public String restoreString(String s, int[] indices) {
        char[] chars = s.toCharArray();
        for(int i = 0;i<indices.length;i++){
            chars[i] =(char) (chars[i] ^ chars[indices[i]]);
            chars[indices[i]] = (char)(chars[i] ^ chars[indices[i]]);
            chars[i] = (char) (chars[indices[i]] ^ chars[i]);

        }
        return new String(chars);
    }
    public static void main(String[] args) {

    }
}
