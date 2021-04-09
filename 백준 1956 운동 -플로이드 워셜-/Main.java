import java.util.Arrays;
import java.util.Scanner;

class Main {
    private static int V; // V개의 마을
    private static int E; // E개의 도로
    private static int[][] distance; // 도로의 최소거리
    private static int INF = 10000 * 400 + 1;
    private static int answer = 10000 * 400 + 1;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        V = sc.nextInt();
        E = sc.nextInt();
        distance = new int[V + 1][V + 1];
        //초기화
        for (int i = 1; i <= V; i++) {
            Arrays.fill(distance[i], INF);
        }
        for (int i = 0; i < E; i++) {
            int start = sc.nextInt(); // a번 마을
            int end = sc.nextInt(); // b번 마을
            int cost = sc.nextInt();
            distance[start][end] = cost; //(a, b) 쌍이 같은 도로가 여러 번 주어지지 않는다.
            // distance[end][start] = cost; // (a → b임에 주의)
        }
        floyd();
        // 최소 사이클 중 최솟값을 구한다.
        for (int i = 1; i <= V; i++) {
            answer = Math.min(distance[i][i], answer);
        }
        if (answer == INF) {
            System.out.println(-1);
        } else {
            System.out.println(answer);
        }
    }

    private static void floyd() {
        for (int k = 1; k <= V; k++) {
            for (int i = 1; i <= V; i++) {
                for (int j = 1; j <= V; j++) {
                    distance[i][j] = Math.min(distance[i][k] + distance[k][j], distance[i][j]);
                }
            }
        }
    }
}