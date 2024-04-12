package org.example.DataStructure;

public class TestDoubleArray {

    /**
     * 旋转图像：给定一个n*n的二维数组，将图像原地顺时针旋转90°
     * @tips: 先对角就后垂直；先水平就后对角
     * @param matrix
     */
    public static void rotate(int[][] matrix) {
        int l = matrix.length;
        //先正对角线翻转
        for (int i = 0; i < l; i++) {
            for (int j = 0; j < i; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        //在垂直翻转
        for (int i = 0; i < l; i++) {
            for (int j = 0; j < l / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][l - 1 - j];
                matrix[i][l - 1 - j] = temp;
            }
        }
    }

    /**
     * 编写一种算法，若M × N矩阵中某个元素为0，则将其所在的行与列清零
     * @example: 输入：
     * [
     *   [0,1,2,0],
     *   [3,4,5,2],
     *   [1,3,1,5]
     * ]
     * 输出：
     * [
     *   [0,0,0,0],
     *   [0,4,5,0],
     *   [0,3,1,0]
     * ]
     * @tips: 不能直接设置为0，这样最后整个数组都变为0
     * @param matrix
     */
    public static void setZeroes(int[][] matrix) {
        int rl = matrix.length;
        int cl = matrix[0].length;
        //存放行判断信息
        boolean[] row = new boolean[rl];
        //存放列判断信息
        boolean[] col = new boolean[cl];
        for (int i = 0; i < rl; i++) {
            for (int j = 0; j < cl; j++) {
                //当遍历值为0时，将该行和列标记为true
                if (matrix[i][j] == 0) {
                    row[i] = true;
                    col[j] = true;
                }
            }
        }
        //进行删除操作
        for (int i = 0; i < rl; i++) {
            for (int j = 0; j < cl; j++) {
                if (row[i] || col[j]) matrix[i][j] = 0;
            }
        }
    }

    /**
     * 对角线遍历：给你一个大小为 n x m 的矩阵 mat ，请以对角线遍历的顺序，用一个数组返回这个矩阵中的所有元素
     * @example 输入：mat = [[1,2,3],[4,5,6],[7,8,9]]
     * 输出：[1,2,4,7,5,3,6,8,9]
     * @param mat
     * @return 顺序数组
     * @tips 斜着遍历，获取遍历次数n+m-1
     */
    public static int[] findDiagonalOrder(int[][] mat) {
        //获取行列数
        int rl = mat.length;
        int cl = mat[0].length;
        //初始化一个输出数组
        int[] res = new int[rl * cl];
        //数组索引
        int idx = 0;
        //进行循环
        for (int i = 0; i < rl + cl - 1; i++) {
            if (i % 2 == 0){ //遍历次数为偶数次时，从下往上
                for (int x = Math.min(i, rl - 1); x >= Math.max(0, i - cl + 1); x--) {
                    res[idx++] = mat[x][i-x];
                }
            }else { //遍历次数为奇数次时，从上往下
                for (int x = Math.max(0, i - cl + 1); x <= Math.min(i, rl - 1); x++){
                    res[idx++] = mat[x][i-x];
                }
            }
        }
        return res;
    }

}
