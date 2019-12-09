package nju.review1;

import java.util.*;

/**
 * 按照数值个数排序
 */
public class Sort {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int loop = Integer.parseInt(sc.nextLine().trim());
        while (loop-- > 0) {
            int size = Integer.parseInt(sc.nextLine().trim());
            int[] nums = new int[size];
            String[] s = sc.nextLine().split(" ");
            for (int i = 0; i < size; i++) {
                nums[i] = Integer.parseInt(s[i]);
            }
            solve(nums);
        }
    }

    private static void solve(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], 1);
            } else {
                map.put(nums[i], map.get(nums[i]) + 1);
            }
        }
        ArrayList<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                int n = o2.getValue() - o1.getValue();
                if (n == 0) {
                    return o1.getKey() - o2.getKey();
                } else {
                    return n;
                }
            }
        });

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            Integer key = list.get(i).getKey();
            Integer value = list.get(i).getValue();
            for (int j = 0; j < value; j++) {
                sb.append(key + " ");
            }
        }
        System.out.println(sb.toString().trim());
    }
}
