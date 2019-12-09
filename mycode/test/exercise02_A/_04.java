package nju.test.exercise02_A;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//有9个因数的数
public class _04 {

    //对于给定的n，找出所有0~n内（小于n）含有9个除数的数，比如N为100时，只有36和100有9个除数能被整出
    //暴力法遍历所有数字看他们的divisors是不是为9
    //符合这个条件的数必定是完全平方，那我就先把符合的数字存进去，然后在数组中找就可以
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int loop = Integer.parseInt(sc.nextLine().trim());
        while (loop-- > 0) {
            String s = sc.nextLine();
            int n = Integer.parseInt(s);
            Integer[] arr = CompleteSquared(n);
            int res = countNumbers(arr);
            System.out.println(res);
        }
    }

    //首先把符合条件的数字存进数组
    public static Integer[] CompleteSquared(int n) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int temp = (int) (Math.sqrt(n) + 0.5);
            if (temp * temp == n) {
                list.add(n);
            }
        }
        Integer[] arr = list.toArray(new Integer[list.size()]);
        return arr;

    }

    public static int numberOfDivisors(int num) {
        int count = 0;
        for (int i = 1; i <= num; i++) {
            if (num % i == 0) {
                count++;
            }
        }
        return count;
    }

    public static int countNumbers(Integer[] arr) {
        int count = 0;      //统计符合条件的数字
        for (int i = 0; i <= arr.length; i++) {
            if (numberOfDivisors(i) == 9)
                count++;
        }
        return count;
    }

    /**
     * 假设n因式分解后，等于
     *
     * n = p1 ^ a1 * p2 ^ a2 * ... pn ^ an
     *
     * 那么n的因子的个数是，(1 + a1)(1 + a2)(1 + a3)...(1 + an)
     */



}
