package nju.test.exercise02_A;

import java.math.BigInteger;
import java.util.Scanner;

//数学公式
public class _01 {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int loop = Integer.parseInt(sc.nextLine().trim());
        while (loop-- > 0) {
            String s = sc.nextLine();
            String[] nums = s.split(" ");
            int a = Integer.parseInt(nums[0]);
            int b = Integer.parseInt(nums[1]);
            int c = Integer.parseInt(nums[2]);
            long l = powAndMod(a, b, c);
            System.out.println(l);
            // zzzzzzz(a, b, c);
        }
    }

    //（a ^ b）％ m  = （a％m）*（a％m）*（a％m）*…（a％m），共b次。
    public static int powAndMod(int a, int b, int c) {
        if (b == 0) {
            return 1 % c;
        }
        long y = 0;
        if (b % 2 == 0) {
            y = powAndMod(a, b / 2, c);
            y = (y * y) % c;
        } else {
            y = a % c;
            y = (y * powAndMod(a, b - 1, c)) % c;
        }
        return (int) ((y + c) % c);
    }

    //使用BigInteger 但是会超过时间限制
    public static void test(int a, int b, int c) {
        String A = String.valueOf(a);
        String B = String.valueOf(b);
        String C = String.valueOf(c);
        BigInteger aa = new BigInteger(A);
        BigInteger bb = new BigInteger(B);
        BigInteger cc = new BigInteger(C);
        BigInteger temp = aa.pow(b);
        BigInteger res = temp.mod(cc);
        System.out.println(res);
    }

}
