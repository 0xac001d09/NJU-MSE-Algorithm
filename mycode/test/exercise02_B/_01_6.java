package nju.test.exercise02_B;


import java.util.ArrayList;
import java.util.Scanner;


class _01_6 {


    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int loop = Integer.parseInt(sc.nextLine().trim());

        while (loop-- > 0) {
            String ss = sc.nextLine();
            String[] twoNum = ss.split(" ");
            int N = Integer.parseInt(twoNum[0]);
            int Q = Integer.parseInt(twoNum[1]);
            int i,j;
            long[] l=new long[N];
            long[] r=new long[N];
            long[] s=new long[N];
            long a=0;
            String sss = sc.nextLine();
            String[] nums = sss.split(" ");
            for (int k = 0; k < nums.length/2; k++) {
                l[k] = Integer.parseInt(nums[2 * k]);
                r[k] = Integer.parseInt(nums[2 * k + 1]);
                s[k] = a + r[k] - l[k] + 1;
                a = s[k];
            }

            long query[] = new long[Q];
            String line = sc.nextLine();
            String[] s1 = line.split(" ");
            for (i = 0; i < Q; i++) {
                query[i] = Integer.parseInt(s1[i]);
            }
            int m = 0;
            ArrayList<Long> list = new ArrayList<>();
            for (i = 0; i < Q; i++) {
                long p;
                if (query[i] <= s[0]) {
                    list.add(query[i] - l[0] + 1);
                } else if (query[i] > s[N - 1]) {
                    p = query[i] - s[N - 1];
                    list.add(p + r[N - 1]);
                } else {
                    for (j = 1; j < N; j++) {
                        if (query[i] > s[j]) {
                            continue;
                        } else {
                            m = j;
                            break;
                        }
                    }
                    p = query[i] - s[m - 1];
                    list.add(l[m] + p - 1);
                }
            }
            for (int k = 0; k < list.size(); k++) {
                if (k == list.size() - 1) {
                    System.out.print(list.get(k));
                } else {
                    System.out.print(list.get(k) +" ");
                }
            }
        }
    }
}