package nju.review1;

import java.util.HashSet;
import java.util.Scanner;

/**
 * 能否成环
 * 能成环，打印1，不能成环，打印2。给定的额字符串可以乱序
 */
public class str_6 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int loop = Integer.parseInt(sc.nextLine().trim());
        while (loop-- > 0) {
            int l = Integer.parseInt(sc.nextLine().trim());
            String s = sc.nextLine();
            String[] strs = s.split(" ");
            HashSet<Integer> set = new HashSet<>();
            StringBuilder sb = new StringBuilder();
            if (isCycle(strs, sb, set)) {
                System.out.println("1");
            } else {
                System.out.println("0");
            }
        }
    }

    //set用来存已经被访问字符串的个数,就是visited的个数
    private static boolean isCycle(String[] strs, StringBuilder sb, HashSet<Integer> set) {
        int len = strs.length;  //一共有多少个字符串
        //如果全部访问过了，就看头和尾相不相等
        if (set.size() == len) {
            if (sb.charAt(0) == sb.charAt(sb.length() - 1)) {
                return true;
            } else {
                return false;
            }
        }
        //遍历所有字符串
        for (int i = 0; i < len; i++) {
            //如果这个字符串没有被访问过,并且只有头和上一个的尾相等 或 是第一个来的字符串，才能被加进入
            if (!set.contains(i) && (sb.length() == 0 || sb.charAt(sb.length() - 1) == strs[i].charAt(0))) {
                //sb中加入这个字符串的头和尾，中间不用关心
                sb.append(strs[i].charAt(0));
                sb.append(strs[i].charAt(strs[i].length()-1));
                //标记为访问过
                set.add(i);
                //递归判断
                if (isCycle(strs, sb, set)) {
                    return true;
                }
            }
        }
        return false;
    }

}
