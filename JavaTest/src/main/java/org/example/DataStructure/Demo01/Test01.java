package org.example.DataStructure.Demo01;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Test01 {

    /**
     * 盛最多水的容器
     * 双指针
     * @param height
     * @return
     */
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int res = 0;
        while (left < right) {
            res = Math.max(res, (Math.min(height[left], height[right]) * (right - left)));
            if (height[left] < height[right]) {
                left++;
            }else {
                right--;
            }
        }
        return res;
    }

    /**
     * 合并两个有序数组
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if(m == 0 && n == 0) {
            nums1 = new int[0];
        }
        int[] temp = new int[m + n];
        if (m >= 0) {
            System.arraycopy(nums1, 0, temp, 0, m);
        }
        if (n >= 0) {
            System.arraycopy(nums2, 0, temp, 0 + m, n);
        }
        Arrays.sort(temp);
        System.arraycopy(temp, 0, nums1, 0, m + n);

        System.out.println(Arrays.toString(nums1));
    }

    public static void main(String[] args) {
        Test01 test01 = new Test01();
        int[] nums = new int[]{1,1,1,2,2,3};
        test01.removeDuplicates(nums);

    }

    /**
     * 删除有序数组中的重复项2
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }
        

        System.out.println(map);
        return 0;
    }
}
