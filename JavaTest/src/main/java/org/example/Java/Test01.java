package org.example.Java;


public class Test01 {
    public static void main(String[] args) {
//        printYangHui(6);
//        System.out.println(factorial(5));
//        System.out.println(fibonacci(7));
//        System.out.println(fib(7));
//        System.out.println(peach2());
//        System.out.println(peach(1));
        fib(2 ,'a','b','c');
    }

    /**
     * 使用二维数组打印杨辉三角
     * [1]
     * [1,1]
     * [1,2,1]
     * [1,3,3,1]
     * [1,4,6,4,1]
     */
    public static void printYangHui(Integer len){
        //对第一维的数组的长度进行初始化
        int arr[][] = new int[len][];
        //对行进行循环
        for (int i = 0; i < arr.length; i++) {
            //对第二维的数组的长度进行初始化
            arr[i] = new int[i+1];
            //对列进行循环
            for (int j = 0; j < arr[i].length; j++) {
                if (j == 0 || j == i) {
                    //设置首位为1
                    arr[i][j] = 1;
                }else {
                    //设置中间的数值为两数之和
                    arr[i][j] = arr[i-1][j-1] + arr[i-1][j];
                }
                //输出
                System.out.print(arr[i][j] + " ");
            }
            //换行
            System.out.println();
        }
    }

    /**
     * 阶乘递归 算法
     * @param n
     * @return
     */
    public static int factorial(int n){
        if (n == 0) {
            return 1;
        }
        return n * factorial(n-1);
    }

    /**
     * 斐波那契数列 递归法
     * @param n
     * @return
     */
    public static int fibonacci(int n) {
        if (n == 1 || n == 2) {
            return 1;
        }else {
            return fibonacci(n - 1) + fibonacci(n - 2);
        }
    }

    /**
     * 斐波那契数列 循环法 更加优化
     * @param n
     * @return
     */
    public static int fib(int n) {

        if(n==1||n==2)  return 1;
        int f1 = 1;
        int f2 = 1;
        int res = 0;  //存放结果
        for(int i=3;i<=n;++i){
            res = f1 + f2;
            f2 = f1;
            f1 = res;
        }
        return res;
    }

    /**
     * 猴子吃桃 （递推算法和循环算法）
     * 一堆桃子，猴子第一天吃一半多多一个，每次如此，第十天时还没吃发现只有一个，问一共多少桃子
     * @return
     */
    public static int peach(int day){
        if (day == 10) {
            return 1;
        }
        return (peach(day+1) + 1) * 2;
    }
    
    public static int peach2(){
        int total = 1;
        for (int i = 0; i < 9; i++) {
            total = (total + 1) * 2;
        }
        return total;
    }

    public static void tower(int n, char a, char b, char c){
        if (n == 1) {
            System.out.println(a + "=>" + c);
        }else {
            tower(n - 1, a, c, b);
            System.out.println(a + "=>" + b);
            tower(n - 1, a, c, b);
        }
    }

    public static void fib(int num, char a, char b, char c) {
        if(num == 1) {
            System.out.println("第" + num + "个圆盘从" + a + "移动到" + c);
        }else {
            fib(num - 1, a, c, b);
            System.out.println("第" + num + "个圆盘从" + a + "移动到" + c);
            fib(num - 1, b, a, c);
        }
    }


}

