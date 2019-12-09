package nju.test.exercise02_B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _02
{
    public static void main (String[] args) throws IOException
    {
        BufferedReader br=  new BufferedReader( new InputStreamReader( System.in ));
        int t = Integer.parseInt(br.readLine());
        for(int z=0;z<t;z++){
            int n = Integer.parseInt(br.readLine());
            String ele[] = br.readLine().split("\\s+");
            int arr[] = new int[n];
            for(int i=0;i<n;i++){
                arr[i] = Integer.parseInt(ele[i]);
            }
            StringBuilder sb = new StringBuilder();
            for(int i=0;i<n-1;i++){
                double h = arr[i+1];
                double l = arr[i];
                while(h>l){
                    double m = (h+l)/2;
                    double sum =0;
                    for(int j=0;j<n;j++){
                        sum=sum+(1/(m-arr[j]));
                    }
                    if(Math.abs(sum)<0.000000001){
                        String output = String.format("%.2f", m);
                        sb.append(output+" ");
                        break;
                    }
                    else if(sum>0){
                        l=m;
                    }
                    else{
                        h=m;
                    }
                }
            }
            System.out.println(new String(sb).trim());
        }
    }
}