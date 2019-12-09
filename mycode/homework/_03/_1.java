package nju.homework._03;


import java.util.*;

/**
 * 分配问题：对给定的n个任务与n个人之间的成本矩阵完成成本最低的任务分配策略。
 * 输入：输入：第一行为用例个数，之后为每一个用例；用例的第一行为任务个数，即n；用例的第二行为使用逗号隔开的人员完成任务的成本；
 *      每一个成本描述包括人员序号、任务序号和成本，使用空格隔开。人员序号和任务序号都是从1到n的整数，序号出现的次序没有固定规则。
 *
 * 输出：输出：每一个用例输出一行，从序号为1的人员开始，给出其分配的任务序号，使用空格隔开；使用逗号将多个解隔开。
 *      结果按照人员分配的任务序号大小排，第一个人员的任务序号大的放在前面，如果相同则看第二个人员的任务，以此类推。
 *
 * 思路：dfs全排列类型问题，类似n皇后，比n皇后简单,这里使用全排列思路即可
 *      用矩阵m[i][j]来存储序号为i的人员，完成第j个任务所花的时间，如果不能完成任务，那花费时间就是无穷大。
 *      每一列都是一个任务，每个任务只能有一个人做，
 *      结果是从序号为1的人员开始，给出其分配的任务序号（横坐标对应第几列），使用空格隔开；使用逗号将多个解隔开，也就是要求出多个解
 *
 */
public class _1 {

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
        dfs(nums, visited, new ArrayList<Integer>(), temp);

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

    private static void dfs(int[] nums,boolean[] visited,List<Integer> list, List<List<Integer>> res) {
        if (list.size() == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }
        //递归拆解
        for (int i = 0; i < nums.length; i++) {
            if (!visited[i]) {
                //先写状态重置,再中间插入递归，后面是标注的顺序
                list.add(nums[i]);              //1.1   添加
                visited[i] = true;              //1.2   标记为被访问过
                dfs(nums, visited, list, res);    //3.1
                list.remove(list.size() - 1);   //2.1   删除
                visited[i] = false;                   //2.2    标记为没访问过
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
