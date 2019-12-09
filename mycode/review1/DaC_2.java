package nju.review1;

import java.util.Scanner;

/**
 * 序号乘方，这个题必须是用二分法+公式做
 */
public class DaC_2 {

    //使用普通方法会超时，1<=T<=100001<=P<=1000000000000000

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int loop = Integer.parseInt(sc.nextLine().trim());
        while (loop-- > 0) {
            long p = Long.parseLong(sc.nextLine().trim());  //注意
            System.out.println(solve2(p));
        }
    }


    private static int solve1(long p) {
        int res = 0;
        for (int i = 0; i < Math.sqrt(p) + 1; i++) {        //+1
            if ((Math.pow(i, 3) * 2 + Math.pow(i, 2) * 3 + i) / 6 > p) { //不能直接写i * (i + 1) * (2 * i + 1) / 6，傻逼lcy不给过
                res = i - 1;
                break;
            }
        }
        return res;
    }

    //下面二分法也可以
    private static int solve2(long p) {
        int res = 0;
        int left = 0;
        int right = (int) Math.sqrt(p);
        while (left <= right) {
            int mid = (left + right) / 2;
            int n = mid;
            long temp = (long) ((Math.pow(n, 3) * 2 + Math.pow(n, 2) * 3 + n) / 6); //不能直接写i * (i + 1) * (2 * i + 1) / 6，隐式转换
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
}
