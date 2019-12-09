package nju.test.exercise03_B;

import java.util.Scanner;

/**
 * 和最大的连续降序字符
 */
public class _05 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int loop = Integer.parseInt(sc.nextLine().trim());
        while (loop-- > 0) {
            String s = sc.nextLine();
            solve(s);
        }
    }

    private static void solve(String s) {
        char[] chars = s.toCharArray();
        boolean[] chs = new boolean[26];
        //初始化布尔数组，它是用来记录该字符有没有用过
        for (int i = 0; i < chars.length; i++) {
            chs[chars[i] - 'A'] = true;        //出现过就是true，否则其他字符就是没在我们字符串中出现的，不能用
        }

        String res = "";
        //26个字符中，每个字符都不会重复，字符的ascii码之间的距离从1到25
        for (int i = 1; i <= 25; i++) {

            //由于是降序，每次到要从26个英文字的最后一个开始
            for (int j = 25; j >= 0; j--) {
                //如果这个字符是我们字符串中的字符，
                if (chs[j]) {
                    String temp = "";
                    temp += (char)(j + 'A');

                    //开始找它的下一个，记住，这里i是步长
                    for (int k = j - i; k >= 0; k -= i) {
                        if (chs[k]) {
                            temp += (char) (k + 'A');
                        }
                        else {        //如果没有出现过了，一定要停下来。比如ABCPQR，temp为RQP，如果此时步长是1，但是没有MNO，他依旧会进行下去，最后加C加B加A，但是C与P的步长并不为1
                            break;
                        }
                    }

                    if (temp.length() > res.length()) {
                        res = temp;
                    }
                }

            }
        }
        System.out.println(res);

    }
}

