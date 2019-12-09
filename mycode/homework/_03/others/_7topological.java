package nju.homework._03.others;

import java.util.*;

public class _7topological {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int loop = Integer.parseInt(sc.nextLine().trim());
        while (loop-- > 0) {
            Map<Character, List<String>> map = new TreeMap<>();
            Set<Character> set = new HashSet<>();
            Set<Character> fromSet = new HashSet<>();
            Set<Character> toSet = new HashSet<>();
            String[] tmp = sc.nextLine().trim().split(",");
            for (int i = 0; i < tmp.length; i++) {
                String[] tmp2 = tmp[i].trim().split(" ");
                set.add(tmp2[0].charAt(0));
                set.add(tmp2[1].charAt(0));
                fromSet.add(tmp2[0].charAt(0));
                toSet.add(tmp2[1].charAt(0));
                if (map.containsKey(tmp2[0].charAt(0))) {
                    List<String> list = map.get(tmp2[0].charAt(0));
                    list.add(tmp2[1]);
                    map.put(tmp2[0].charAt(0), list);
                } else {
                    List<String> list = new LinkedList<>();
                    list.add(tmp2[1]);
                    map.put(tmp2[0].charAt(0), list);
                }
            }
            boolean[] visited = new boolean[28];
            helper(map, set, fromSet, toSet, visited);
            System.out.println(count);
        }
    }

    public static void helper(Map<Character, List<String>> map, Set<Character> set, Set<Character> fromSet, Set<Character> toSet, boolean[] visited) {
        Iterator<Character> it = fromSet.iterator();
        while (it.hasNext()) {
            char s = it.next();
            if (!toSet.contains(s)) {
                visited[(s - 'a')] = true;
                dfs(map, s, visited);
            }
        }
    }

    static int count = 0;

    public static void dfs(Map<Character, List<String>> map, char s, boolean[] visited) {
        if (!map.containsKey(s)) {
            count++;
            return;
        }
        if (map.containsKey(s)) {
            List<String> list = map.get(s);
            for (int i = 0; i < list.size(); i++) {
                if (visited[list.get(i).charAt(0) - 'a'] == false) {
                    visited[list.get(i).charAt(0) - 'a'] = true;
                    dfs(map, list.get(i).charAt(0), visited);
                    visited[list.get(i).charAt(0) - 'a'] = false;
                }
            }
        }
    }

}

