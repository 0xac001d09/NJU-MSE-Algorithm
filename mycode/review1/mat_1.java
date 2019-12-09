package nju.review1;
/**
 * 整数查询
 * 第一个·数字是uc个数，每个uc包含三行，，第一行包含两个整数 N 和 M ，分别代表两个数组的长度，第二行是数组长度为N的数组，第三行是数组长度为 M 的查询数组
 *
 * 2
 * 6 3
 * 2 4 9 15 21 20
 * 2 3 5
 * 3 2
 * 3 4 6
 * 2 3
 *
 * 输出
 * 3 3 2
 * 2 2
 *
 * 这个题很简单，就是第三行十余个查询数组，对于查询数组中的所有元素，看他们在第二行的数组中能背多少个整除
 *
 *
 */
import java.util.Scanner;

public class mat_1 {

    private static void solve(int[] arr, int[] query) {
        int n = arr.length;
        int m = query.length;

        for (int i = 0; i < m; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (arr[j] % query[i] == 0) {
                    count++;
                }
            }
            if (i != m - 1) {
                System.out.print(count+" ");
            } else {
                System.out.println(count);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int loop = Integer.parseInt(sc.nextLine().trim());
        while (loop-- > 0) {
            String s1 = sc.nextLine();
            String s2 = sc.nextLine();
            String s3 = sc.nextLine();
            String[] ss1 = s1.split(" ");
            String[] ss2 = s2.split(" ");
            String[] ss3 = s3.split(" ");

            int len1 = Integer.parseInt(ss1[0]);
            int len2 = Integer.parseInt(ss1[1]);

            int[] arr = new int[len1];
            int[] query = new int[len2];

            for (int i = 0; i < len1; i++) {
                arr[i] = Integer.parseInt(ss2[i]);
            }
            for (int i = 0; i < len2; i++) {
                query[i] = Integer.parseInt(ss3[i]);
            }

            solve(arr,query);
        }
    }

}
