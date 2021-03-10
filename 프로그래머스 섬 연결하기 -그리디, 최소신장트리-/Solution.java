import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    private static int[] parent;
    private static List<Edge> edgeList = new ArrayList<>();

    private static void union(int x, int y) {
        x = find(x);
        y = find(y);
        if (x != y) {
            if (x < y) parent[y] = x;
            else parent[x] = y;
        }
    }

    private static int find(int x) {
        if (parent[x] == x) {
            return x;
        } else {
            return parent[x] = find(parent[x]);
        }
    }

    private static boolean isSameParent(int x, int y) {
        x = find(x);
        y = find(y);
        return x == y;
    }

    public int solution(int n, int[][] costs) {
        int answer = 0;
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        for (int i = 0; i < costs.length; i++) {
            int start = costs[i][0];
            int end = costs[i][1];
            int weight = costs[i][2];
            edgeList.add(new Edge(start, end, weight));
        }
        Collections.sort(edgeList); //가중치 오름차순 정렬
        //최소신장트리 탐색
        for (int i = 0; i < edgeList.size(); i++) {
            Edge edge = edgeList.get(i);
            if (!isSameParent(edge.start, edge.end)) { //사이클이 발생하지 않은 경우 연결
                answer += edge.weight;
                union(edge.start, edge.end); //연결
            }
        }
        return answer;
    }

    static class Edge implements Comparable<Edge> {
        int start;
        int end;
        int weight;

        public Edge(int start, int end, int weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return weight - o.weight;
        }
    }

}