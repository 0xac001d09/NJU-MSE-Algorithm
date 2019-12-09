package nju.review1;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

//距离问题，通过化简得：只有x1 = x2 或 y1 = y2时，才能使得两个距离相等
//那么就是求输入的这么多的点中，有多少个点x1 = x2或y1 = y2，再减去公共部分
public class mat_3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int loop = sc.nextInt();
        while (loop-- > 0) {
            int dots = sc.nextInt();

            int xans = 0, yans = 0, xyans = 0;
            Map<Integer, Integer> xmap = new HashMap<>();
            Map<Integer, Integer> ymap = new HashMap<>();
            Map<String, Integer> xymap = new HashMap<>();
            while (dots-- > 0) {
                int x = sc.nextInt();
                int y = sc.nextInt();
                if (!xmap.containsKey(x)) {
                    xmap.put(x, 1);
                } else {
                    xmap.put(x, xmap.get(x) + 1);
                }

                if (!ymap.containsKey(y)) {
                    ymap.put(y, 1);
                } else {
                    ymap.put(y, ymap.get(y) + 1);
                }

                String xy = x + "," + y;
                if (!xymap.containsKey(xy)) {
                    xymap.put(xy, 1);
                } else {
                    xymap.put(xy, xymap.get(xy) + 1);
                }

            }
            //统计横坐标相等的点的个数后，假设有d个点横坐标相等,那可以组成(d * (d - 1)) / 2对点
            //比如有两个点的横坐标相等，那就能组成1对，比如有3个点的横坐标相等，那就能组成3对，这个公式就是上面的
            for (Integer key : xmap.keySet()) {
                Integer d = xmap.get(key);
                xans += (d * (d - 1)) / 2;
            }
            //同理
            for (Integer key : ymap.keySet()) {
                Integer d = ymap.get(key);
                yans += (d * (d - 1)) / 2;
            }
            // 去重
            for (String key : xymap.keySet()) {
                Integer d = xymap.get(key);
                xyans += (d * (d - 1));
            }
            System.out.println(xans + yans - xyans);
        }
    }
}
