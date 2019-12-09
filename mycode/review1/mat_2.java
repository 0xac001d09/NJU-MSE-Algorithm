package nju.review1;

import java.util.Scanner;

/**
 * 无限递归字符串查询https://blog.csdn.net/qq_33935895/article/details/102937950
 *
 * Consider a string A = "12345". An infinite string s is built by performing infinite steps on A recursively. In i-th step,
 * A is concatenated with ‘$’ i times followed by reverse of A. A=A|$...$|reverse(A), where | denotes concatenation.
 *
 * 题目中的A=A|$...$|reverse(A)是什么意思呢,如下所示
 * A1 = 12345
 * A2 = 12345$54321 = A1|$*1|reverse(A1)
 * A3 = 12345$54321$$12345$54321   = A2|$*2|reverse(A2) =  A2|$*2|A2
 * ...
 * An = An-1|$*(n-1)|reverse(An-1) = An-1|$*(n-1)|An-1
 *
 * 给定查询位置index来返回这个位置上的字符是谁
 * 首先需要构造这个字符串,满足len(Ai-1) < index <= len(Ai) ，也就是说刚刚好满足查询条件
 * 有两种情况：
 *      第一种：len(Ai-1) < index <= len(Ai-1) + len($),说明index的位置一定是 $,比如index为5时，A1 = 12345，A2 = 12345$54321，index一定在 $ 上
 *      第二种：len(Ai-1) + len($) < p ,观察An的结构(An = An-1|$*n-1|An-1),说明q所在的位置是在An-1中,此时去An-1中寻找,将查询位置q更新为q = q-(len(Ai-1 )+len($)),
 *
 *
 * 本题注意n的范围： 1<=POS<=10^12
 */
public class mat_2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int loop = sc.nextInt();
        while (loop-- > 0) {
            solve(sc.nextLong());
        }
    }

    //注意数字范围
    private static void solve(long n) {
        if (n == 0) {
            System.out.println("");
            return;
        }
        //初始字符串
        char[] chs = {'1', '2', '3', '4', '5', '$', '5', '4', '3', '2', '1'};
        int len = chs.length;
        while (n > len) {
            long[] temp = getLenAndDollar(n);
            long newLen = temp[0];
            long dollar = temp[1];

            long val =(long)(newLen - dollar) / 2 + dollar;   //去掉后面半段，但算上dollar，比如12345$54321，去掉后为12345$

            if (n <= val) {     //第一种情况
                System.out.println(chs[5]);
                return;
            } else {
                n -= val;  // 若所求长度比A长度大,则所求的字符位置在reverse(A)中
            }
        }
        System.out.println(chs[(int)n - 1]);
        return;
    }

    private static long[] getLenAndDollar(long n) {
        long len = 5;
        long dollar = 0;
        while (len < n) {
            dollar++;
            len = len * 2 + dollar;
        }
        long[] temp = new long[2];
        temp[0] = len;
        temp[1] = dollar;
        return temp;
    }
}
