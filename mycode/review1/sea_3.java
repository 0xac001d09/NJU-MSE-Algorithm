package nju.review1;

import java.util.*;

/**
 * Searching3
 * 废话挺多，意思就是，给你一个个区间，表示已有的数，然后查询，找出第q大的数
 * 比如这个例子，给了3个区间[1,10], [12, 20], [22, 30]，表示存在的数，区间外（除了 > 30）的数是不存在的。
 * 1 10 12 20 22 30
 * 查询第5个数，第15个数，第25个数
 * 5 15 25
 * 第5个数是5，由于11不存在，所以第15个数是16，由于11和21不存在，所以第25个数是27
 *
 * 注意分数范围1<= l(i) < r(i) <=10^18,1<=x<=10^18
 */
public class sea_3 {

    //TODO
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int loop = sc.nextInt();
        while (loop-- > 0) {
            int n = sc.nextInt();
            int q = sc.nextInt();
            long[] nums = new long[2 * n];
            for (int i = 0; i < 2 * n; i++) {
                nums[i] = sc.nextLong();
            }
            long[] query = new long[q];
            for (int i = 0; i < q; i++) {
                query[i] = sc.nextLong();
            }
            solve(nums,query);
        }
    }

    private static void solve(long[] nums, long[] query) {
        int n = nums.length / 2;
        long[] groups = new long[n];
        int index = 1;

        for (int i = 1; i < 2 * n; i += 2) {
            if (index != 0) {
                groups[index] = groups[i - 1] + nums[i] - nums[i - 1] + 1;
            } else {
                groups[index] = nums[i] - nums[i - 1] + 1;
            }
            index++;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < query.length; i++) {
            long idx = getIndex(groups, query[i]);


        }
    }

    private static long getIndex(long[] groups, long query) {
        int left = 0;
        int right = groups.length - 1;
        int idx = 0;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (groups[mid] == query) {
                idx = mid;
                break;
            } else if (groups[mid] < query) {
                left = mid + 1;
            } else {
                right = mid - 1;
                idx = mid;
            }
        }
        return idx;
    }
}
