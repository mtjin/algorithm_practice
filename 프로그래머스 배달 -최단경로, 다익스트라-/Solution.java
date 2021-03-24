import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

class Solution {
    private static ArrayList<Edge>[] edgeList; // 도시 인접리스트
    private static int[] distance; // 1번 도시와 다른 도시간의 최단 경로

    private static void dijkstra() {
        PriorityQueue<Edge> queue = new PriorityQueue<>();
        queue.add(new Edge(1, 0));
        while (!queue.isEmpty()) {
            Edge edge = queue.poll();
            int vertex = edge.vertex;
            int weight = edge.weight;
            if (distance[vertex] < weight) {
                continue;
            }
            for (int i = 0; i < edgeList[vertex].size(); i++) { // 해당 도시와 연결되 있는 도시들 탐색
                int vertex2 = edgeList[vertex].get(i).vertex;
                int weight2 = edgeList[vertex].get(i).weight + weight;
                if (distance[vertex2] > weight2) { // 최단경로 세팅
                    distance[vertex2] = weight2;
                    queue.add(new Edge(vertex2, weight2));
                }
            }
        }
    }


    public int solution(int N, int[][] road, int K) { // N : 마을의 개수, road : 마을번호와 비용, K : 최대 가능한 비용
        int answer = 0;
        //초기화 과정
        edgeList = new ArrayList[N + 1];
        distance = new int[N + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        for (int i = 1; i <= N; i++) {
            edgeList[i] = new ArrayList<>();
        }
        for (int i = 0; i < road.length; i++) {
            edgeList[road[i][0]].add(new Edge(road[i][1], road[i][2]));
            edgeList[road[i][1]].add(new Edge(road[i][0], road[i][2]));
        }
        distance[1] = 0; //1번 도시 - 자신 최단 경로 0
        //다익스트라
        dijkstra();
        // 1번마을에서 K 이하 비용인 도시 개수 구하기
        for (int cost : distance) {
            if (cost <= K) {
                answer++;
            }
        }
        return answer;
    }

    private static class Edge implements Comparable<Edge> {
        int vertex; //
        int weight; //배달주문 시간

        public Edge(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return weight - o.weight;
        }
    }
}