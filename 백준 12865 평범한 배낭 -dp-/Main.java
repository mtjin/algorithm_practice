import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); //물품의수
        int K = sc.nextInt(); //준서가 버틸수 있는 무게
        int[][] dp = new int[N + 1][K + 1]; //[물품인덱스][무게] = 최대가치
        int[] w = new int[N + 1]; //무게
        int[] v = new int[N + 1]; //가치
        for (int i = 1; i <= N; i++) {
            w[i] = sc.nextInt();
            v[i] = sc.nextInt();
        }

        for (int i = 1; i <= N; i++) { //아이템 순
            for (int j = 1; j <= K; j++) { //버틸수있는 무게(j)
                dp[i][j] = dp[i - 1][j];
                if (j - w[i] >= 0) { //들어갈 수 있는 무게인 경우
                    //이전아이템까지의 최대가치 vs 현재아이템의 최대 가치 + 현재아이템의 남은 무게에서의 최대가치
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - w[i]] + v[i]);
                }
            }
        }
        System.out.println(dp[N][K]);

    }
}