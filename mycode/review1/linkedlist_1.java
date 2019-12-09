package nju.review1;

import java.util.Scanner;

public class linkedlist_1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int loop = Integer.parseInt(sc.nextLine().trim());
        while (loop-- > 0) {
            String[] s = sc.nextLine().split(" ");

            StringBuilder sb = new StringBuilder();
            for (int i = 1; i < s.length; i++) {
                sb.append(s[i]);
            }
            String temp = sb.toString();
            if (temp.equals(sb.reverse().toString())) {
                System.out.println("true");
            } else {
                System.out.println(false);
            }
        }
    }
}
