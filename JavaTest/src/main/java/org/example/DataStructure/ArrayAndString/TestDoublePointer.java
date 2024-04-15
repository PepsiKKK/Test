package org.example.DataStructure.ArrayAndString;

import java.util.Arrays;

public class TestDoublePointer {

    /**
     * 将一个字符串数组反转过来，必须原地执行，
     * @param s
     */
    public static void reverseString(char[] s) {
        int i = 0;
        int j = s.length - 1;
        char temp = ' ';
        while (i < j) {
            temp = s[i];
            s[i] = s[j];
            s[j] = temp;
            i++;
            j--;
        }
    }

    /**
     * 给定长度为2n的整数数组 nums ，你的任务是将这些数分成n 对, 例如 (a1, b1), (a2, b2), ..., (an, bn) ，使得从 1 到n 的 min(ai, bi) 总和最大
     * @tips 要排序，从小到大，
     * @param nums
     * @return
     */
    public static int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        //tips：既然是双指针，那么可以自己写排序算法
        int res = 0;
        for (int i = 0; i < nums.length; i = i + 2) {
            res += nums[i];
        }
        return res;
    }

    /**
     * 两数之和 leetcode第一题
     * @param numbers
     * @param target
     * @return
     */
    public static int[] twoSum(int[] numbers, int target) {
        int i = 0;
        int j = numbers.length - 1;
        while (i < j) {
            if (numbers[i] + numbers[j] == target) return new int[]{i + 1, j + 1};
            if (numbers[i] + numbers[j] < target) i++;
            else j--;
        }
        return new int[]{-1, -1};
    }

    /**
     * 删除元素，给一个数组和一个值，返回删除这个值后的数组的长度
     * 输入：nums = [0,1,2,2,3,0,4,2], val = 2
     * 输出：5, nums = [0,1,3,0,4]
     * @param nums
     * @param val
     * @return
     */
    public static int removeElement(int[] nums, int val) {
        //使用快慢指针
        int fast = 0;
        int slow = 0;
        while (fast < nums.length) {
            if (nums[fast] != val) {
                //直接修改
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        return slow;
    }

    /**
     * 给定一个二进制数组 nums ， 计算其中最大连续 1 的个数。
     * @param nums
     * @return
     */
    public static int findMaxConsecutiveOnes(int[] nums) {
        //其实快慢指针相当于计数器加一次循环
        int count = 0, res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) count++;
            else {
                count = 0;
            }
            res = Math.max(res, count);
        }
        return res;
    }

    /**
     * 给定一个含有 n 个正整数的数组和一个正整数 target 。
     * 找出该数组中满足其和 ≥ target 的长度最小的 连续子数组
     * 输入：target = 7, nums = [2,3,1,2,4,3]
     * 输出：2
     * 解释：子数组 [4,3] 是该条件下的长度最小的子数组
     * @tips 快慢指针，滑动窗口法
     * @param s
     * @param nums
     * @return
     */
    public static int minSubArrayLen(int s, int[] nums) {
        //获取数组长度
        int n = nums.length;
        //若数组为空，返回0
        if (n == 0) {
            return 0;
        }
        // Initialize the answer to the maximum integer value
        int ans = Integer.MAX_VALUE;
        // Initialize the start and end pointers to 0
        int start = 0, end = 0;
        // Initialize the sum to 0
        int sum = 0;
        // Iterate through the array until the end pointer reaches the end of the array
        while (end < n) {
            // Add the current element to the sum
            sum += nums[end];
            // While the sum is greater than or equal to the target value
            while (sum >= s) {
                // Update the answer to the minimum of the current answer and the difference between the end and start pointers
                ans = Math.min(ans, end - start + 1);
                // Subtract the current element from the sum
                sum -= nums[start];
                // Increment the start pointer
                start++;
            }
            // Increment the end pointer
            end++;
        }
        // If the answer is still the maximum integer value, return 0, otherwise return the answer
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }

}
