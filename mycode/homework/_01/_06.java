package nju.homework._01;
import java.util.Scanner;

//固定和元素对有几个
public class _06 {

    //感觉题意说得不太清楚
    public static void elemPair(int[] nums, int target) {
        int count = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int n = nums[i] + nums[j];
                if (n == target) {
                    count++;
                }
            }
        }
        System.out.println(count);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int loop = Integer.parseInt(sc.nextLine());
        while (loop-- > 0) {
            // String s1 = sc.nextLine();
            String s = sc.nextLine();
            String[] nums = s.split(" ");
            int[] arr = new int[nums.length];
            for (int i = 0; i < arr.length; i++) {
                int num = Integer.valueOf(nums[i]);
                arr[i] = num;
            }
            int target = sc.nextInt();
            elemPair(arr, target);
        }
    }
}
