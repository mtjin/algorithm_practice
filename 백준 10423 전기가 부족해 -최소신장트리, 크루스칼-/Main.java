import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static int[] parents;
    private static List<Edge> edgeList = new ArrayList<>();
    private static int N; // 도시의 개수
    private static int M; // 케이블의 개수
    private static int K; // 발전소의 개수
    private static List<Integer> powerPantList = new ArrayList<>(); // 발전소 번호 리스트
    private static int answer = 0;


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        K = sc.nextInt();
        parents = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            parents[i] = i;
        }
        //발전소가 설치될 도시의 번호
        for (int i = 0; i < K; i++) {
            powerPantList.add(sc.nextInt());
        }
        // 엣지리스트 초기화
        for (int i = 0; i < M; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            int weight = sc.nextInt();
            edgeList.add(new Edge(start, end, weight));
        }
        // 크루스칼 알고리즘
        Collections.sort(edgeList);
        for (Edge edge : edgeList) {
            if (!isSameParent(edge.start, edge.end)) { //서로 연결 안된경우 union
                answer += edge.weight;
                union(edge.start, edge.end);
            }
        }

        System.out.println(answer);
    }

    private static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (!powerPantList.contains(a) && powerPantList.contains(b)) { // b만 발전소에 연결되어 있는 경우
            parents[a] = b;
        } else if (powerPantList.contains(a) && !powerPantList.contains(b)) { // a만 발전소에 연결되어 있는 경우
            parents[b] = a;
        } else { // 둘 다 아직 발전소에 연결 안된 경우
            if (a < b) {
                parents[b] = a;
            } else {
                parents[a] = b;
            }
        }
    }

    private static int find(int a) {
        if (parents[a] == a) {
            return a;
        } else {
            return parents[a] = find(parents[a]);
        }
    }

    private static boolean isSameParent(int a, int b) {
        if (powerPantList.contains(find(a)) && powerPantList.contains(find(b))) return true; // 둘다 발전소에 연결된 경우 연결된걸로 취급
        return find(a) == find(b);
    }


    static class Edge implements Comparable<Edge> {
        int start;
        int end;
        int weight;

        Edge(int start, int end, int weight) {
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