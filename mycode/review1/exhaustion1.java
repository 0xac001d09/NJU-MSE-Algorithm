package nju.review1;

import java.util.*;

/**
 * 分配问题
 * 全排列得到所有情况，然后找最小时间
 */
public class exhaustion1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int loop = Integer.parseInt(sc.nextLine().trim());
        while (loop-- > 0) {
            int n = Integer.parseInt(sc.nextLine().trim()); //任务个数
            int[][] matrix = new int[n][n];
            //不用初始化矩阵，题目中说了每个人都能做所有任务
            String[] strs = sc.nextLine().split(",");
            for (String str : strs) {
                String[] s = str.split(" ");
                int num = Integer.parseInt(s[0]);       //s[0]人员序号
                int task = Integer.parseInt(s[1]);      //s[1]对应任务
                int time = Integer.parseInt(s[2]);      //s[2]耗费时间
                matrix[num - 1][task - 1] = time;
            }
            solve(matrix);
        }
    }

    private static void solve(int[][] matrix) {
        List<List<Integer>> temp = new ArrayList<>();   //存放所有全排列任务可能
        //利用dfs得出所有可能的任务情况
        int n = matrix.length;
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = i;
        }
        boolean[] visited = new boolean[n];
        dfs(n, visited, new ArrayList<Integer>(), temp);

        //计算每种情况耗费的时间
        List<List<Integer>> res = new ArrayList<>();
        int minTime = Integer.MAX_VALUE;
        for (List<Integer> list : temp) {
            int time = 0;
            for (int i = 0; i < list.size(); i++) {
                time += matrix[i][list.get(i)];   //每个人及其任务编号
            }
            if (time == minTime) {
                res.add(list);
            } else if (time < minTime) {
                minTime = time;
                res.clear();
                res.add(list);
            }
        }
        //打印结果，要记得任务编号从1开始，都要+1,结果按照人员分配的任务序号大小排，第一个人员的任务序号大的放在前面，如果相同则看第二个人员的任务，以此类推。
        Collections.sort(res, new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> o1, List<Integer> o2) {
                int res = 0;
                for (int i = 0; i < o1.size();) {
                    res = o2.get(i) - o1.get(i);
                    if (res != 0) {
                        break;
                    } else {
                        i++;
                    }
                }
                return res;
            }
        });
        print(res);
    }

    private static void dfs(int taskNum, boolean[] visited, List<Integer> list, List<List<Integer>> res) {
        if (list.size() == taskNum) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < taskNum; i++) {
            if (!visited[i]) {
                list.add(i);
                visited[i] = true;
                dfs(taskNum, visited, list, res);
                list.remove(list.size() - 1);
                visited[i] = false;
            }
        }
    }

    private static void print(List<List<Integer>> res) {
        for (int i = 0; i < res.size(); i++) {
            if (i == res.size() - 1) {
                List<Integer> list = res.get(i);
                for (int j = 0; j < list.size(); j++) {
                    if (j == list.size() - 1) {
                        System.out.println(list.get(j) + 1);
                    } else {
                        System.out.print((list.get(j) + 1) + " ");
                    }
                }
            } else {
                List<Integer> list = res.get(i);
                for (int j = 0; j < list.size(); j++) {
                    if (j == list.size() - 1) {
                        System.out.print((list.get(j) + 1) + ",");
                    } else {
                        System.out.print((list.get(j) + 1) + " ");
                    }
                }

            }
        }
    }
}
