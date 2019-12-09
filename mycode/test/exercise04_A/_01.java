package nju.test.exercise04_A;

import java.util.Scanner;

/**
 * 数组查询
 *
 * 输入: arr[] = [-2, -3, 4, -1, -2, 1, 5, -3]
 * 输出: 9
 * 删除-2，最大子数组[4, -1, 1, 5] ，和是9
 *
 * 解题思路 leetcode1186
 *  f(i) 和 g(i)，其中 f(i) 表示不删除元素的情况下最大子数组和（区间为[0，i]），g(i) 代表删除元素的情况下的最大子数组和（区间为[0，i]）。
 *  f(i) = Math.max(f(i-1)+arr[i],arr[i]) //要么是当前元素累加之前的和，要么是重新从当前元素开始，对于这个不放的情况不要理解为Math.max(f[i - 1] + nums[i], nums[i])，不放就是只看当前元素了
 *  g(i) = Math.max(g(i-1)+arr[i],f(i-1))
 * //要么是加上当前元素，也就是维持之前删除某个元素的情形，即g[i-1]+arr[i]
 * //要么是删除当前这个元素，那么区间[0, i-1]就是不删除元素的情况，即f(i-1)+0（注意是f不是g！！）
 *
 * //初始化：f(0)= arr[0] //因为必须要有元素，不能为 0 个元素
 *          g(0) = 什么呢？，g(1) = Math.max(g(0)+arr[1],f(0))//题目提到至少保留一个元素，所以必须要选f(0)，即g(0)要足够小
 *
 */
public class _01 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int loop = Integer.parseInt(sc.nextLine().trim());
        while (loop-- > 0) {
            int size = Integer.parseInt(sc.nextLine().trim());
            int[] A = new int[size];
            String[] s = sc.nextLine().split(" ");
            for (int i = 0; i < A.length; i++) {
                A[i] = Integer.parseInt(s[i]);
            }
            System.out.println(solve(A));
        }
    }

    //TODO
    private static int solve(int[] A) {
        int n = A.length;
        //一定要写，因为我们的循环限制了，除非把计算res单独提出来
        if (n == 1) {
            return A[0];
        }
        int[] f = new int[n];       //不要开n+1
        int[] g = new int[n];       //不要开n-1
        f[0] = A[0];       //不删除元素的dp,f[0]就是A中第一个
        //这边初始值要足够小，但是不能是Integer.MIN_VALUE
        // 因为如过数组中给的值是负的，负的+最小值直接越界！所以要根据数组中元素范围来，但是题目中没有给数组元素范围，lc中是-200001
        g[0] = -200001;       //删除情况下的dp


        int res = Integer.MIN_VALUE;
        for (int i = 1; i <= n - 1; i++) {
            f[i] = Math.max(f[i - 1] + A[i],A[i]);         //放和不放
            g[i] = Math.max(g[i - 1] + A[i], f[i - 1]);     //不删和删除当前i的情况
            res = Math.max(res, Math.max(f[i], g[i]));
        }
        return res;
    }

}
