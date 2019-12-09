package nju.review1;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 * 删除最少的元素，使得整个数组是先升后降的
 */
public class array_7 {

    static Set<String> set;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int loop = Integer.parseInt(sc.nextLine().trim());
        while (loop-- > 0) {
            String[] s = sc.nextLine().split(" ");
            int[] nums = new int[s.length];
            for (int i = 0; i < nums.length; i++) {
                nums[i] = Integer.parseInt(s[i]);
            }

            set = new TreeSet<>();

            //删除个数要最少，只要map中一有就break,但至少留一个
            for (int i = 0; i < nums.length - 1; i++) {
                solve(nums, i, 0);
                if (!set.isEmpty()) {
                    break;
                }
            }

            for (String str : set) {
                System.out.println(str);
            }
        }
    }

    /**
     * @param nums   //当前数组
     * @param delNum //要删除的个数
     * @param crtIndex  //当前位置
     */
    private static void solve(int[] nums, int delNum, int crtIndex) {
        // 删除0个，也就是不用删除的情况
        if (delNum == 0) {
            //如果满足先升后降
            if (firstUpThenDown(nums)) {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < nums.length; i++) {
                    sb.append(nums[i] + " ");
                }
                set.add(sb.toString().trim());
                return;
            }
        } else {
            //要删除的情况，删除当前nums中的哪个
            for (int i = crtIndex; i < nums.length; i++) {
                int[] arr = removeElem(nums, i);
                solve(arr, delNum - 1, i);      //注意 curIndex = i
            }
        }
    }

    //nums数组是否是先升后降的
    private static boolean firstUpThenDown(int[] nums) {
        boolean flag = true;        //用于标记当前是否为先升后降，true为当前是升序，false为当前是降序，
        for (int i = 1; i < nums.length; i++) {
            // 首先前后元素比较，如果后面的比前面的小，改为当前是降序
            if (nums[i] < nums[i - 1]) {
                flag = false;
            }
            //如果前面是降序，然后突然升序了，返回false
            if (!flag) {
                if (nums[i] > nums[i - 1]) {
                    return false;
                }
            }
        }
        return true;
    }

    // 保持顺序，删除i位置上的元素
    private static int[] removeElem(int[] nums, int i) {
        int[] arr = new int[nums.length - 1];
        int index = 0;
        for (int j = 0; j < nums.length; j++) {
            if (j != i) {
                arr[index++] = nums[j];
            }
        }
        return arr;
    }
}
