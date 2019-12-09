package nju.test.exercise01_AB;

import java.util.*;

//按照数值个数排序
public class _01 {

    //输入
    public static void test() {
        Scanner sc = new Scanner(System.in);
        int loop = sc.nextInt();
        while (loop-- > 0) {
            int n = sc.nextInt();//数组大小
            int[] arr = new int[n];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = sc.nextInt();
            }
            sortByNum(arr);
        }
    }


    //按数值个数排序
    public static void sortByNum(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (!map.containsKey(arr[i])) {
                map.put(arr[i], 1);
            } else {
                Integer n = map.get(arr[i]);
                map.put(arr[i], n + 1);
            }
        }
        //map利用entryset转成list，然后按照value排序，排序结果是list
        ArrayList<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                //comparator的o1-o2是升序,o2-o1是降序
                //若value值一样，则按照键的大小升序(o1-o2)，键小的在前面,否则按照值来降序
                int result = o1.getValue() - o2.getValue();
                if (result == 0) {
                    return o1.getKey() - o2.getKey();
                } else {
                    return o2.getValue() - o1.getValue();
                }
            }
        });
        //用新数组来接收结果
        int[] temp = new int[arr.length];
        int index = 0;
        for (int i = 0; i < list.size(); i++) {
            Map.Entry<Integer, Integer> entry = list.get(i);
            for (int j = 0; j < entry.getValue(); j++) {
                temp[index++] = entry.getKey();
            }
        }
        //输出结果
        for (int i = 0; i < temp.length; i++) {
            //注意输出格式
            if (i != temp.length - 1) {
                System.out.print(temp[i] + " ");
            } else {
                System.out.println(temp[i]);
            }
        }

    }

    public static void main(String[] args) {
        test();
    }
}

//zzy的版本
/*
import java.util.Arrays;
        import java.util.HashMap;
        import java.util.Scanner;

public class zzzzzzz.exercise01_AB.homework._02 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        while (t > 0) {
            int num1=s.nextInt();
            int[] A=new int[num1];
            for(int i=0;i<num1;i++){
                A[i]=s.nextInt();
            }
            Arrays.finalexam(A);
            num(A);
            for(int i=0;i<A.length-1;i++){
                System.out.print(A[i]+" ");
            }
            System.out.println(A[A.length-1]);
            t--;

        }

    }
    //1
    // 5
    // 5 5 4 6 4 19982 183 23
    public static  void num(int arr[])
    {
        HashMap<Integer,Integer> map=new HashMap();
        for (int i = 0; i < arr.length; i++) {
            if (map.get(arr[i]) == null)
                map.put(arr[i], 1);
            else
                map.put(arr[i], map.get(arr[i]) + 1);
        }
        // 5 5 4 6 4 19982 183 23
        int num[]=new int[arr.length];
        for(int i=0;i<arr.length;i++)
        {
            num[i]=map.get(arr[i]);
        }
        bubbleSort(num,arr);
    }

    public static void bubbleSort(int[] num,int []rank) {
        for (int i = num.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (num[j] < num[j+1]) {
                    swap(num, j, j + 1);
                    swap(rank, j, j + 1);
                }
            }
        }
    }
    public static void swap(int[] arr, int a, int b) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }}
*/
