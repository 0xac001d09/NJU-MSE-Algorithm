package nju.review1;

import java.util.Scanner;

/**
 * 子矩阵问题
 *
 * //参考http://www.csie.ntnu.edu.tw/~u91029/MaximumSubarray.html#2，最好的演算法
 * leetcode85最大矩形
 */
public class array_3 {

    private static int solve(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        //求出这个矩形中每一层的heights[i]，放入lc84题中即可
        int rows = matrix.length;
        int cols = matrix[0].length;

        int res = 0;
        //第几层去生成heights数组
        for (int i = 0; i < rows; i++) {
            int[] heights = new int[cols];

            for (int j = 0; j < cols; j++) {
                int count = 0;
                for (int k = 0; k <= i; k++) {
                    if (matrix[k][j] == 0) {
                        count = 0;
                    } else {
                        count++;
                    }
                }
                heights[j] = count;
            }
            res = Math.max(res, helper(heights));
        }
        return res;

    }

    //对于每一层的heigits求最大值
    private static int helper(int[] heights) {
        //在直方图中以每一个柱子为中心，向两边扩展
        int res = 0;
        for (int i = 0; i < heights.length; i++) {
            int left = i;
            int right = i;
            while (left >= 0 && heights[left] >= heights[i]) {
                left--;     //left首先必自减1
            }
            while (right < heights.length && heights[right] >= heights[i]) {
                right++;    //right首先必自增1
            }
            res = Math.max(res, heights[i] * (right - left - 1));       //实际上就是right - left - 2 + 1
        }
        return res;
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

            int res = solve(matrix);
            System.out.println(res);
        }
    }

}
