package nju.test.exercise03_B;

import java.util.Scanner;
//素数和问题
public class _02 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int loop = sc.nextInt();
        while (loop-- > 0) {
            int n = sc.nextInt();
            solve(n);
        }
    }

    //判断一个数是否为素数
    private static boolean isPrime(int n) {
        double sqrt = Math.sqrt(n);
        if (n < 2) {
            return false;
        }
        if (n == 2 || n == 3) {
            return true;
        }
        for (int i = 2; i <= sqrt; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    private static void solve(int n) {
        //n为偶数
        int[] res = new int[2];
        for (int i = 3; i < n; i++) {
            if (isPrime(i) && isPrime(n - i)) {
                res[0] = i;
                res[1] = n - i;
                break;
            }
        }
        System.out.println(res[0] + " " + res[1]);
    }
}
