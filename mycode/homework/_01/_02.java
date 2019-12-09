package nju.homework._01;

import java.util.Scanner;

// 子矩阵问题
public class _02 {
    
    //暴力法，列举每个所有可能的矩形，可以通过遍历所有的(x1,y1)(x2,y2)坐标，以他们为对顶角的矩阵
    public static int maxRectangle(int[][] matrix) {
        int max = Integer.MIN_VALUE;
        for (int x1 = 0; x1 < matrix.length; x1++) {
            for (int y1 = 0; y1 < matrix[x1].length; y1++) {
                //上面遍历所有的x1，y1顶点
                //下边遍历所有x2，y2顶点
                for (int x2 = x1; x2 < matrix.length; x2++) {
                    for (int y2 = y1; y2 < matrix[x1].length; y2++) {
                        //判断它们组成的矩形是不是每个位置上都是1
                        if (isAllOne(matrix, x1, y1, x2, y2)) {
                            int area = (x2 - x1 + 1) * (y2 - y1 + 1);
                            if (area > max) {
                                max = area;
                            }
                        }
                    }
                }
            }
        }
        return max;
    }

    public static boolean isAllOne(int[][] matrix, int x1, int y1, int x2, int y2) {
        for (int i = x1; i <= x2; i++) {
            for (int j = y1; j <= y2; j++) {
                if (matrix[i][j] == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int loop = sc.nextInt();
        while (loop-- > 0) {
            int rows = sc.nextInt();
            int cols = sc.nextInt();
            int[][] matrix = new int[rows][cols];
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    matrix[i][j] = sc.nextInt();
                }
            }
            int maxVal = maxRectangle(matrix);
            System.out.println(maxVal);
        }
    }
}
