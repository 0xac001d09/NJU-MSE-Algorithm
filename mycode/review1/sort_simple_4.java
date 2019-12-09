package nju.review1;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

/**
 * 非递归快排
 * 这个题不能用arrays.finalexam
 */
public class sort_simple_4 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] s = sc.nextLine().split(" ");
        int[] nums = new int[s.length - 1];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(s[i + 1]);
        }
        quickSort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i == nums.length - 1) {
                System.out.println(nums[i]);
            } else {
                System.out.print(nums[i]+" ");
            }
        }
    }

    private static void quickSort(int[] nums) {
        Stack<Map<String, Integer>> stack = new Stack<>();
        Map<String, Integer> map = new HashMap<>();
        map.put("start", 0);
        map.put("end", nums.length - 1);
        stack.push(map);

        while (!stack.isEmpty()) {
            Map<String, Integer> pop = stack.pop();
            Integer start = pop.get("start");
            Integer end = pop.get("end");
            //找基准元素
            int i = partition(nums, start, end);
            //根据基准元素分成两部分，把每一部分的起止下标入栈
            // 左半部分
            if (start < i - 1) {
                HashMap<String, Integer> leftMap = new HashMap<>();
                leftMap.put("start", start);
                leftMap.put("end", i - 1);
                stack.push(leftMap);
            }
            //右半部分
            if (end > i + 1) {
                HashMap<String, Integer> rightMap = new HashMap<>();
                rightMap.put("start", i + 1);
                rightMap.put("end", end);
                stack.push(rightMap);
            }
        }
    }

    //返回基准元素的位置
    private static int partition(int[] nums, int start, int end) {
        //选取第一个为基准元素
        int pivot = nums[start];
        int left = start;
        int right = end;
        while (left < right) {
            //只能先从右边走，记住
            while (left < right && nums[right] > pivot) {
                right--;
            }
            while (left < right && nums[left] <= pivot) {
                left++;
            }
            if (left < right) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
            }
        }
        //此时left = right
        //要把基准元素换到left = right上
        nums[start] = nums[left];
        nums[left] = pivot;
        return left;
    }
}


