package nju.homework._02;

import java.util.*;

//求最长公共子序列并输出所有解
public class _01 {

    // static TreeSet<String> treeSet = new TreeSet<>();    //不要这么写，有多个uc则导致多组数据存放在一个set中了
    static TreeSet<String> treeSet;
    static int[][] dp;
    static int[][] path;

    private static void solve(String s1, String s2) {
        dp = new int[s1.length() + 1][s2.length() + 1];
        path = new int[s1.length() + 1][s2.length() + 1];       //路径
        int rows = dp.length;
        int cols = dp[0].length;
        //dp和path的第一行第一列都是0，从下标1开始
        //s1放在行，s2放在列
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    path[i][j] = 1;
                } else {
                    //如果左侧大于上面，就取左面，并记录2
                    if (dp[i][j - 1] > dp[i - 1][j]) {
                        dp[i][j] = dp[i][j - 1];
                        path[i][j] = 2;
                    }
                    //如果左侧小于上面，就取上面，并记录3
                    else if (dp[i][j - 1] < dp[i - 1][j]) {
                        dp[i][j] = dp[i - 1][j];
                        path[i][j] = 3;
                    }
                    //如果左侧和上面都相等，就任意取一个，但是路径记录4
                    else {
                        dp[i][j] = dp[i - 1][j];
                        path[i][j] = 4;
                    }
                }
            }
        }
    }

    private static void printRes(String str, String temp, int i, int j) {
        if (str == null || str.length() == 0) {
            return;
        }
        //只添加左上角的
        while (i > 0 && j > 0) {
            //如果来自左上角
            if (path[i][j] == 1) {
                temp += str.charAt(i-1);  //s1放在行，s2放在列的，所以这里是i
                i--;
                j--;
            } else if (path[i][j] == 2) {   //来自左面
                j--;
            } else if (path[i][j] == 3) {   //来自上面
                i--;
            } else {                        //来自上面或左面，回溯
                printRes(str, temp, i - 1, j);
                printRes(str, temp, i, j - 1);
                return;
            }
        }
        treeSet.add(new StringBuilder(temp).reverse().toString());
    }



    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int loop = Integer.parseInt(sc.nextLine().trim());
        while (loop-- > 0) {
            String s1 = sc.nextLine();
            String s2 = sc.nextLine();
            solve(s1, s2);
            treeSet = new TreeSet<>();
            printRes(s1, "", dp.length - 1, dp[0].length - 1);
            for (String s : treeSet) {
                System.out.println(s);
            }
        }
    }
}
