package nju.test.exercise04_A;

import java.util.*;

/**
 * 按照要求保留数组元素使得和最大
 *
 * 题目描述：给定N个数，最大化符合条件数字的和。每一步选择A[i]，删除一个数字，并删除数组中所有出现的A[i]-1和A[i]+1（如果存在的话），重复这些步骤，直到数组变空。问题是要最大化所选数字的总和。
 *
 * 输入：a [] = {1,2,3}
 * 输出4
 * 第一步，我们选择1，所以1和2从序列中删除，剩下3。1+3=4
 * 输入：a [] = {1,2,2,2,3,4}
 * 输出：10
 * 说明：从数组中选择2之一，因此2，2-1，2 + 1将被删除，而我们剩下的是{2，2，4}，因为1和3被删除。在接下来的两个步骤中选择2，然后在最后一步中选择4。
 *
 * 对于每一位上的数字，要么删，要么不删
 *      不删，dp[i] = dp[i-1]
 *      删除，dp[i] = max{dp[i-2]+dp[i]*dp[i]的个数}    看 输入：a [] = {1,2,2,2,3,4}这个例子
 *      两者取最大
 *
 */
//TODO,这个题不会//////////////////////////////
public class _03 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int loop = Integer.parseInt(sc.nextLine().trim());
        while (loop-- > 0) {
            int size = Integer.parseInt(sc.nextLine().trim());
            LinkedList<Integer> list = new LinkedList<>();
            String[] s = sc.nextLine().split(" ");
            for (int i = 0; i < s.length; i++) {
                list.add(Integer.parseInt(s[i]));
            }
            System.out.println(solve(list));
        }
    }

    //这个方法有点问题
    private static int solve(LinkedList<Integer> list) {
        Collections.sort(list);
        int sum = 0;
        while (!list.isEmpty()) {
            int x = list.remove(list.size() - 1);
            sum += x;
            int i = Collections.binarySearch(list, x - 1);
            if (i != -1) {
                list.remove(i);
            }
        }
        return sum;
    }
}
