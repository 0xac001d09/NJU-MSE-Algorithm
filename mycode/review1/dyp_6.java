package nju.review1;

import java.util.Scanner;

/**
 * 无重复字符子集问题
 *
 * 就是有多少种组合，求组合中和最大的那个
 */
public class dyp_6 {
    private static int sum;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int loop = sc.nextInt();
        while (loop-- > 0) {
            int n = sc.nextInt();   //数组大小
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            sum = 0;
            for (int i = 0; i <= n; i++) {
                boolean[] visit = new boolean[10];
                dfs(n, i, 0, visit, arr);
            }
            System.out.println(sum);
        }
    }

    private static void dfs(int n, int cur, int cursum, boolean[] visit, int[] arr) {
        if (cur == n) {
            return;
        }

        //用来状态重置的数组
        boolean[] befvisit = new boolean[10];
        for (int i = 0; i < 10; i++) {
            befvisit[i] = visit[i];
        }

        int temp = arr[cur];
        //临时数组，把temp的每一位标记为true
        boolean[] tempvisit = new boolean[10];
        while (temp != 0) {
            int last = temp % 10;
            tempvisit[last] = true;
            temp = temp / 10;
        }

        for (int i = 0; i < 10; i++) {
            //如果之前的数组和这个临时数组有相同的元素，那就return
            if (visit[i] && tempvisit[i]) {
                return;
            }
            visit[i] |= tempvisit[i];
        }
        cursum += arr[cur];
        sum = Math.max(cursum, sum);
        for (int i = cur + 1; i <= n; i++) {
            dfs(n, i, cursum, visit, arr);
        }
        //状态重置
        for (int i = 0; i < 10; i++) {
            visit[i] = befvisit[i];
        }
    }

}
