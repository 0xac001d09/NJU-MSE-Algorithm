package nju.test.exercise05_A;

import java.util.Scanner;

/**
 * 管道网络
 */
public class _01 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int loop = sc.nextInt();
        while (loop-- > 0) {
            int n = sc.nextInt();
            int p = sc.nextInt();

            int[] startHouse = new int[n + 1]; //从1开始
            int[] endHouse = new int[n + 1];
            int[] dis = new int[n + 1];
            for (int i = 1; i <= p; i++) {
                int start = sc.nextInt();
                int end = sc.nextInt();
                int d = sc.nextInt();
                startHouse[start] = end;    //startHouse中的每个startIndex上存放对应的目的地
                endHouse[end] = start;      //endHouse中的每个endIndex上存放对应的来源
                dis[start] = d;             //存放每个startIndex对应的直径
            }
            solve(startHouse, endHouse, dis);
        }
    }

    private static void solve(int[] startHouse, int[] endHouse, int[] dis) {
        int n = startHouse.length - 1;
        int count = 0;
        for (int i = 1; i <= n; i++) {
            //有几个。对于第i个位置，如果startHouse[i]有目的地 且 endHouse[i]没有来源，也就是没有人到它那去，这就是到底了
            if (startHouse[i] != 0 && endHouse[i] == 0) {
                count++;
            }
        }
        System.out.println(count);

        for (int i = 1; i <= n; i++) {
            //对上面条件取反
            if (startHouse[i] == 0 || endHouse[i] != 0) {
                continue;
            }
            //找到一个符合条件的
            int j = i;
            int val = Integer.MAX_VALUE;
            while (startHouse[j] != 0) {
                val = Math.min(val, dis[j]);
                j = startHouse[j];  //把它去的地方作为startIndex
            }
            System.out.println(i + " " + j + " " + val);
        }
    }
}
