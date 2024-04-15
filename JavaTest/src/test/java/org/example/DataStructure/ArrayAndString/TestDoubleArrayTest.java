package org.example.DataStructure.ArrayAndString;

import org.example.DataStructure.ArrayAndString.TestDoubleArray;
import org.junit.Test;

import java.util.Arrays;

public class TestDoubleArrayTest {

    int[][] array1 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
    int[][] array2 = {{0, 1, 2, 0}, {4, 4, 5, 2}, {7, 8, 9, 9}};

    /**
     * 通用的打印二维数组方法
     * @param array
     */
    private void printDoubleArr(int[][] array){
        for(int[] arr:array){
            System.out.println(Arrays.toString(arr));
        }
    }

    @Test
    public void rotate() {
        int[][] arr = this.array1;
        TestDoubleArray.rotate(arr);
        printDoubleArr(arr);
    }

    @Test
    public void setZeroes() {
        int[][] arr = this.array2;
        TestDoubleArray.setZeroes(arr);
        printDoubleArr(arr);
    }

    @Test
    public void findDiagonalOrder() {
        int[][] arr = this.array1;
        int[] diagonalOrder = TestDoubleArray.findDiagonalOrder(arr);
        System.out.println(Arrays.toString(diagonalOrder));
    }
}