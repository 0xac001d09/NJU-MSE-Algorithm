package nju.review1;

/**
 * 素数和问题
 * 素数就是在所有比1大的整数中,除了1和它本身以外,不再有别的约数,
 * 给定一个大于2的偶数，来寻找两个素数,使得其和等于该偶数，请给出第一个素数对
 * 思路就是判断(i,n-i)是否同时为素数,有则返回结果
 */
import java.util.Scanner;

public class mat_6 {

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
        if (n <= 1) {
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