package nju.review1;

import java.util.Scanner;

/**
 * 按照另一个数组排序
 */
public class sea_5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int loop = Integer.parseInt(sc.nextLine().trim());
        while (loop-- > 0) {
            String s1 = sc.nextLine();
            String s2 = sc.nextLine();
            String s3 = sc.nextLine();
            String[] ss1 = s1.split(" ");
            String[] ss2 = s2.split(" ");
            String[] ss3 = s3.split(" ");
            int[] nums1 = new int[Integer.parseInt(ss1[0])];
            int[] nums2 = new int[Integer.parseInt(ss1[1])];

            for (int i = 0; i < nums1.length; i++) {
                nums1[i] = Integer.parseInt(ss2[i]);
            }
            for (int i = 0; i < nums2.length; i++) {
                nums2[i] = Integer.parseInt(ss3[i]);
            }
            solve(nums1,nums2);
        }
    }

    //使用计数排序
    private static void solve(int[] nums1, int[] nums2) {
        int[] countArr = new int[1001];
        int[] res = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            countArr[nums1[i]]++;
        }
        int index = 0;
        for (int i = 0; i < nums2.length; i++) {
            int times = countArr[nums2[i]];
            for (int j = 0; j < times; j++) {
                res[index++] = nums2[i];
            }
            countArr[nums2[i]] = 0;
        }

        //处理剩余的
        for (int i = 0; i < countArr.length; i++) {
            int times = countArr[i];
            while (times > 0) {
                res[index++] = i;
                times--;
            }
        }

        //打印结果
        for (int i = 0; i < res.length; i++) {
            if (i != res.length - 1) {
                System.out.print(res[i] + " ");
            } else {
                System.out.println(res[i]);
            }
        }
    }

}
