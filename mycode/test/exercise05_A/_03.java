package nju.test.exercise05_A;

import java.util.HashSet;
import java.util.Scanner;

/**
 * 时间与收益
 *
 * 给定n个工作，每个工作有截止日期以及收益，一次只能安排一个工作，每份工作耗费一个时间单位，找到最大收益和完成工作的数量
 *
 * 如果当前作业可以满足当前结果顺序而又不错过最后期限，则将当前作业添加到结果中。否则忽略当前工作。
 */
public class _03 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int loop = sc.nextInt();
        while (loop-- > 0) {
            int num = sc.nextInt(); //总共工作数
            int[][] m = new int[num][3];

            int maxTime = 0;

            for (int i = 0; i < num; i++) {
                m[i][0] = sc.nextInt();
                m[i][1] = sc.nextInt();
                if (m[i][1] > maxTime) {
                    maxTime = m[i][1];
                }
                m[i][2] = sc.nextInt();
            }
            solve(m, maxTime);
        }
    }

    //任务矩阵和maxTime
    private static void solve(int[][] m,int maxTime) {
        //排序
        int n = m.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (m[j][2] < m[j + 1][2]) {
                    //先交换利润
                    int temp = m[j][2];
                    m[j][2] = m[j + 1][2];
                    m[j + 1][2] = temp;
                    //再交换时间
                    int tmp = m[j][1];
                    m[j][1] = m[j + 1][1];
                    m[j + 1][1] = tmp;
                }
            }
        }
        //maxTime就是最多任务数，因为完成每个任务耗费的是单位时间
        boolean[] time = new boolean[maxTime];
        int profit = 0;
        int count = 0;
        for (int i = 0; i < n; i++) {
            //从后往前填，如果该位置没被填过，则可以做，否则再往前面找位子
            for (int j = Math.min(maxTime - 1, m[i][1] - 1); j >= 0; j--) {
                if (!time[j]) {
                    time[j] = true;
                    profit += m[i][2];
                    count++;
                    break;
                }
            }
        }
        System.out.println(count + " " + profit);
    }
}
