import java.util.*;

class Main {
    private static int N; //행성 개수
    private static Space[] spaces;
    private static List<Space> spaceList = new ArrayList<>();
    private static int[] parent;
    private static long answer = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        parent = new int[N];
        spaces = new Space[N];
        for (int i = 0; i < N; i++) {
            parent[i] = i;
            int x = sc.nextInt();
            int y = sc.nextInt();
            int z = sc.nextInt();
            spaces[i] = new Space(i, x, y, z);
        }
        //x, y, z 각 좌표로 정렬된 3개의 리스트 생성
        List<Space> xList = new ArrayList<>(Arrays.asList(spaces));
        xList.sort((o1, o2) -> o1.x - o2.x);
        List<Space> yList = new ArrayList<>(Arrays.asList(spaces));
        yList.sort((o1, o2) -> o1.y - o2.y);
        List<Space> zList = new ArrayList<>(Arrays.asList(spaces));
        zList.sort((o1, o2) -> o1.z - o2.z);
        //모든 행성 관계 연결(엣지 초기화)
        PriorityQueue<Edge> queue = new PriorityQueue<>();
        for (int i = 0; i < N - 1; i++) {
            Space space1 = xList.get(i);
            Space space2 = xList.get(i + 1);
            queue.offer(new Edge(space1.num, space2.num, Math.min(Math.abs(space1.x - space2.x), Math.min(Math.abs(space1.y - space2.y), Math.abs(space1.z - space2.z)))));
            space1 = yList.get(i);
            space2 = yList.get(i + 1);
            queue.offer(new Edge(space1.num, space2.num, Math.min(Math.abs(space1.x - space2.x), Math.min(Math.abs(space1.y - space2.y), Math.abs(space1.z - space2.z)))));
            space1 = zList.get(i);
            space2 = zList.get(i + 1);
            queue.offer(new Edge(space1.num, space2.num, Math.min(Math.abs(space1.x - space2.x), Math.min(Math.abs(space1.y - space2.y), Math.abs(space1.z - space2.z)))));
        }
        //탐색 및 연결
        while (!queue.isEmpty()) {
            Edge edge = queue.poll();
            if (!isSameParent(edge.vertex1, edge.vertex2)) {
                answer += edge.weight;
                union(edge.vertex1, edge.vertex2);
            }
        }
        System.out.println(answer);
    }

    private static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a > b) parent[a] = b;
        else parent[b] = a;
    }

    private static int find(int a) {
        if (parent[a] == a) return a;
        else return parent[a] = find(parent[a]);
    }

    private static boolean isSameParent(int a, int b) {
        return find(a) == find(b);
    }

    static class Space {
        int num;
        int x;
        int y;
        int z;

        Space(int num, int x, int y, int z) {
            this.num = num;
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }

    private static class Edge implements Comparable<Edge> {
        int vertex1;
        int vertex2;
        int weight;

        public Edge(int vertex1, int vertex2, int weight) {
            this.vertex1 = vertex1;
            this.vertex2 = vertex2;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return weight - o.weight;
        }
    }
}