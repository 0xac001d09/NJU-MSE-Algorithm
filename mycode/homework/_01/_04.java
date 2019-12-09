package nju.homework._01;

import java.util.Scanner;
// 汉诺塔变形
/**
 * 1、1个圆盘时，移动两次，到达目的地
 * 2、当有n(n>1)个圆盘时，需要把1—n-1圆盘从左边移动到右边，再将最底下的圆盘n移动到中间，把1—n-1圆盘从右边移动到左边，把圆盘n从中间移动到右边，1—n-1圆盘从左边移动到右边。
 */
public class _04 {


    public static int hanNuoTa(int n) {
        if (n == 1) {
            return 2;
        } else{
            int num1 = hanNuoTa(n - 1);     //把n-1个圆盘从左移动到右（经过中间）
            int num2 = hanNuoTa(n - 1);     //把n-1个圆盘从右移动到左（经过中间）（这时候已经把底下圆盘移动到中间了，算1次，最后加上）
            int num3 = hanNuoTa(n - 1);     //把n-1个圆盘从左移动到右（经过中间）（这时候底下的圆盘已经从中间移动到最右了，算1次）
            return num1 + num2 + num3 + 2;      //2次是算上底下的那个盘移动的
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int loop = sc.nextInt();
        while (loop-- > 0) {
            int n = sc.nextInt();
            int res = hanNuoTa(n);
            System.out.println(res);
        }
    }
}
