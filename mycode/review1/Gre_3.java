package nju.review1;

import java.util.Scanner;

/**
 * 时间与收益，要求最大收益是多少
 */
public class Gre_3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int loop = sc.nextInt();
        while (loop-- > 0) {
            int task = sc.nextInt();
            int[][] matrix = new int[task][3];
            int maxTime = 0;    //一定要记录最大时间
            for (int i = 0; i < task; i++) {
                matrix[i][0] = sc.nextInt();
                matrix[i][1] = sc.nextInt();
                matrix[i][2] = sc.nextInt();
                if (matrix[i][1] > maxTime) {
                    maxTime = matrix[i][1];
                }
            }
            solve(matrix,maxTime);
        }
    }

    private static void solve(int[][] m,int maxTime) {
        int n = m.length;
        //按照收益排序 冒泡,并且要记录最大时间
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
        int count = 0;
        int res = 0;
        boolean[] time = new boolean[maxTime];
        //遍历所有任务
        for (int i = 0; i < n; i++) {
            //当前任务只能在哪个时间段之前完成
            for (int j = Math.min(maxTime - 1, m[i][1] - 1); j >= 0; j--) {
                //如果这个位置可以填
                if (!time[j]) {
                    time[j] = true;
                    maxTime--;      //这句可写可不写，最好写，表明现在还能最多做多少
                    count++;
                    res += m[i][2];
                    break;          //找到了，一定要立马break！！不要把剩余的也填了
                }
            }
        }
        System.out.println(count + " " + res);
    }
}
