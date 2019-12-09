package nju.homework._03;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Scanner;

/**
 * KD树 第二个方法
 */
class Pair {
    double x;
    double y;
}

class Len {
    int weizhi;
    double length;
}

public class _2_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int ucaseNum = Integer.parseInt(sc.nextLine());
        while (ucaseNum-- > 0) {
            String[] s = sc.nextLine().split(",");
            Pair[] pairs = new Pair[s.length];
            for (int i = 0; i < s.length; i++) {
                String[] s1 = s[i].split(" ");
                Pair pair = new Pair();
                pair.x = Double.parseDouble(s1[0]);
                pair.y = Double.parseDouble(s1[1]);
                pairs[i] = pair;
            }
            Len[] lens = new Len[s.length];
            String[] s2 = sc.nextLine().split(" ");
            double x = Double.parseDouble(s2[0]);
            double y = Double.parseDouble(s2[1]);
            for (int i = 0; i < s.length; i++) {
                Len len = new Len();
                len.weizhi = i;
                len.length = (x - pairs[i].x) * (x - pairs[i].x) + (y - pairs[i].y) * (y - pairs[i].y);
                lens[i] = len;
            }
            Arrays.sort(lens, (o1, o2) -> {
                if ((o2.length - o1.length) > 0) return -1;
                if ((o2.length - o1.length) < 0) return 1;
                else return 0;
            });
            int ans = Integer.parseInt(sc.nextLine());
            for (int i = 0; i < ans; i++) {
                if (i != 0) System.out.print(",");
                System.out.print(convertDoubleToString(pairs[lens[i].weizhi].x) + " " + convertDoubleToString(pairs[lens[i].weizhi].y));
            }
            System.out.println();
        }
    }

    private static String convertDoubleToString(double val) {
        BigDecimal bd = new BigDecimal(String.valueOf(val));
        return bd.stripTrailingZeros().toPlainString();
    }
}