import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int[][] map;
    static boolean[] bfsVisited;
    static int virusCnt = 0; //바이러스 걸리게되는 컴퓨터 수
    private static int N; //컴퓨터 수

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        map = new int[N + 1][N + 1];
        bfsVisited = new boolean[N + 1];
        int comSize = sc.nextInt();
        for (int i = 1; i <= comSize; i++) {
            int node1 = sc.nextInt();
            int node2 = sc.nextInt();
            map[node1][node2] = 1;
            map[node2][node1] = 1;
        }
        bfs(1);
        System.out.println(virusCnt);
    }

    static void bfs(int currentNode) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(currentNode);
        bfsVisited[currentNode] = true;
        while (!queue.isEmpty()) {
            currentNode = queue.poll();
            for (int i = 1; i <= N; i++) {
                if (map[currentNode][i] == 1 && !bfsVisited[i]) {
                    queue.offer(i);
                    bfsVisited[i] = true;
                    virusCnt++;
                }
            }
        }
    }

}
