package org.example.DataStructure.ArrayAndString;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class TestAll {

    /**
     * 杨辉三角
     * @tips 二维数组版
     * @param numRows
     * @return
     */
    public static int[][] generate(int numRows) {
        if (numRows == 0) {
            return new int[0][];
        }
        int[][] arr = new int[numRows][];
        for (int i = 0; i < numRows; i++) {
            arr[i] = new int[i + 1];
            for (int j = 0; j < arr[i].length; j++) {
                if (j == 0 || j == i) {
                    arr[i][j] = 1;
                }else {
                    arr[i][j] = arr[i-1][j] + arr[i-1][j-1];
                }
            }
        }
        return arr;
    }

    /**
     * 杨辉三角
     * @tips list集合版
     * @param numRows
     * @return
     */
    public static List<List<Integer>> generate2(int numRows) {
        List<List<Integer>> lists = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            lists.add(new ArrayList<>());
            for (int j = 0; j < i + 1; j++) {
                if (j == 0 || j == i) {
                    lists.get(i).add(1);
                }else {
                    lists.get(i).add(lists.get(i-1).get(j) + lists.get(i-1).get(j-1));
                }
            }
        }
        return lists;
    }

    /**
     * 杨辉三角
     * 返回最后一行
     * @param rowIndex
     * @return
     */
    public static List<Integer> getRow(int rowIndex) {
        List<List<Integer>> lists = new ArrayList<>();
        for (int i = 0; i < rowIndex + 1; i++) {
            lists.add(new ArrayList<>());
            for (int j = 0; j < i + 1; j++) {
                if (j == 0 || j == i) {
                    lists.get(i).add(1);
                }else {
                    lists.get(i).add(lists.get(i-1).get(j) + lists.get(i-1).get(j-1));
                }
            }
        }
        return lists.get(rowIndex);
    }

    /**
     * 反转字符串中的单词
     * 输入：s = "Let's take LeetCode contest"
     * 输出："s'teL ekat edoCteeL tsetnoc"
     * 不包含任何开头或结尾的空格
     * @param s
     * @return
     */
    public static String reverseWords(String s) {
        StringBuilder res = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != ' ') {
                stack.add(s.charAt(i));
            }else {
                while (stack != null && stack.size() != 0) {
                    res.append(stack.pop());
                }
                res.append(' ');
            }
        }
        while (stack != null && stack.size() != 0) {
            res.append(stack.pop());
        }
        return res.toString();
    }
    // todo 性能太差 区别StringBuilder 和StringBuffer

    /**
     * 旋转数组，找出一个旋转数组的最小值
     * 输入：nums = [4,5,6,7,0,1,2]
     * 输出：0
     * 解释：原数组为 [0,1,2,4,5,6,7] ，旋转 3 次得到输入数组。
     * 要求时间复杂度为O(logn)
     * @param nums
     * @return
     */
    public static int findMin(int[] nums) {
        int n = nums.length;
        int left = 0, right = n - 1;
        while (left < right){
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[right]){
                left = mid + 1;
            }else {
                right = mid;
            }
        }
        return nums[left];
    }

    /**
     * 删除排序数组中的重复项
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        //使用快慢指针
        int slow = 0, fast = 1;
        while (fast < nums.length) {
            //
            if (nums[slow] == nums[fast]) {
                //等于的情况，fast继续向下找大于的数
                fast++;
            }else {
                //小于的情况下，也只可能小于
                //找到slow的下一位，将其改成大的数
                slow++;
                nums[slow] = nums[fast];
            }
        }
        //返回长度
        return slow + 1;
    }

    /**
     * 移动0
     * 不复制数组
     * 输入: nums = [0,1,0,3,12]
     * 输出: [1,3,12,0,0]
     * @param nums
     */
    public static void moveZeroes(int[] nums) {
        int slow = 0;
        for (int fast = 0; fast < nums.length; fast++) {
            if (nums[fast]!=0){
                int num=nums[slow];
                nums[slow]=nums[fast];
                nums[fast]=num;
                slow++;
            }
        }
    }


}
