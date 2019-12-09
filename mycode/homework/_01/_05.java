package nju.homework._01;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
//区间第k小
public class _05 {

    //runtime error
    public static void test() throws IOException {
        Scanner sc = new Scanner(new BufferedInputStream(System.in));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int loop = sc.nextInt();
        while (loop-- > 0) {
            ArrayList<Integer> list = new ArrayList<>();
            String s = br.readLine();
            String[] nums = s.split(" ");
            for (int i = 0; i < nums.length; i++) {
                int num = Integer.parseInt(nums[i]);
                list.add(num);
            }
            int start = sc.nextInt();
            int end = sc.nextInt();
            int k = sc.nextInt();
            findKthNum(list, start, end, k);
        }
    }

    //区间第k小
    public static void findKthNum(List<Integer> list, int start, int end, int k) {
        int[] arr = new int[end - start + 1];
        int index = 0;
        for (int i = start - 1; i < end; i++) {
            arr[index++] = list.get(i);
        }
        Arrays.sort(arr);
        System.out.println(arr[k - 1]);
    }

    public static void main(String[] args) throws IOException {
        test();
    }

}



