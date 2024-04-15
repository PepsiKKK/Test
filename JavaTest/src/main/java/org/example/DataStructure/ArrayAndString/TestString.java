package org.example.DataStructure.ArrayAndString;

import java.util.Arrays;
import java.util.Stack;

public class TestString {

    /**
     * 最长回文子串
     * 输入：s = "babad"
     * 输出："bab"
     * 解释："aba" 同样是符合题意的答案。
     * @tips 暴力法、中心扩展法、动态规划法
     * @param s
     * @return
     * @方法： substring从第i到第j前的字符
     */
    public static String longestPalindrome(String s) {
        // 获取字符串s的长度
        int len = s.length();
        // 如果长度小于2，直接返回s
        if (len < 2) {
            return s;
        }
        // 定义一个布尔类型的二维数组dp，用于记录子字符串是否是回文串
        boolean[][] dp = new boolean[len][len];
        // 初始化dp数组对角线上的元素，即单个字符都是回文串
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }
        // 初始化最长回文子串的起始位置和长度
        int resIdx = 0, resLen = 1;
        // 遍历字符串，判断每个子字符串是否是回文串
        for (int j = 1; j < len; j++) {
            for (int i = 0; i < j; i++) {
                // 如果两个字符不相等，则该子字符串不是回文串
                if (s.charAt(i) != s.charAt(j)) {
                    dp[i][j] = false;
                } else {
                    // 如果两个字符相等，判断它们之间的子字符串是否是回文串
                    if (j - i < 3) { //两个字符之间只有1个间隔或者没有间隔，就也还是回文串
                        dp[i][j] = true;
                    } else { //两个字符之间有两个或以上的间隔，就看往里的两个字符是否为回文串（true or false）
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }
                // 如果该子字符串是回文串，并且长度大于当前最长回文子串的长度
                if (dp[i][j] && j - i + 1 > resLen) {
                    // 更新最长回文子串的起始位置和长度
                    resIdx = i;
                    resLen = j - i + 1;
                }
            }
        }
        // 返回最长回文子串
        return s.substring(resIdx, resIdx + resLen);
    }

    /**
     * 最长公共前缀
     * 输入：strs = ["flower","flow","flight"]
     * 输出："fl"
     * 若没有返回""
     * @param strs
     * @return
     */
    public static String longestCommonPrefix(String[] strs) {
        // 定义一个字符串变量prefix，将其初始化为字符串数组strs的第一个元素
        String prefix = strs[0];
        // 遍历字符串数组strs
        for (String s : strs) {
            // 如果prefix以s开头，则将prefix赋值为s，并继续遍历
            if (prefix.startsWith(s)) {
                prefix = s;
                continue;
            }
            // 遍历prefix的每一个字符
            for (int i = 0; i < prefix.length(); i++) {
                // 如果s和prefix的字符不同，则将prefix赋值为前i个字符，并跳出循环
                if (s.charAt(i) != prefix.charAt(i)) {
                    prefix = new String(Arrays.copyOf(prefix.toCharArray(), i));
                    break;
                }
            }
        }
        // 返回prefix
        return prefix;
    }

    /**
     * 反转单词 给你一个字符串 s ，请你反转字符串中 单词 的顺序
     * 输入：s = "the sky is blue"
     * 输出："blue is sky the"
     * @param s
     * @return
     */
    public static String reverseWords(String s) {
        // 设置一个字符串类型的栈存放单词
        Stack<String> stack = new Stack<>();
        // 去除首位的空白
        s.trim();
        //将字符串根据空格分隔成字符串数组
        String[] wordArray = s.split(" ");
        //放入栈中
        for (String word : wordArray) {
            if (!word.isEmpty()) {
                stack.add(word);
            }
        }
        //创建一个动态字符串
        StringBuffer stringBuffer = new StringBuffer();
        //出栈，并加上空格
        while (!stack.isEmpty()) {
            stringBuffer.append(stack.pop());
            if (!stack.isEmpty()){
                stringBuffer.append(" ");
            }
        }
        //返回
        return stringBuffer.toString();
    }

}
