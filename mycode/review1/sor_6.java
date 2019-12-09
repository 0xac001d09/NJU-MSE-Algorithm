package nju.review1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 最小交换次数
 * 求每个数字回到自己位置上的最小交换次数
 *
 * 注意，这个题是任意n个不同的数，不是你认为的1、2、3、4、5这样子 的，可能100，97，200，20这样子
 * 所以要利用两个map
 * 测试用例：
 *
 * 1
 * 6
 * 3 5 2 4 6 8
 */
public class sor_6 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int loop = Integer.parseInt(sc.nextLine());
        while (loop-- > 0) {
            int size = Integer.parseInt(sc.nextLine());
            String[] s = sc.nextLine().split(" ");
            int[] nums = new int[size];
            for (int i = 0; i < size; i++) {
                nums[i] = Integer.parseInt(s[i]);
            }
            System.out.println(solve2(nums));
        }
    }


    private static int solve(int[] nums) {
        //由于题目是给任意n个不同的数，可以首先得出一个已经排序好的数组，这个数组中点数及其对应的下标后面要用到
        int[] temp = Arrays.copyOfRange(nums, 0, nums.length);
        Arrays.sort(temp);
        Map<Integer, Integer> help = new HashMap<>();       //保存正确的位置
        for (int i = 0; i < temp.length; i++) {
            help.put(i, temp[i]);       //位置，以及位置上对应的数字
        }

        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);        //数字及其位置
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != help.get(i)) { //如果i位置上放的不是正确的nums[i]
                Integer rightNum = help.get(i); //首先获取这个位置上正确的数字是谁

                Integer index = map.get(rightNum); //在map中获取这个数字目前所在的下标
                map.put(nums[i], index);    //把这个错误的先换到index上
                map.put(rightNum, i);  //把正确的换上
                count++;

                int tmp = nums[i];
                nums[i] = nums[index];
                nums[index] = tmp;
            }
        }
        return count;
    }
    /**
     * 使用选择排序
     */
    private static int solve2(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            int temp = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[temp]) {
                    temp = j;
                }
            }
            if (temp != i) {
                int tmp = nums[temp];
                nums[temp] = nums[i];
                nums[i] = tmp;
                count++;
            }
        }
        return  count;

    }
}
