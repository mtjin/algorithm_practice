import java.util.Scanner;

class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] dp = new int[3][n + 1]; // n 번째까지의 최대 부분수열 길이
        int answer = 0;
        for (int i = 1; i <= n; i++) {
            dp[0][i] = sc.nextInt();
        }

        // 왼쪽에서 오른쪽에 증가 부분수열 dp
        for (int i = 1; i <= n; i++) {
            int increaseCnt = 0;
            for (int j = 1; j <= i; j++) {
                if (increaseCnt < dp[1][j] && dp[0][i] > dp[0][j]) { // 과거(이전값들) 중 최대 부분수열 길이를 최우선으로하고, 그 때의 값보다 커야하는걸 만족해야함
                    increaseCnt = dp[1][j];
                }
            }
            dp[1][i] = increaseCnt + 1;
        }

        // 오른쪽에서 왼쪽으로 증가 부분수열 dp
        for (int i = n; i >= 1; i--) {
            int decreaseCnt = 0;
            for (int j = n; j >= i; j--) {
                if (decreaseCnt < dp[2][j] && dp[0][i] > dp[0][j]) { //오른쪽에서 왼쪾으로 갈수록 더커져야함 (위와 순서뺴고 동일)
                    decreaseCnt = dp[2][j];
                }
            }
            dp[2][i] = decreaseCnt + 1;
        }

        // 서로 개수 한개가 겹치므로 -1
        for (int i = 1; i <= n; i++) {
            answer = Math.max(answer, dp[1][i] + dp[2][i] - 1);
        }
        System.out.println(answer);
    }
}