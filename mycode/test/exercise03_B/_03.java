package nju.test.exercise03_B;

import java.lang.*;
import java.util.Scanner;
//和最大的连续降序字符
class _03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int loop = Integer.parseInt(sc.nextLine().trim());
        while (loop-- > 0) {
            String s = sc.nextLine();
            solve(s);
        }
    }

    private static void solve(String s) {
        char[] chars = s.toCharArray();
        boolean[] chs = new boolean[26];

        for (int i = 0; i < chars.length; i++) {
            chs[chars[i] - 'A'] = true;
        }

        String res = "";
        //两个ascii的差值为1到25（至少1）
        for (int i = 1; i <= 25; i++) {
            //从最后一个开始
            for (int j = 25; j >= 0; j--) {
                //如果这个字符在chs中有的话就以它为开始
                if (chs[j]) {
                    String temp = "";
                    temp += (char) ('A' + j);
                    //k = j-i是从j开始后的第一个距离j步长为i的数，然后每次减步长
                    for (int k = j - i; k >= 0; k -= i) {
                        if (chs[k]) {
                            temp += (char) ('A' + k);
                        } else {
                            break;
                        }
                    }
                    if (temp.length() > res.length()) {
                        res = temp;
                    }
                }
            }
        }
        System.out.println(res);
    }
}
