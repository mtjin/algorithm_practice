import java.util.Scanner;

class Main {
    private static int n; // n개의 도시
    private static int m; //m개의 버스
    private static int[][] distance; // 최소비용
    private static int INF = 1000000000; //Integer.MAX_VALUE 로 하면 안된다. 나중에 더해줘야하는데 그럼 수가 초과해서 마이너스가된다. (주의)

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        distance = new int[n + 1][n + 1];

        //초기화
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == j) distance[i][j] = 0;
                else distance[i][j] = INF;
            }
        }
        for (int i = 0; i < m; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            int weight = sc.nextInt();
            distance[start][end] = Math.min(distance[start][end], weight);
        }

        //플로이드 워셜 알고리즘
        floyd();

        //출력
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (distance[i][j] >= INF) {
                    sb.append("0 ");
                } else {
                    sb.append(distance[i][j] + " ");
                }
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }

    private static void floyd() {
        for (int k = 1; k <= n; k++) { //거쳐가는 중간 지점 노드
            for (int i = 1; i <= n; i++) { //시작 노드
                for (int j = 1; j <= n; j++) { //도착 노드
                    distance[i][j] = Math.min(distance[i][k] + distance[k][j], distance[i][j]); //최단경로 초기화
                }
            }
        }
    }
}