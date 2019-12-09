package nju.homework._02;

import java.util.Arrays;
import java.util.Scanner;

//链表回文
public class _02 {

    private static boolean isPalindrome(String[] strs) {
        int left = 0;
        int right = strs.length-1;
        while (left < right) {
            if (!strs[left].equals(strs[right])) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int loop = Integer.parseInt(sc.nextLine().trim());
        while (loop-- > 0) {
            String s = sc.nextLine();
            String[] nums = s.split(" ");
            System.out.println(isPalindrome(Arrays.copyOfRange(nums, 1, nums.length)));
        }

    }
}
