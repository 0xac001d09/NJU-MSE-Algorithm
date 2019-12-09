package nju.test.exercise02_B;


import java.util.Scanner;

class _01_2 {
    public static void main (String[] args) {
        //code

        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){

            int g=sc.nextInt(), noq=sc.nextInt();
            long[] l=new long[g], u=new long[g], r=new long[g], q=new long[noq];
            for(int i=0;i<g;i++){

                l[i]=sc.nextLong();
                u[i]=sc.nextLong();

            }

            for(int i=0;i<noq;i++)
                q[i]=sc.nextLong();

            r[0]=1;
            for(int i=0;i<g-1;i++){

                r[i+1]=r[i]+u[i]-l[i]+1;

            }

            StringBuffer s=new StringBuffer();

            for(int i=0;i<noq;i++){

                long rank=q[i];
                int c=0;
                for(int j=0;j<g-1;j++){

                    if(rank>=r[j] && rank<r[j+1])
                        break;
                    else
                        c++;

                }

                if (i != noq - 1) {

                    s.append((l[c] + rank - r[c]) + " ");
                } else {
                    s.append((l[c] + rank - r[c]));
                }

            }

            System.out.println(s);

        }

    }
}