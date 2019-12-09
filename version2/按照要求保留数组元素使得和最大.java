package com.qimo.undo;
/*
Description

Given an array of N numbers, we need to maximize the sum of selected numbers. At each step, you need to select a number Ai, delete one occurrence of Ai-1 (if exists) and Ai each from the array. Repeat these steps until the array gets empty. The problem is to maximize the sum of selected numbers.


Input

The first line of the input contains T denoting the number of the test cases. For each test case, the first line contains an integer n denoting the size of the array. Next line contains n space separated integers denoting the elements of the array.

Constraints:1<=T<=100，1<=n<=50，1<=A[i]<=20

Note: Numbers need to be selected from maximum to minimum.


Output

For each test case, the output is an integer displaying the maximum sum of selected numbers.


Sample Input 1

2
3
1 2 3
6
1 2 2 2 3 4
Sample Output 1

4
10
* */
import java.util.*;
public class 按照要求保留数组元素使得和最大 {



        public static int selectTheMax(String[] num){
            int max = -1;
            int pos = -1;
            for(int i=0;i<num.length;i++){
                if(Integer.parseInt(num[i]) > max){
                    max = Integer.parseInt(num[i]);
                    pos = i;
                }
            }
            return pos;
        }

        public static void handle(String[] num,int maxpos){
            int maxnum = Integer.parseInt(num[maxpos]);
            for(int i=0;i<num.length;i ++){
                if(Integer.parseInt(num[i]) == maxnum-1){
                    num[i] = "-1";
                    break;
                }
            }
        }

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int N = sc.nextInt();
            sc.nextLine();
            while(N-- > 0){
                int count = Integer.parseInt(sc.nextLine());
                String num[] = sc.nextLine().split(" ");
                int sum = 0;
                int i = 0;
                while(i < count){
                    int temp = selectTheMax(num);
                    if(temp == -1){
                        break;
                    }
                    if(num[temp] != "-1"){
                        sum += Integer.parseInt(num[temp]);
                        handle(num,temp);
                        num[temp] = "-1";
                        i++;
                    }else{
                        break;
                    }
                }
                System.out.println(sum);
            }
        }

}
