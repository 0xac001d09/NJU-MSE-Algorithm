package nju.test.exercise02_A;

import java.util.*;

//点的凸包
public class _02_2 {

    static class Point implements Comparable {
        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Object o) {
            Point pN = ((Point) o);
            if (pN.x == x) {
                return y - pN.y;
            } else {
                return x - pN.x;
            }
        }

        @Override
        public String toString() {
            return x + " " + y;
        }

        @Override
        public boolean equals(Object o) {
            return ((Point) o).x == x && ((Point) o).y == y;
        }

        @Override
        public int hashCode() {
            return (10000 * x) + y;
        }
    }

    private static List<Point> findHull(Point[] points) {
        Point start = points[0];
        //找到最左边的点作为起点
        for (int i = 1; i < points.length; i++) {
            if (points[i].x < start.x) {
                start = points[i];
            }
        }
        Point current = start;
        Set<Point> result = new HashSet<>();    //结果集
        result.add(start);  //结果集中添加点
        List<Point> collinearPoints = new ArrayList<>();    //共线点的集合
        while (true) {
            Point nextTarget = points[0];
            for (int i = 1; i < points.length; i++) {
                if (points[i] == current) {
                    continue;
                }
                int val = cross(current, nextTarget, points[i]);
                if (val > 0) {
                    nextTarget = points[i];
                    collinearPoints = new ArrayList<>();
                } else if (val == 0) {
                    if (distance(current, nextTarget, points[i]) < 0) {
                        collinearPoints.add(nextTarget);
                        nextTarget = points[i];
                    } else {
                        collinearPoints.add(points[i]);
                    }
                }
            }

            result.addAll(collinearPoints);
            if (nextTarget == start) {
                break;
            }
            result.add(nextTarget);
            current = nextTarget;
        }
        return new ArrayList<>(result);

    }
    //两个向量叉积，判断方向，大于0同向，小于0反向
    public static int cross(Point a, Point b, Point c) {
        int abx = b.x - a.x;
        int aby = b.y - a.y;
        int acx = c.x - a.x;
        int acy = c.y - a.y;
        return Integer.compare((abx * acy - aby * acx), 0);
    }

    private static int distance(Point a, Point b, Point c) {
        int abx = b.x - a.x;
        int aby = b.y - a.y;
        int acx = c.x - a.x;
        int acy = c.y - a.y;
        return Integer.compare(abx * abx + aby * aby - acx * acx - acy * acy, 0);

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int t = sc.nextInt();
            if (t < 3) {
                System.out.println(-1);
                for (int j = 0; j < t; j++) {
                    sc.nextInt();
                    sc.nextInt();
                }
                continue;
            }
            Point[] pts = new Point[t];
            for (int j = 0; j < t; j++) {
                pts[j] = new Point(sc.nextInt(), sc.nextInt());
            }
            List<Point> hull = findHull(pts);
            Collections.sort(hull);
            if (hull.size() > 2) {
                for (int j = 0; j < hull.size(); j++) {
                    System.out.print(hull.get(j) + (j == hull.size() - 1 ? "" : ", "));
                }
            } else {
                System.out.print(-1);
            }
            System.out.println();
        }
    }
}