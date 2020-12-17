import java.util.*;

class Main {
    private static int N;
    private static int M;
    private static int INF = Integer.MAX_VALUE;
    private static int[] distance;
    private static List<Edge>[] edgeList;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        distance = new int[N + 1];
        edgeList = new ArrayList[N + 1];
        Arrays.fill(distance, INF);
        for (int i = 1; i <= N; i++) {
            edgeList[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            int weight = sc.nextInt();
            edgeList[start].add(new Edge(end, weight));
        }
        int start = sc.nextInt();
        int end = sc.nextInt();
        dijkstra(start, end);
        System.out.println(distance[end]);
    }

    private static void dijkstra(int start, int end) {
        PriorityQueue<Edge> queue = new PriorityQueue<>();
        distance[start] = 0;
        queue.offer(new Edge(start, 0));
        while (!queue.isEmpty()) {
            Edge edge = queue.poll();
            int vertex = edge.vertex;
            int weight = edge.weight;
            if (distance[vertex] < weight) {
                continue;
            }
            for (int i = 0; i < edgeList[vertex].size(); i++) {
                int vertex2 = edgeList[vertex].get(i).vertex;
                int weight2 = edgeList[vertex].get(i).weight + weight;
                if (distance[vertex2] > weight2) {
                    distance[vertex2] = weight2;
                    queue.offer(new Edge(vertex2, weight2));
                }
            }
        }
    }

    private static class Edge implements Comparable<Edge> {
        int vertex;
        int weight;

        public Edge(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge e) {
            return weight - e.weight;
        }
    }
}