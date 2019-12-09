package nju.homework._03;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 拓扑排序的个数
 * 思路是求每个结点的入度，对每个入度求出全排序的个数，然后全部相乘
 *
 * 一般必须考虑无解的情况.......这个题比较蠢，不需要考虑无解的情况，所以无脑全排列了
 *
 */
public class _7 {

    static ArrayList<DirectedGraphNode> graph;

    static class DirectedGraphNode {
        String val;
        ArrayList<DirectedGraphNode> neighbors;

        public DirectedGraphNode(String val) {
            this.val = val;
            neighbors = new ArrayList<>();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int loop = Integer.parseInt(sc.nextLine().trim());
        while (loop-- > 0) {
            graph = new ArrayList<>();

            String[] strs = sc.nextLine().split(",");
            for (String str : strs) {
                String[] s = str.split(" ");

                String from = s[0];
                String to = s[1];

                //如果已经添加过这个结点，就不用重复添加
                DirectedGraphNode fromNode = null;
                DirectedGraphNode toNode = null;

                boolean flag1 = false;
                boolean flag2 = false;

                for (DirectedGraphNode node : graph) {
                    if (node.val.equals(from)) {
                        fromNode = node;
                        flag1 = true;
                        break;
                    }
                }
                for (DirectedGraphNode node : graph) {
                    if (node.val.equals(to)) {
                        toNode = node;
                        flag2 = true;
                        break;
                    }
                }
                if (!flag1) {
                    fromNode = new DirectedGraphNode(from);
                    graph.add(fromNode);
                }
                if (!flag2) {
                    toNode = new DirectedGraphNode(to);
                    graph.add(toNode);
                }
                fromNode.neighbors.add(toNode);

            }
            System.out.println(solve(graph));
        }
    }

    //一般必须考虑无解的情况.......这个题比较蠢，不需要考虑无解的情况
    private static int solve(ArrayList<DirectedGraphNode> graph) {
        int res = 1;
        Map<DirectedGraphNode, Integer> indegree = getIndegree(graph);
        for (Integer value : indegree.values()) {
            if (value > 1) {
                res *= premute(value);
            }
        }
        return res;
    }

    private static Map<DirectedGraphNode, Integer> getIndegree(ArrayList<DirectedGraphNode> graph) {
        Map<DirectedGraphNode, Integer> indegree = new HashMap<>();
        for (DirectedGraphNode node : graph) {
            indegree.put(node, 0);
        }

        for (DirectedGraphNode node : graph) {
            for (DirectedGraphNode neighbor : node.neighbors) {
                indegree.put(neighbor, indegree.get(neighbor) + 1);
            }
        }
        return indegree;
    }

    //根据给定数字求全排列，An n = n！
    private static int premute(int n) {
        if (n == 0) {
            return 1;
        }
        return n * premute(n - 1);
    }

}
