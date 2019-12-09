package nju.test.exercise01_AB;

import java.util.*;
public class _03 {

    private static void solve(int[] arr1, int[] arr2) {
        //使用计数排序
        int[] countArray = new int[1001];
        //先统计
        for (int i = 0; i < arr1.length; i++) {
            countArray[arr1[i]]++;
        }
        int[] res = new int[arr1.length];
        int index = 0;
        //再根据arr2中顺序存放进结果数组
        for (int i = 0; i < arr2.length; i++) {
            //取得arr2[i]在countArray中的次数
            int temp = countArray[arr2[i]];
            for (int j = 0; j < temp; j++) {
                res[index++] = arr2[i];
            }
            //放好后把countArray中对应位置的数量置为0
            countArray[arr2[i]] = 0;
        }
        //把剩余的放进res
        for (int i = 0; i < countArray.length; i++) {
            for (int j = 0; j < countArray[i]; j++) {
                res[index++] = i;
            }
        }

        //print
        for (int i = 0; i < res.length; i++) {
            if (i == res.length - 1) {
                System.out.print(res[i]);
            } else {
                System.out.print(res[i] +" ");
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int loop = sc.nextInt();
        while (loop-- > 0) {
            int len1 = sc.nextInt();
            int len2 = sc.nextInt();
            int[] arr1 = new int[len1];
            int[] arr2 = new int[len2];
            for (int i = 0; i < arr1.length; i++) {
                arr1[i] = sc.nextInt();
            }
            for (int i = 0; i < arr2.length; i++) {
                arr2[i] = sc.nextInt();
            }
            //输出结果
            solve(arr1,arr2);
        }
    }
}

//相对排序,不好的方法
/*
public class _03 {

    //leetcode 1122
    public static void zzzzzzz() {
        Scanner sc = new Scanner(System.in);
        int loop = sc.nextInt();
        while (loop-- > 0) {
            int len1 = sc.nextInt();
            int len2 = sc.nextInt();
            int[] arr1 = new int[len1];
            int[] arr2 = new int[len2];
            for (int i = 0; i < arr1.length; i++) {
                arr1[i] = sc.nextInt();
            }
            for (int i = 0; i < arr2.length; i++) {
                arr2[i] = sc.nextInt();
            }
            //输出结果
            int[] temp = relativeSort(arr1, arr2);
            for (int i = 0; i < temp.length; i++) {
                if (i != temp.length - 1) {
                    System.out.print(temp[i] + " ");
                } else {
                    System.out.println(temp[i]);
                }
            }
        }
    }

    public static int[] relativeSort(int[] arr1, int[] arr2) {
        int[] temp = new int[arr1.length];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr1.length; i++) {
            if (!map.containsKey(arr1[i])) {
                map.put(arr1[i], 1);
            } else {
                Integer n = map.get(arr1[i]);
                map.put(arr1[i], n + 1);
            }
        }

        int index = 0;
        for (int i = 0; i < arr2.length; i++) {
            if (map.containsKey(arr2[i])) {
                Integer num = map.get(arr2[i]);
                for (int j = 0; j < num; j++) {
                    temp[index++] = arr2[i];
                }
                map.remove(arr2[i]);
            }
        }
        //对于arr2中不存在的元素，按排序顺序附加他们（我理解为升序），因为给的用例是升序
        //对map中的键值对按照键排序
        ArrayList<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        Collections.finalexam(list, new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                //o1-o2是升序
                return o1.getKey() - o2.getKey();
            }
        });

        //输出剩余键值对
        Set<Map.Entry<Integer, Integer>> entrySet = map.entrySet();
        Iterator<Map.Entry<Integer, Integer>> it = entrySet.iterator();
        while (it.hasNext()) {
            Map.Entry<Integer, Integer> entry = it.next();
            Integer key = entry.getKey();
            Integer value = entry.getValue();
            for (int i = 0; i < value; i++) {
                temp[index++] = key;
            }
        }
        return temp;
    }

    public static void main(String[] args) {
        zzzzzzz();
    }

}

*/

