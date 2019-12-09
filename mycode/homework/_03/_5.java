package nju.homework._03;

import java.util.Scanner;

/**
 * dfs图
 */
public class _5 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        while(n-- > 0){
            String[] s1 = sc.nextLine().trim().split(" ");
            int size = Integer.parseInt(s1[0]);       //邻接矩阵大小
            String start = s1[1];      //开始位置
            String[] s2 = sc.nextLine().trim().split(" ");  //a b c d
            int[][]array = new int[size][size];
            for(int i = 0;i < size;i++){
                String[]ss = sc.nextLine().split(" ");
                for(int j = 0;j < size;j++){
                    array[i][j] = Integer.parseInt(ss[j + 1]);
                }
            }
            boolean[] visited = new boolean[size];
            int res = dfs(array, start, s2, visited);
            System.out.println(res);
        }
    }

    public static int dfs(int[][]edge,String start,String[] v,boolean[]visited){
        int index = 0;
        for(int i = 0;i < v.length;i++){
            if(start.equals(v[i])){
                index = i;
                break;
            }
        }
        visited[index] = true;
        boolean flag = true;
        for(int i = 0;i < edge[index].length;i++){
            if(visited[i] == false && edge[index][i] == 1){
                flag = false;
                break;
            }
        }
        if (flag == true) {
            return 1;
        }
        int max = 0;
        for(int i = 0;i < edge[index].length;i++){
            if(visited[i] == false && edge[index][i] == 1){
                max = Math.max(dfs(edge,v[i],v,visited),max) + 1;
            }
        }
        return max;

    }
}
