package nju.test.exercise04_B;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

/**
 * 无重复字符子集问题
 * <p>
 * 找到数组中满足条件的所有元素的和，这些元素组成了子集，The elements present in the subset should not have any digit in common.
 * 子集中存在的元素不应有任何共同的数字。
 */
//TODO
public class _02 {

    private static int sum;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int abc = sc.nextInt();
        while (abc-- > 0) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++)
                arr[i] = sc.nextInt();

            sum = 0;
            for (int i = 0; i <= n; i++) {
                boolean[] visit = new boolean[10];
                dfs(n, i, 0, visit, arr);
            }
            System.out.println(sum);
        }
    }

    private static void dfs(int n, int cur, int cursum, boolean[] visit, int[] arr) {
        if (cur == n)
            return;
        int temp = arr[cur];
        boolean[] befvisit = new boolean[10];
        for (int i = 0; i < 10; i++) {
            befvisit[i] = visit[i];
        }

        boolean[] tempvisit = new boolean[10];
        while (temp != 0) {
            int last = temp % 10;
            tempvisit[last] = true;
            temp = temp / 10;
        }
        for (int i = 0; i < 10; i++) {
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
        for (int i = 0; i < 10; i++) {
            visit[i] = befvisit[i];
        }

    }
}
