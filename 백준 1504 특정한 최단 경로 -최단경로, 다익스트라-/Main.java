import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

class Main {
    static ArrayList<Node>[] list;
    private static int n;
    private static int e;
    private static int[] distance;
    private static int INF = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt(); //정점개수
        e = sc.nextInt(); //간선개수
        list = new ArrayList[n + 1]; //정점 인접리스트
        distance = new int[n + 1]; //시작점과 다른 정점간의 최단경로
        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }
        //초기화
        for (int i = 0; i < e; i++) {
            int a = sc.nextInt(); //출발
            int b = sc.nextInt(); //도착지
            int c = sc.nextInt(); //가중치
            list[a].add(new Node(b, c));
            list[b].add(new Node(a, c));
        }
        int v1 = sc.nextInt(); //꼭 지나야하는 정점(v1 ≠ v2, v1 ≠ N, v2 ≠ 1)
        int v2 = sc.nextInt();

        long answer1 = 0;  // 1->v1->v2->n
        answer1 += dijkstra(1, v1);
        answer1 += dijkstra(v1, v2);
        answer1 += dijkstra(v2, n);
        long answer2 = 0; // 1->v2->v1->n
        answer2 += dijkstra(1, v2);
        answer2 += dijkstra(v2, v1);
        answer2 += dijkstra(v1, n);
        if (Math.min(answer1, answer2) >= INF) {
            System.out.println(-1);
            return;
        }
        System.out.println(Math.min(answer1, answer2));
    }

    private static int dijkstra(int start, int end) {
        distance = new int[n + 1];
        Arrays.fill(distance, INF);
        distance[start] = 0;
        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.add(new Node(start, 0));
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            int vertex = node.vertex;
            int weight = node.weight;
            if (distance[vertex] < weight) { //지금께 더 가중치가 크면 갱신할 필요가 없다.
                continue;
            }
            for (int i = 0; i < list[vertex].size(); i++) {//해당 정점과 연결된 것들 탐색
                int vertex2 = list[vertex].get(i).vertex;
                int weight2 = list[vertex].get(i).weight + weight;
                if (distance[vertex2] > weight2) { //지금께 더 최단경로라면 갱신해준다.
                    distance[vertex2] = weight2;
                    queue.add(new Node(vertex2, weight2));
                }
            }
        }
        return distance[end];
    }

    private static class Node implements Comparable<Node> { //우선순위큐로 성능개선(안하면 시간초과뜸)
        int vertex;
        int weight;

        Node(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return weight - o.weight;
        }
    }
}