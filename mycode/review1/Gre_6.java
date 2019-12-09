package nju.review1;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 格子里的整数
 */

class Path {
    int x;
    int y;
    int dis;

    public Path(int x, int y,int dis) {
        this.x = x;
        this.y = y;
        this.dis = dis;
    }
}

public class Gre_6 {

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
            solve(square);
        }
    }

    private static void solve(int[][] square) {
        int n = square.length;
        //四个方向数组,上下左右
        int[] xPath = {0, 0, -1, 1};
        int[] yPath = {1, -1, 0, 0};

        int[][] f = new int[n][n];
        //初始化
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                f[i][j] = Integer.MAX_VALUE;
            }
        }
        f[0][0] = square[0][0];

        Path path = new Path(0, 0, square[0][0]);
        Queue<Path> queue = new LinkedList<>();
        queue.offer(path);

        while (!queue.isEmpty()) {
            Path p = queue.poll();
            //四个方向
            for (int i = 0; i < 4; i++) {
                int x = p.x + xPath[i];
                int y = p.y + yPath[i];
                if (isValid(n, x, y) && f[p.x][p.y] + square[x][y] < f[x][y]) {
                    f[x][y] = f[p.x][p.y] + square[x][y];
                    queue.offer(new Path(x, y, f[p.x][p.y] + square[x][y]));
                }
            }
        }
        System.out.println(f[n - 1][n - 1]);
    }

    //判断是否合法
    private static boolean isValid(int n, int x, int y) {
        if (x >= 0 && x < n && y >= 0 && y < n) {
            return true;
        } else {
            return false;
        }
    }
}
