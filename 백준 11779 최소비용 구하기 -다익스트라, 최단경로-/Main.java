import java.util.*;

class Main {
    public static int INF = Integer.MAX_VALUE;
    public static int[] distance;
    public static int[] route;
    private static ArrayList<Node>[] nodeList;
    private static int n; //도시의 개수
    private static int m; //버스의 개수

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        nodeList = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            nodeList[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            int weight = sc.nextInt();
            nodeList[start].add(new Node(end, weight));
        }
        int startNode = sc.nextInt();
        int endNode = sc.nextInt();
        System.out.println(dijkstra(startNode, endNode));
        //역추적
        Stack<Integer> stack = new Stack<>();
        while (true) {
            stack.push(endNode);
            endNode = route[endNode];
            if (endNode == startNode) {
                stack.push(endNode);
                break;
            }
        }
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }

    private static int dijkstra(int startNode, int endNode) {
        route = new int[n + 1];
        distance = new int[n + 1];
        Arrays.fill(distance, INF);
        distance[startNode] = 0;
        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.add(new Node(startNode, 0));
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            int vertex = node.vertex;
            int weight = node.weight;
            if (vertex == endNode) break;
            if (distance[vertex] < weight) continue;
            for (int i = 0; i < nodeList[vertex].size(); i++) {
                int nextVertex = nodeList[vertex].get(i).vertex;
                int nextWeight = nodeList[vertex].get(i).weight + weight;
                if (distance[nextVertex] > nextWeight) {
                    distance[nextVertex] = nextWeight;
                    route[nextVertex] = vertex;
                    queue.offer(new Node(nextVertex, nextWeight));
                }
            }
        }
        return distance[endNode];
    }

    private static class Node implements Comparable<Node> {
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