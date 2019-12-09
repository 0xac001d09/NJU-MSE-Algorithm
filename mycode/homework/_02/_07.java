package nju.homework._02;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

//非递归快排
public class _07 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String s = sc.nextLine();
            String[] s1 = s.split(" ");
            int[] nums = new int[s1.length - 1];    //这个是正确答案（测试用例不对，测试用例把第一个也算进去了，ac的时候要算上第一个，在这里把-1去掉）
            for (int i = 0; i < nums.length; i++) {
                nums[i] = Integer.parseInt(s1[i + 1]);
            }
            quickSort(nums);
            for (int i = 0; i < nums.length; i++) {
                if (i == nums.length - 1) {
                    System.out.println(nums[i]);
                } else {
                    System.out.print(nums[i] + " ");
                }
            }
        }
    }

    //非递归快排
    private static void quickSort(int[] nums) {
        Stack<Map<String, Integer>> stack = new Stack<>();
        Map<String, Integer> map = new HashMap<>();
        map.put("start", 0);
        map.put("end", nums.length - 1);
        stack.push(map);

        while (!stack.isEmpty()) {
            Map<String, Integer> popMap = stack.pop();
            Integer start = popMap.get("start");
            Integer end = popMap.get("end");
            //得到基准元素位置
            int pivot = partition(nums, start, end);

            if (start < pivot - 1) {
                Map<String, Integer> leftMap = new HashMap<>();
                leftMap.put("start", start);
                leftMap.put("end", pivot - 1);
                stack.push(leftMap);
            }
            if (end > pivot + 1) {
                Map<String, Integer> rightMap = new HashMap<>();
                rightMap.put("start", pivot + 1);
                rightMap.put("end", end);
                stack.push(rightMap);
            }
        }
    }

    private static int partition(int[] nums, int start, int end) {
        int pivot = nums[start];        //基准元素
        int left = start;
        int right = end;

        while (left < right) {
            //只能先从右边走
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
        //left和right重合了，要把基准元素换到left = right 这个位置
        nums[start] = nums[left];
        nums[left] = pivot;
        return left;    //返回基准元素的位置
    }
}
