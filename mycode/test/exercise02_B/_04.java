package nju.test.exercise02_B;

//序号乘方

import java.util.Scanner;

/**
 * There are Infinite People Standing in a row, indexed from 1.
 * A person having index 'i' has strength of (i*i).You have Strength 'P'.
 * You need to tell what is the maximum number of People You can Kill With your Strength P.
 * You can only Kill a person with strength 'X' if P >= 'X' and after killing him, Your Strength decreases by 'X'.
 * 一列人站在那，序号从i从1开始编，每个人对应的能量为i*i。你拥有能量P，P > i * i 就可以杀死对应的这个人，然后你的能量变为P - i * i
 * 问，你能杀死多少个人？
 * 1<=P<=1000000000000000
 */
public class _04 {


    public static int solve(long p) {
        //二分查找方法,比如给个100，最多不超过10个，10的平方是100嘛，利用二分搜素缩小范围
        int res = 0;
        int left = 0;
        int right = (int) Math.sqrt(p);
        while (left <= right) {
            int mid = (left + right) / 2;
            int n = mid;
            long temp = (n * (n + 1) * (2 * n + 1)) / 6;     //1平方+2平方+3平方+。。。+n平方的和为 n*(n+1)*(2n+1)/6
            if (temp > p) {
                right = mid - 1;
            } else if (temp < p) {
                res = mid;
                left = mid + 1;
            } else {        //正好相等,,那就直接
                res = mid;
                break;
            }
        }
        return res;
    }
    private static int solve2(long p) {
        int res = 0;
        int left = 0;
        int right = (int) Math.sqrt(p);
        while (left <= right) {
            int mid = (left + right) / 2;
            int n = mid;
            long temp = (long) ((Math.pow(n, 3) * 2 + Math.pow(n, 2) * 3 + n) / 6);
            if (temp > p) {
                right = mid - 1;
            } else if (temp < p) {
                res = mid;
                left = mid + 1;
            } else {
                res = mid;
                break;
            }
        }
        return res;
    }



    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int loop = sc.nextInt();
        while (loop-- > 0) {
            System.out.println(solve(sc.nextLong()));
        }
    }

}
