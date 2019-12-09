package nju.homework._03;

import java.util.*;

/**
 * 按照数值个数排序...这题目之前出现过
 *
 * 对给定数组中的元素按照元素出现的次数排序，出现次数多的排在前面，如果出现次数相同，则按照数值大小排序。
 */
public class _8 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int loop = Integer.parseInt(sc.nextLine().trim());
        while (loop-- > 0) {
            int size = Integer.parseInt(sc.nextLine().trim());
            String[] s = sc.nextLine().split(" ");
            int[] nums = new int[size];
            for (int i = 0; i < size; i++) {
                nums[i] = Integer.parseInt(s[i]);
            }
            solve(nums);
        }
    }

    private static void solve(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], 1);
            } else {
                map.put(nums[i], map.get(nums[i]) + 1);
            }
        }

        //首先按照value来排序
        ArrayList<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                int res = o2.getValue() - o1.getValue();
                //如果value一样，数值小的排在前面
                if (res == 0) {
                    return o1.getKey() - o2.getKey();
                } else {
                    return res;
                }
            }
        });

        //输出结果
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            Map.Entry<Integer, Integer> entry = list.get(i);
            Integer key = entry.getKey();
            Integer value = entry.getValue();
            for (int j = 0; j < value; j++) {
                sb.append(key).append(" ");
            }
        }
        System.out.println(sb.toString().trim());
    }
}
