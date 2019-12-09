package nju.homework._03;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * bfs,邻接矩阵
 */
public class _6_3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        while(n-- > 0){
            String[] s1 = sc.nextLine().trim().split(" ");
            int k = Integer.parseInt(s1[0]);       //邻接矩阵大小
            String start = s1[1];      //开始位置
            String[] s2 = sc.nextLine().trim().split(" ");  //a b c d
            int[][]array = new int[k][k];
            for(int i = 0;i < k;i++){
                String[]ss = sc.nextLine().split(" ");
                for(int j = 0;j < k;j++){
                    array[i][j] = Integer.parseInt(ss[j + 1]);
                }
            }
            bfs(array,s2,start);
        }
    }

    /**
     * @param edge      邻接矩阵
     * @param v         图中所有节点
     * @param start     开始位置
     */
    private static void bfs(int[][] edge, String[] v, String start) {

        //找到起始位置的index
        int index = 0;
        for (int i = 0; i < v.length; i++) {
            if (v[i].equals(start)) {
                index = i;
                break;
            }
        }

        Queue<Integer> queue = new LinkedList<>();      //存坐标
        queue.offer(index);
        boolean[] visited = new boolean[v.length];
        visited[index] = true;

        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            Integer poll = queue.poll();    //当前坐标
            sb.append(v[poll]).append(" ");
            //遍历
            for (int i = 0; i < edge.length; i++) {
                if (!visited[i] && edge[poll][i] == 1) {
                    queue.offer(i);
                    visited[i] = true;
                }
            }
        }
        System.out.println(sb.toString().trim());
    }
}
