package nju.test.exercise04_B;


import java.util.Scanner;

/**
 * 矩阵计算
 * C(0) = 2、C(1) = 0、C(2) = 1、C(3) = 7、C(4) = 37、C(5) = 144、C(6) = 621、C(7) = 2666、C(8) = 11424、C(9) = 48905、C(10) = 209467、C(11) = 897137、C(12) = 3842348、C(13) = 16456357
 * 规律是0011101 0011101
 */
class _03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            System.out.println(solve(n));
        }
    }

    private static int solve(int n) {
        int odd = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                int r = (i * j) % 7;
                r = (r * r * r) % 7;
                if (r != 0 && r != 1 && r != 5) {
                    odd++;
                }

            }
        }
        return odd;
    }
}