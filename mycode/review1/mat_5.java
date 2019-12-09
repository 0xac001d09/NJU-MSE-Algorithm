package nju.review1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 数字重组整除问题
 * 对给出的数字重组，输出重组后能被17整除的最大数字
 *
 * 主要是求出全排列
 * 这个题神经病地方在这，0要输出Not Possible
 *
 */
public class mat_5 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int loop = Integer.parseInt(sc.nextLine().trim());
        while (loop-- > 0) {
            permute(sc.nextLine());
        }
    }

    private static void permute(String s) {
        char[] chs = s.toCharArray();
        int n = chs.length;
        boolean[] visited = new boolean[n];
        List<Integer> list = new ArrayList<>();
        backtrack(chs, visited, list, 0, n, "");

        //输出结果
        int res = 0;        //这个题神经病地方在这，0要输出Not Possible
        for (Integer num : list) {
            if (num % 17 == 0 && num > res) {
                res = num;
            }
        }

        if (res == 0) {
            System.out.println("Not Possible");  //这个题神经病地方在这，0要输出Not Possible
        } else {
            System.out.println(res);
        }
    }

    private static void backtrack(char[] chs, boolean[] visited, List<Integer> list, int curSize, int len,String temp) {
        if (curSize == len) {
            int num = Integer.parseInt(temp);
            list.add(num);
            return;
        }
        for (int i = 0; i < len; i++) {
            if (!visited[i]) {
                temp += chs[i];
                visited[i] = true;
                backtrack(chs, visited, list, curSize + 1, len, temp);
                //状态重置
                temp = temp.substring(0, temp.length() - 1);
                visited[i] = false;
            }
        }

    }
}
