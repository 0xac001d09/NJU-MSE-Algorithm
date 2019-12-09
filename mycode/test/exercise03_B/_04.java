package nju.test.exercise03_B;

import java.lang.*;
import java.util.HashMap;
import java.util.Scanner;

//距离问题
class _04 {
    //思路：化简公式，你会发现...
    public static void main (String[] args) {
        Scanner sc=new Scanner(System.in);
        int q=sc.nextInt();
        while(q-->0)
        {
            int n=sc.nextInt();
            int xans=0;int yans=0;int xyans=0;
            HashMap<Integer,Integer> X=new HashMap<Integer,Integer>();
            HashMap<Integer,Integer> Y=new HashMap<Integer,Integer>();
            HashMap<String,Integer> XY=new HashMap<String,Integer>();
            while(n-->0)
            {
                int x=sc.nextInt();
                int y=sc.nextInt();
                if(!X.containsKey(x))
                    X.put(x,0);
                X.put(x,X.get(x)+1);

                if(!Y.containsKey(y))
                    Y.put(y,0);
                Y.put(y,Y.get(y)+1);

                String s=x+" "+y;
                if(!XY.containsKey(s))
                    XY.put(s,0);
                XY.put(s,XY.get(s)+1);
            }
            for(int i : X.keySet()) {
                int d = X.get(i);
                xans += (d*(d-1))/2;
            }
            for(int i:Y.keySet())
            {
                int d=Y.get(i);
                yans+=d*(d-1)/2;
            }
            for(String i:XY.keySet())
            {
                int d=XY.get(i);
                xyans+=d*(d-1);
            }

            System.out.println(xans+yans-xyans);
        }
    }

}
