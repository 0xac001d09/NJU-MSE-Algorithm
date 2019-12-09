package nju.review1;

import java.util.Scanner;

/**
 * 数学公式.........没过
 * 这个题考的是快速幂取模算法，与mat_4矩阵快速幂有相似之处
 * https://www.cnblogs.com/lz3018/p/5720652.html
 */
public class DaC_3 {

    //快速幂取模算法（快速幂算法改一下）
    private static long solve(long x, int y, int p) {
        if (y == 0) {
            if (p == 1) {
                return 0;
            } else {
                return 1;
            }
        }
        long res = 1;
        while (y != 0) {
            if (y % 2 == 1) {
                res = (res * x) % p;
            }
            x = (x * x) % p;
            y /= 2;
        }
        return res;
    }



    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int loop = sc.nextInt();
        while (loop-- > 0) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            int p = sc.nextInt();

            System.out.println(solve(x, y, p));
        }
    }
}
