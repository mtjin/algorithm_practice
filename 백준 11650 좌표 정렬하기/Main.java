package SecondEx;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int map[][]; // 인접배열
    static boolean dfsVisited[]; //노드 방문 여부
    static boolean bfsVisited[];
    static int nodeCount;
    static int edgeCount;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        //최대 정점의 개수 N(1 ≤ N ≤ 1,000)
        nodeCount = Integer.parseInt(st.nextToken());
        map = new int[nodeCount + 1][nodeCount + 1];
        dfsVisited = new boolean[nodeCount + 1];
        bfsVisited = new boolean[nodeCount + 1];

        //최대 간선의 개수 M(1 ≤ M ≤ 10,000)
        edgeCount = Integer.parseInt(st.nextToken());

        //시작 정점 노드
        int startNode = Integer.parseInt(st.nextToken());

        //맵 세팅 (인덱스 1부터 세팅함)
        for (int i = 1; i <= edgeCount; i++) {
            st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());
            map[node1][node2] = map[node2][node1] = 1;
        }

        //탐색 시작
        dfs(startNode);
        System.out.println();
        bfs(startNode);
    }

    static void dfs(int currentNode) {
        if (dfsVisited[currentNode] == true) {
            return;
        }
        dfsVisited[currentNode] = true;
        System.out.print(currentNode + " ");
        for (int j = 1; j <= nodeCount; j++) {
            //연결되고 방문 안된 노드 탐색 (낮은 노드부터 방문됨)
            if (map[currentNode][j] == 1 && dfsVisited[j] == false) {
                dfs(j);
            }
        }
    }

    static void bfs(int currentNode) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(currentNode);
        bfsVisited[currentNode] = true;
        System.out.print(currentNode + " ");
        while (!queue.isEmpty()) {
            currentNode = queue.poll();
            //현재 노드와 연결된 방문안된 노드들을 방문 후 큐에 추가
            for (int j = 1; j <= nodeCount; j++) {
                if (map[currentNode][j] == 1 && bfsVisited[j] == false) {
                    queue.offer(j);
                    bfsVisited[j] = true;
                    System.out.print(j + " ");
                }
            }
        }
    }
}
