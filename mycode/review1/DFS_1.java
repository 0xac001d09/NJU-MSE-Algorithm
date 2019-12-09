package nju.review1;

import java.util.Scanner;

/**
 * 图的DFS
 */
public class DFS_1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int loop = Integer.parseInt(sc.nextLine().trim());
        while (loop-- > 0) {
            String[] s1 = sc.nextLine().split(" ");
            int size = Integer.parseInt(s1[0]);
            String start = s1[1];
            String[] strs = sc.nextLine().split(" ");
            int[][] edges = new int[size][size];
            for (int i = 0; i < size; i++) {
                String[] s = sc.nextLine().split(" ");
                for (int j = 0; j < size; j++) {
                    edges[i][j] = Integer.parseInt(s[j + 1]);
                }
            }

            solve(edges, strs, start);
        }
    }

    private static void solve(int[][] edges, String[] strs, String start) {
        boolean[] visited = new boolean[edges.length];
        System.out.println(dfs(edges, visited, strs, start));

    }

    private static int dfs(int[][] edges, boolean[] visited, String[] strs, String start) {
        //找到这个start的行号
        int index = 0;
        for (int i = 0; i < strs.length; i++) {
            if (strs[i].equals(start)) {
                index = i;
                break;
            }
        }
        int count = 0;
        //如果这个位置没有被访问过，就+1
        if (!visited[index]) {
            count++;
            visited[index] = true;
            //遍历它的所有邻居
            for (int i = 0; i < edges[0].length; i++) {
                if (!visited[i] && edges[index][i] == 1) {
                    count = Math.max(count, dfs(edges, visited, strs, strs[i])) + 1;
                }
            }
        }
        return count;
    }
}
