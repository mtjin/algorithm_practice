import java.util.Scanner;

public class Main {
    private static int N; // 도시의 수
    private static int[][] map; // 경로
    private static boolean[] isVisited; // 도시 방문 여부
    private static int answer = Integer.MAX_VALUE;


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        map = new int[N][N];
        isVisited = new boolean[N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = sc.nextInt();
            }
        }
        for (int i = 0; i < N; i++) {
            isVisited[i] = true;
            dfs(0, i, i, 0, isVisited);
        }
        System.out.println(answer);
    }

    private static void dfs(int depth, int start, int prev, int cost, boolean[] isVisited) { // 깊이, 첫시작도시, 이전탐색도시, 총비용, 도시 방문여부
        if (depth == N - 1) {
            if (map[prev][start] != 0) {
                answer = Math.min(answer, cost + map[prev][start]); // 다시 시작점으로 돌아오는 경우 플러스
            }
            return;
        }
        for (int i = 0; i < N; i++) {
            if (!isVisited[i]) {
                isVisited[i] = true;
                if (map[prev][i] != 0) {
                    dfs(depth + 1, start, i, cost + map[prev][i], isVisited);
                }
                isVisited[i] = false;
            }
        }
    }
}