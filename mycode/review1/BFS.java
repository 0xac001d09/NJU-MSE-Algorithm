package nju.review1;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * BFS图
 */
public class BFS {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        while(n-- > 0){
            String[] s1 = sc.nextLine().trim().split(" ");
            int k = Integer.parseInt(s1[0]);       //邻接矩阵大小
            String start = s1[1];      //开始位置
            String[] s2 = sc.nextLine().trim().split(" ");  //a b c d
            int[][]edges = new int[k][k];
            for(int i = 0;i < k;i++){
                String[]ss = sc.nextLine().split(" ");
                for(int j = 0;j < k;j++){
                    edges[i][j] = Integer.parseInt(ss[j + 1]);
                }
            }
            bfs(edges,s2,start);
        }
    }

    private static void bfs(int[][] edges, String[] strs, String start) {
        //找点起始点的坐标
        int index = 0;
        for (int i = 0; i < strs.length; i++) {
            if (strs[i].equals(start)) {
                index = i;
                break;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(index);
        boolean[] visited = new boolean[strs.length];
        visited[index] = true;
        StringBuilder sb = new StringBuilder();
        sb.append(strs[index] + " ");


        while (!queue.isEmpty()) {
            Integer poll = queue.poll();

            for (int i = 0; i < edges[0].length; i++) {
                if (!visited[i] && edges[poll][i] == 1) {
                    queue.offer(i);
                    visited[i] = true;
                    sb.append(strs[i]+" ");
                }

            }
        }
        System.out.println(sb.toString().trim());
    }
}
