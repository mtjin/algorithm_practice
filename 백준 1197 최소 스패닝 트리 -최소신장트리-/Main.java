import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Main {
    private static int[] parent;
    private static ArrayList<Edge> edgeList = new ArrayList<>();
    private static int answer = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int V = sc.nextInt(); //노드
        int E = sc.nextInt(); //간선
        //parent 초기화
        parent = new int[V + 1];
        for (int i = 1; i <= V; i++) {
            parent[i] = i;
        }
        //연결노드 초기화
        for (int e = 0; e < E; e++) {
            int A = sc.nextInt(); //연결노드
            int B = sc.nextInt(); //연결노드
            int C = sc.nextInt(); //가중치
            edgeList.add(new Edge(A, B, C));
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
        System.out.println(answer);
    }

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