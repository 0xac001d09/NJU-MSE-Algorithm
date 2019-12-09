package nju.homework._01;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class _08 {
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        for(int i = 0;i < n;i++){
            List<Integer> re1 = new LinkedList<>();
            List<Integer> re2 = new LinkedList<>();
            String s1 = sc.nextLine();
            String[] array = s1.split(" ");
            for(int j = 0;j < array.length;j++){
                re1.add(Integer.valueOf(array[j]));
            }
            String s2 = sc.nextLine();
            String[]array2 = s2.split(" ");
            for(int j = 0;j < array2.length;j++){
                re2.add(Integer.valueOf(array2[j]));
            }
            System.out.println(helper(re1,re2));
        }
    }
    public static int helper(List<Integer>list1,List<Integer> list2){
        if(list1 == null || list2 == null || list1.size() == 0 || list2.size() == 0 || list1.size() != list2.size()){
            return 0;
        }
        //合并两个list并求和
        int sum = 0;
        List<Integer> list = new LinkedList<>(list1);
        list.addAll(list2);
        int len = list.size();
        for(int i = 0;i < list.size();i++){
            sum += list.get(i);
        }

        //本来是三维dp，后面使用滚动数组优化成了二维dp
        int[][]dp = new int[len / 2 + 1][sum / 2 + 1];
        for(int i = 0;i <= len / 2;i++){
            for(int j = 0;j <= sum / 2;j++){
                if (i == 0) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = -1;
                }
            }
        }

        //滚动数组就是让数组滚动起来，每次都使用固定的几个存储空间，达到压缩、存储空间的作用，dp是自底向上求解的，舍去不需要的解
        for(int i = 1;i <= list.size();i++){
            for(int j = i > len / 2 ? len / 2 : i;j >= 1;j--){      //j是行 物品个数
                // v就从list.get(i - 1)
                for(int v = list.get(i - 1);v <= sum / 2;v++){      //v是列 背包容量
                    //一种情况是不放当前的，看前面是不是啥都没放，有放了那就保持原样，啥都没放那就直接continue吧
                    if (dp[j - 1][v - list.get(i - 1)] < 0) {
                        continue;
                    }
                    // 另一种是放的情况，和同v时下一行的比较，比下一行的大就放入
                    else if (dp[j - 1][v - list.get(i - 1)] + list.get(i - 1) > dp[j][v]) {
                        dp[j][v] = dp[j - 1][v - list.get(i - 1)] + list.get(i - 1);
                    }
                }
            }
        }
        return sum - 2 * dp[len/2][sum/2];
    }
}