package nju.homework._03;

import java.lang.reflect.Array;
import java.util.*;

/**
 * dfs无向图 邻接矩阵的写法,简单
 */
public class _6_2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int loop = Integer.parseInt(sc.nextLine().trim());
        while (loop-- > 0) {
            String[] s1 = sc.nextLine().split(" ");
            int n = Integer.parseInt(s1[0]);        //4
            String start = s1[1];                   //a
            String s = sc.nextLine();
            String[] s2 = s.split(" ");
            int startIndex = s.indexOf(start); //起点位置

            // 构造邻接矩阵
            int[][] edge = new int[n][n];         //构造邻接矩阵
            for (int i = 0; i < n; i++) {
                String[] s3 = Arrays.copyOfRange(sc.nextLine().split(" "), 1, n + 1);
                for (int j = 0; j < n; j++) {
                    edge[i][j] = Integer.parseInt(s3[j]);
                }
            }
            ArrayList<Integer> res = new ArrayList<>();
            boolean[] visited = new boolean[n];
            bfsGraph(edge, startIndex, visited, res);

            //print
            for (int i = 0; i < res.size(); i++) {
                if (i == res.size() - 1) {
                    System.out.println(s2[res.get(i)]);
                } else {
                    System.out.print(s2[res.get(i)] + " ");

                }
            }
        }
    }

    private static ArrayList<Integer> getNeighbor(int[][] edge, int v) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = v + 1; i < edge[0].length; i++) {
            if (edge[v][i] == 1) {
                list.add(i);
            }
        }
        return list;
    }

    private static void bfsGraph(int[][] edges, int startIndex, boolean[] visited, ArrayList<Integer> res) {
        res.add(startIndex);
        visited[startIndex] = true;

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(startIndex);

        while (!queue.isEmpty()) {
            Integer v = queue.poll();
            ArrayList<Integer> neighbors = getNeighbor(edges, v);
            for (Integer neighbor : neighbors) {
                if (!visited[neighbor]) {
                    queue.offer(neighbor);
                    visited[neighbor] = true;
                    res.add(neighbor);
                }
            }
        }
    }

}
