package org.example.DataStructure;

import java.util.Arrays;

public class TestArray {

    /**
     * 寻找数组的中心索引
     * 输入：nums = [1, 7, 3, 6, 5, 6]
     * 输出：3
     * 解释：
     * 中心下标是 3 。
     * 左侧数之和 sum = nums[0] + nums[1] + nums[2] = 1 + 7 + 3 = 11 ，
     * 右侧数之和 sum = nums[4] + nums[5] = 5 + 6 = 11 ，二者相等。
     *
     * tips：第一次错误，不能使用总和除以2，出现除不尽的情况
     * @param nums
     * @return
     */
    public static int pivotIndex(int[] nums) {
        int sum = 0;
        int leftSum = 0;
        //获取数组的和
        for (int num : nums) {
            sum += num;
        }
/*        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                leftSum += nums[j];
            }
            if (sum - nums[i] == 2 *leftSum) {
                return i;
            }
            leftSum = 0;
        }*/
        //优化
        //对数组进行遍历
        for (int i = 0; i < nums.length; i++) {
            //每次遍历总和减去该下标的值
            sum -= nums[i];
            //判断减去后的值与左边遍历过的值的和是否相同
            if (sum == leftSum) {
                return i;
            }
            //每次遍历完左边和加上该下标值
            leftSum += nums[i];
        }
        return -1;
    }

    /**
     * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
     * 输入: nums = [1,3,5,6], target = 2
     * 输出: 1
     * 输入: nums = [1,3,5,6], target = 7
     * 输出: 4
     * todo 可以使用二分法提高性能
     * @param nums
     * @param target
     * @return
     */
    public static int searchInsert(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            //从左边开始遍历，若首次小于等于返回索引值
            if (target <= nums[i]) return i;
        }
        return nums.length;
    }

    /**
     * 合并区间，将有重叠的区间进行合并
     * 输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
     * 输出：[[1,6],[8,10],[15,18]]
     * 解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
     * @param intervals
     * @return
     */
    public static int[][] merge(int[][] intervals) {
        //当数组长度为1时直接返回
        if (intervals.length == 1) return intervals;
        for (int i = 0; i < intervals.length; i++) {
            if (intervals[i][1] >= intervals[i + 1][0]) {
                intervals[i][1] = intervals[i + 1][1];

            }
        }
        return null;
    }
}
