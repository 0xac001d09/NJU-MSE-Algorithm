package nju.test.exercise02_A;

import java.util.LinkedList;
import java.util.Scanner;

class Point {
    int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class _02 {

    public static int orientation(Point p, Point q, Point r)
    {
        int val = (q.y - p.y) * (r.x - q.x) -
                (q.x - p.x) * (r.y - q.y);

        if (val == 0) return 0;  // 说明是共线的
        return (val > 0)? 1: 2; // 顺时针或者是逆时针
    }

    // 打印一组n点的凸包
    public static void convexHull(Point points[], int n) {
        // 少于三个点就return
        if (n < 3) return;

        // 初始化结果集
        LinkedList<Point> hull = new LinkedList<>();

        // 找到最左边的点
        int l = 0;
        for (int i = 1; i < n; i++)
            if (points[i].x < points[l].x)
                l = i;

        //从最左边的点开始，逆时针移动，直到再次到达起点，一共走了m次，就输出m个点
        int p = l, q;

        do {
            // 添加当前点到结果集
            hull.add(points[p]);

            //搜索点“ q”，使所有点“ x”的方向（p，x，q）沿逆时针方向。想法是跟踪q中最后访问的最逆时针点。如果任何点“ i”都比q逆时针旋转，则更新q。
            q = (p + 1) % n;

            for (int i = 0; i < n; i++) {
                //如果i比当前q更逆时针，则更新q
                if (orientation(points[p], points[i], points[q])
                        == 2)
                    q = i;
            }
            //现在q是最逆时针的了，进行下次迭代时会被放入结果集
            p = q;

        } while (p != l);

        //打印结果
        String res = "";
        for (int i = 0; i < hull.size(); i++) {
            if (i == hull.size() - 1) {
                res += hull.get(i).x + " " + hull.get(i).y;
            } else {
                res += hull.get(i).x + " " + hull.get(i).y + ", ";
            }
        }
        System.out.println(res);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int loop = Integer.parseInt(sc.nextLine().trim());
        while (loop-- > 0) {
            int n = Integer.parseInt(sc.nextLine());        //点的个数
            String s = sc.nextLine();                       //点的坐标
            String[] nums = s.split(" ");            //点的坐标
            Point[] points = new Point[n];
            for (int i = 0; i < points.length; i++) {
                int x = Integer.parseInt(nums[i * 2]);
                int y = Integer.parseInt(nums[i * 2 + 1]);

                points[i] = new Point(x,y);

             }
            convexHull(points,n);
        }

    }


}
