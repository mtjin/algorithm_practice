import java.util.Scanner;

class Main {
    private static int N; // N개의 물건
    private static int M; // 미리 측정된 물건쌍의 개수
    private static int[][] weights;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        weights = new int[N + 1][N + 1];
        // 무게 대소관계 정리
        for (int i = 1; i <= M; i++) {
            int start = sc.nextInt(); // 더 무거운 물건
            int end = sc.nextInt(); // 더 가벼운 물건
            weights[start][end] = 1; // 처음물건이 두번쨰물건모다 무겁다. 처음께(1차원배열) 두번째(2차원배열)보다 무거우면 1 세팅
            weights[end][start] = -1; // 반대의 경우는 -1 세팅
            // 대소관계모르는 경우 0
        }
        floyd();
        for (int i = 1; i <= N; i++) {
            int cnt = N - 1; //자기자신 제외
            for (int j = 1; j <= N; j++) {
                if (weights[i][j] != 0) { //대소관계 모르는 경우
                    cnt--;
                }
            }
            System.out.println(cnt);
        }
    }

    private static void floyd() {
        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (weights[i][k] == weights[k][j] && weights[i][k] != 0) { //서로 비교할 수 있는 경우
                        weights[i][j] = weights[i][k]; // i>k>j OR i<k<j 이므로 i,k 의 대소관계도 알 수 있게된다.
                    }
                }
            }
        }
    }
}