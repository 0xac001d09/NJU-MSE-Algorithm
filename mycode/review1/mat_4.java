package nju.review1;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 牛的繁殖问题
 * 一头母牛在第二年能生一头小母牛，假设没有一头小牛死亡，问如果一开始只有一只牛，n年末，能有多少只牛
 * 比如2年后 就有两只，三年后3只，4年后，就有5只.....斐波那契数列
 *
 * 1 <= T <= 10^3
 * 1 <= N <= 10^18
 *
 * 由于 N 太大，这道题是用快速矩阵幂来解决，快速矩阵幂见这篇文章https://blog.csdn.net/nyist_tc_lyq/article/details/52981353
 *     //这个繁殖问题,f(0) = fib(1),f(1) = fib(2)。。。所以求f(n),只要求fib(n+1)
 *     // n = 0,f(0) = 1
 *     // n = 1,f(1) = 1
 *     // n = 2,f(2) = 2
 *     // n = 3,f(3) = 3
 *     // n = 4,f(4) = 5
 *
 */

public class mat_4 {
    static Map<Long, Long> map = new HashMap<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int loop = sc.nextInt();
        while (loop-- > 0) {
            long n = sc.nextLong();
            System.out.println(solve1(n + 1));
        }

    }

    //矩阵快速幂原理
    static long mod = 1000000007;       //相当于快速幂中的p
    //正常fib求法
    private static long solve1(long n) {   //n相当于快速幂中x^y的y
        n = n - 2;      //我们只需要计算n-2次，得到n-2次运算后的结果矩阵{{f(n-1,f(n-2)},{f(n-2),f(n-3)}},这样，f(n)就知道了就是e[0][0] + e[0][1]
        long[][] e = {{1, 0}, {0, 1}};  //单位矩阵，对应快速幂中的res = 1，这个结果就相当于是
        long[][] a = {{1, 1}, {1, 0}};  //需要求的幂矩阵，对应快速幂中的x^y的x
        while (n > 0) {
            if ((n & 1) == 1) {     //如果是奇数
                e = multiply(e, a);
            }
            a = multiply(a, a);
            n /= 2;
        }
        return (e[0][0] + e[0][1]) % mod;
    }
    //矩阵相乘
    private static long[][] multiply(long[][] a, long[][] b) {
        long[][] c = new long[2][2];
        c[0][0] = (a[0][0] * b[0][0] + a[0][1] * b[1][0]) % mod;
        c[0][1] = (a[0][0] * b[0][1] + a[0][1] * b[1][1]) % mod;
        c[1][0] = (a[1][0] * b[0][0] + a[1][1] * b[1][0]) % mod;
        c[1][1] = (a[1][0] * b[0][1] + a[1][1] * b[1][1]) % mod;
        return c;
    }

    //直接运用矩阵快速幂的思想,公式求
    //F[2n] = F[n+1]² - F[n-1]² = (2F[n-1] + F[n]) · F[n]
    //F[2n+1] = F[n+1]² + F[n]² ②
    public static long fib(long n) {
        if (n == 0) {
            return 0;
        }
        if (n == 2 || n == 1) {
            return 1;
        }
        if (map.containsKey(n)) {
            return map.get(n);
        }
        //如果n是奇数
        if ((n & 1) == 1) {
            long k = (n + 1) / 2;
            map.put(n, (fib(k) * fib(k) + fib(k - 1) * fib(k - 1)) % 1000000007);
        } else {
            long k = n / 2;
            map.put(n, (fib(k) * ((fib(k - 1) << 1) + fib(k)) % 1000000007));
        }
        return map.get(n);
    }

}
