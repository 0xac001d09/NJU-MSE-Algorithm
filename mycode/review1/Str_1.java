package nju.review1;

import java.util.Scanner;

/**
 * id为Str_01，对称子字符串
 * Given a string ‘str’ of digits, find length of the longest substring of ‘str’, such that the length of the substring is 2k digits
 * and sum of left k digits is equal to the sum of right k digits.
 * 输入：str =“ 1538023”
 * 输出4
 * 具有相同的上半部分和下半部分总和的最长子字符串是“ 5380”
 *
 * 题目意思是找到最长的子字符串，子字符串的长度为2k，在这个子字符串中，左边k位的和等于右边k位的和
 * 较为繁琐的方法是枚举所有子字符串，一个去判断这些字符串左右两部分是否相等,时间复杂度o3
 *
 * 巧妙的思路是，考虑所有的点作为中点，往两边扩散
 */
public class Str_1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int loop = Integer.parseInt(sc.nextLine().trim());
        while (loop-- > 0) {
            String str = sc.nextLine();

            int res = solve(str);
            System.out.println(res);
        }
    }

    //时间复杂度o2，空间复杂度o1
    private static int solve(String str) {
        int res = 0;
        int n = str.length();

        //i是所有可能情况的中点
        for (int i = 0; i < n - 1; i++) {
            int l = i;
            int r = i + 1;
            int lsum = 0;
            int rsum = 0;
            while (l >= 0 && r < n) {
                lsum += str.charAt(l) - '0';
                rsum += str.charAt(r) - '0';
                if (lsum == rsum) {
                    res = Math.max(res, r - l + 1);
                }
                l--;
                r++;

            }
        }
        return res;
    }

}
