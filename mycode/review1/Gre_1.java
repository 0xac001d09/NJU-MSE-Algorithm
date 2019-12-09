package nju.review1;

import java.util.Scanner;

/**
 * 管道网络
 */
public class Gre_1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int loop = sc.nextInt();
        while (loop-- > 0) {
            int n = sc.nextInt();   //一共几栋房子
            int m = sc.nextInt();   //几组数据

            int[] start = new int[n + 1];
            int[] end = new int[n + 1];
            int[] dis = new int[n + 1];
            int index = 1;
            for (int i = 0; i < m; i++) {
                int startIndex = sc.nextInt();
                int endIndex = sc.nextInt();
                int distance = sc.nextInt();
                start[startIndex] = endIndex;
                end[endIndex] = startIndex;
                dis[startIndex] = distance;
            }
            solve(start, end, dis);
        }
    }

    private static void solve(int[] start, int[] end, int[] dis) {
        int count = 0;
        //start中每个下标存的是对应的目的地，end中每个下标存的是对应来源
        int n = start.length;
        for (int i = 1; i < n; i++) {
            //其实就是求差集合
            if (start[i] != 0 && end[i] == 0) {
                count++;
            }
        }
        System.out.println(count);

        for (int i = 1; i < n; i++) {
            //如果不是起点
            if (start[i] == 0 || end[i] != 0) {
                continue;
            }
            //找到起点了
            int j = i;
            int minDis = Integer.MAX_VALUE;
            while (start[j] != 0) {
                minDis = Math.min(minDis, dis[j]);
                j = start[j];
            }
            System.out.println(i + " " + j + " " + minDis);
        }
    }
}
