package nju.review1;

import java.util.Scanner;

/**
 * 矩阵计算
 * 找规律题
 * C中的规律是0011101
 */
public class dyp_7 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
     int loop = Integer.parseInt(sc.nextLine().trim());
        while (loop-- > 0) {
        solve(Integer.parseInt(sc.nextLine().trim()));
    }
}

    private static void solve(int n) {
        int count = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                int temp = (int) Math.pow(i * j, 3) % 7;
                if (temp != 0 && temp != 1 && temp != 5) {
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}
