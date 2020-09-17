import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int[][] map;
    static boolean[] dfsVisited;
    static boolean[] bfsVisited;
    private static int N;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        map = new int[N + 1][N + 1];
        dfsVisited = new boolean[N + 1];
        bfsVisited = new boolean[N + 1];
        int M = sc.nextInt();
        int start = sc.nextInt();
        for (int i = 1; i <= M; i++) {
            int node1 = sc.nextInt();
            int node2 = sc.nextInt();
            map[node1][node2] = 1;
            map[node2][node1] = 1;
        }
        dfs(start);
        System.out.println();
        bfs(start);

    }

    static void dfs(int currentNode) {
        if (dfsVisited[currentNode]) return;
        dfsVisited[currentNode] = true;
        System.out.print(currentNode + " ");
        for (int i = 1; i <= N; i++) {
            if (map[currentNode][i] == 1 && !dfsVisited[i]) {
                dfs(i);
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
            for (int i = 1; i <= N; i++) {
                if (map[currentNode][i] == 1 && !bfsVisited[i]) {
                    queue.offer(i);
                    bfsVisited[i] = true;
                    System.out.print(i + " ");
                }
            }
        }
    }

}
