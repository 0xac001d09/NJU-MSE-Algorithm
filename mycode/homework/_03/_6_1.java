package nju.homework._03;


import java.util.*;

/**
 * bfs无向图
 * 邻接表的写法，适合点多的情况
 */
public class _6_1 {
    static ArrayList<UndirectedGraphNode> graph;


    static class UndirectedGraphNode {
        String val;
        ArrayList<UndirectedGraphNode> neighbors;

        UndirectedGraphNode(String x) {
            val = x;
            neighbors = new ArrayList<>();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int loop = Integer.parseInt(sc.nextLine().trim());
        while (loop-- > 0) {
            Map<Integer, UndirectedGraphNode> map = new HashMap<>();
            String[] s1 = sc.nextLine().split(" ");  //4 a
            int len = Integer.parseInt(s1[0]);          //邻接矩阵长和宽
            int[][] matrix = new int[len][len];         //构造邻接矩阵

            String startNodeName = s1[1];               //开始结点名字
            UndirectedGraphNode startNode = null;       //开始结点

            String[] s2 = sc.nextLine().split(" ");  //a b c d
            for (int i = 0; i < s2.length; i++) {
                //初始化所有点,前面是编号
                if (s2[i].equals(startNodeName)) {
                    startNode = new UndirectedGraphNode(startNodeName);
                    map.put(i, startNode);
                } else {
                    map.put(i,new UndirectedGraphNode(s2[i]));
                }
            }
            //生成矩阵
            for (int i = 0; i < len; i++) {
                String[] s3 = Arrays.copyOfRange(sc.nextLine().split(" "), 1, len + 1);
                for (int j = 0; j < len; j++) {
                    matrix[i][j] = Integer.parseInt(s3[j]);
                }
            }
            //遍历矩阵右上角，填入边
            for (int i = 0; i < len; i++) {
                for (int j = i; j < len; j++) {
                    if (matrix[i][j] == 1) {
                        UndirectedGraphNode from = map.get(i);
                        UndirectedGraphNode to = map.get(j);
                        from.neighbors.add(to);
                        to.neighbors.add(from);
                    }
                }
            }

            TreeSet<String> set = solve(startNode);
            StringBuilder sb = new StringBuilder();
            for (String s : set) {
                sb.append(s + " ");
            }
            System.out.println(sb.toString().trim());
        }
    }

    private static TreeSet<String> solve(UndirectedGraphNode startNode) {
        TreeSet<String> res = new TreeSet<>();      //保证顺序
        if (startNode == null) {
            return res;
        }
        Queue<UndirectedGraphNode> queue = new LinkedList<>();
        queue.offer(startNode);

        while (!queue.isEmpty()) {
            UndirectedGraphNode node = queue.poll();
            res.add(node.val);
            for (UndirectedGraphNode neighbor : node.neighbors) {
                if (res.contains(neighbor.val)) {
                    continue;
                }
                res.add(neighbor.val);
                queue.offer(neighbor);
            }
        }
        return res;
    }

}
