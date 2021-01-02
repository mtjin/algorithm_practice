import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    private static boolean[] check;
    private static List<Edge>[] nodeList;

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solution(6, new int[][]{{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}});
    }

    public int solution(int n, int[][] edges) {
        int answer = 0;
        check = new boolean[n + 1];
        nodeList = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            nodeList[i] = new ArrayList<>();
        }
        Queue<Edge> queue = new LinkedList<>();
        for (int i = 0; i < edges.length; i++) {
            int a = edges[i][0];
            int b = edges[i][1];
            nodeList[a].add(new Edge(b, 0));
            nodeList[b].add(new Edge(a, 0));
            if (a == 1) {
                queue.offer(new Edge(b, 1));
                check[b] = true;
            }
            if (b == 1) {
                queue.offer(new Edge(a, 1));
                check[a] = true;
            }

        }
        check[1] = true;
        int max = Integer.MIN_VALUE;
        while (!queue.isEmpty()) {
            Edge prevEdge = queue.poll();
            if (max >= prevEdge.weight) {
                answer += 1;
            } else {
                answer = 1;
                max = prevEdge.weight;
            }
            for (int i = 0; i < nodeList[prevEdge.vertex].size(); i++) {
                Edge nextEdge = nodeList[prevEdge.vertex].get(i);
                if (!check[nextEdge.vertex]) {
                    check[nextEdge.vertex] = true;
                    queue.offer(new Edge(nextEdge.vertex, prevEdge.weight + 1));
                }
            }
        }
        System.out.println(answer);
        return answer;
    }


    private static class Edge {
        int vertex;
        int weight; //누적가중치

        Edge(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }
    }

}