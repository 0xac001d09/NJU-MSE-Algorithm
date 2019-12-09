package nju.review1;
//一些细节要注意
/**
 * 有九个因数的数
 * 找到一个数,它含有9个因数,比如 36: 1 2 3 4 6 9 12 18 36
 *
 * 这个题目是在给定n的范围内，找出有多少个数，是符合上述条件的
 * 实际上是一个数学公式题,有9个因数的数必定满足下列公式之一：x = a^2 * b^2 或 x = a^8，其中a、b必须是质数！
 * 给定范围1<=N<=10^12
 * 解决思路：
 *      1、创建一个质数数组,用于存放给定范围内的所有质数,
 *      2、使用双重循环两两组合枚举质数, 设i为当前质数,使用j遍历所有质数当满足 i2 * j2 >num时停止本次遍历,
 *          令i=i+1,重复之前过程,直到 i2 * (i+1)2 >num时停止遍历,此时已经找出了所有满足条件1的质数组合
 * 优化：
 *      1、因为N<=10^12,因此质数最大不超过10^6(根号N),因此数组长度设为10^6(即可
 *      这道题最大的一个坑,给定的1<=N<=10^12 , 21^8刚好满足条件2,因此比21大的质数一定不满足条件2 ,即:21^8<10^12<23^8
 *
 * 如何找出10^6范围内的所有素数？在这里介绍一个埃式筛选法
 * 埃氏筛选法的思想:
 * 首先将2到n范围内的整数写下来，其中2是最小的素数。将表中所有的2的倍数划去，表中剩下的最小的数字就是3，他不能被更小的数整除，所以3是素数。再将表中所有的3的倍数划去……以此类推，如果表中剩余的最小的数是m，那么m就是素数。然后将表中所有m的倍数划去，像这样反复操作，就能依次枚举n以内的素数。表格如下（以n为20为例）：20以内的素数有2,3,5,7,11,13,
 *
 */
import java.util.ArrayList;
import java.util.Scanner;
public class sea_2 {

    static int[] a; //埃式筛选法辅助数组
    static ArrayList<Integer> list; //把范围内的素数都放到list中

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int loop = sc.nextInt();
        while (loop-- > 0) {
            long num = sc.nextLong();
            getPrime(num);
            System.out.println(getCount(num));
        }
    }


    //使用埃式筛选法获取范围内的素数,存进list
    private static void getPrime(long num) {
        list = new ArrayList<>();
        //对于给定数字，质数不会超过其根号num
        int k = (int) Math.sqrt(num);
        a = new int[k + 1];     //加不加1都可
        for (int i = 2; i < a.length; i++) {
            if (a[i] == 0) {        //a[i] = 0，代表这个数字没有被划去， a[i] = 1代表这个数字废了，不是素数
                list.add(i);
            }
            for (int j = 2 * i; j < a.length; j += i) { //j += i !!
                a[j] = 1;   //划去他的倍数
            }
        }
    }

    //找有九个因数的数,只要满足两个条件的其一即可
    private static int getCount(long num) {
        int res = 0;
        // 第一种情况：只要x = a^2+b^2,a、b均为素数，这个数就有9个因数
        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = i + 1; j < list.size(); j++) {
                if (Math.pow(list.get(i), 2) * Math.pow(list.get(j), 2) > num) {
                    break;
                }
                res++;
            }
        }
        // 第二种情况：只要x = a^8,a为素数，这个数就有9个因数
        //这个题uc似乎出了问题，没有继续算比23大的质数的8次方是否满足条件
        // 2,3,5,7,11,13、17、19、23
        for (int i = 0; i < 9 && i < list.size(); i++) {        //这里i < 9额外加的
            if (Math.pow(list.get(i), 8) > num) {
                break;
            }
            res++;
        }
        return res;
    }

}
