package nju.test.exercise05_B;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

/**
 * 格子里的整数
 * 给定大小为n的正方形网格。每个格子中包含通过这个格子所需要的成本，找一条路径从左上角到右下角单元格的路径，这条路径的总成本最小
 * 这个不是dp，dp规定是只能往下和往右，这个是贪心，四个方向都可以,
 */

class Path {
    int x,y, dis;

    public Path(int x, int y, int dis) {
        this.x = x;
        this.y = y;
        this.dis = dis;
    }
}

public class _02 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int loop = sc.nextInt();
        while (loop-- > 0) {
            int n = sc.nextInt();
            int[][] square = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    square[i][j] = sc.nextInt();
                }
            }
            System.out.println(solve(square));
        }
    }

    private static int solve(int[][] square) {
        //四个方向
        int[] xPath = {-1, 0, 0, 1};
        int[] yPath = {0, -1, 1, 0};

        int n = square.length;  //正方形边长
        int[][] f = new int[n][n];  //存放结果

        //初始化结果矩阵
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                f[i][j] = Integer.MAX_VALUE;
            }
        }
        f[0][0] = square[0][0];
        Queue<Path> queue = new LinkedList<>();
        queue.add(new Path(0, 0, f[0][0]));

        while (!queue.isEmpty()) {
            Path p = queue.poll();
            //四个方向
            for (int i = 0; i < 4; i++) {
                int x = p.x + xPath[i];
                int y = p.y + yPath[i];
                if (isValid(x, y, square) && f[p.x][p.y] + square[x][y] < f[x][y]) {
                    f[x][y] = f[p.x][p.y] + square[x][y];
                    queue.add(new Path(x, y, f[x][y]));
                }
            }
        }
        return f[n - 1][n - 1];
    }

    private static boolean isValid(int x, int y, int[][] square) {
        //正方形的边长
        int n = square.length;
        if (x >= 0 && x < n && y >= 0 && y < n) {
            return true;
        }
        return false;
    }
}
