import java.util.Scanner;

class Main {
    private static int n; // 유저의 수
    private static int m; // 친구관계의 수
    private static int[] answerNum; // 정답 친구 번호
    private static int[] minDistance; // 친구 최단 경로
    private static int[][] distance; // 최소비용(최단거리)
    private static int INF = 5001;

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
            distance[start][end] = 1;
            distance[end][start] = 1;
        }

        //플로이드 워셜 알고리즘
        floyd();

        //출력
        int[] answer = new int[n + 1];
        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= n; i++) {
            int sum = 0;
            for (int j = 1; j <= n; j++) {
                sum += distance[i][j];
            }
            answer[i] = sum;
            if (sum < min) {
                min = sum;
            }
        }
        for (int i = 1; i <= n; i++) {
            if (answer[i] == min) {
                System.out.println(i);
                return;
            }
        }
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