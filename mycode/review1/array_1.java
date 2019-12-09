package nju.review1;
/**
 * 汉诺塔变种问题，要求必须经过中间的柱子
 *
 * 思考步骤：
 * 一个盘子，那只要2步
 * 两个盘子，假设上面的是A，下面的是B，先把A移动到3号柱子（2步），再把B移到2号柱子（1步），再把A移到1号柱子（2步），再把B移到3号柱子（1步），再把A移到3号柱子（2步），共8步
 * 对于n个盘子，先要把n-1个盘子从1移动到3，再把最后一个盘子从1移到2，再把n-1个盘子从3移到1，再把最后一个盘子从2移到3，再把n-1个盘子从1移到3
 */
import java.util.Scanner;

public class array_1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int loop = sc.nextInt();
        while (loop-- > 0) {
            int i = sc.nextInt();
            System.out.println(solve(i));
        }
    }
    //这样写内存溢出...
/*    private static int solve(int n) {
        if (n == 1) {
            return 2;
        }
        else {
            int num1 = solve(n - 1);    //n-1个盘子从1移动到3
            int num2 = solve(n - 1);    //n-1个盘子从3移动到1
            int num3 = solve(n - 1);    //n-1个盘子从1移动到3
            return num1 + num2 + num3 + 2;  //每次最后一个盘子要移动两次
        }
    }*/
    private static int solve(int n) {
        if (n == 1) {
            return 2;
        } else {
            int num1 = 3 * solve(n - 1);
            return num1 + 2;  //每次最后一个盘子要移动两次
        }
    }

}
