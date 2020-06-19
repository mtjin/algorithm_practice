import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] coin = new int[n];
        int[] dp = new int[k + 1]; // dp[해당가격] = 의 가치를 만들 수 있는 경우의 수
        for (int i = 0; i < n; i++) {
            coin[i] = sc.nextInt();
        }
        dp[0] = 1;
        for (int i = 0; i < n; i++) { //코인 종류별로 차례대로 불러옴
            int currentCoin = coin[i];
            for (int j = currentCoin; j <= k; j++) { //현재코인가격(currentCoin) ~ K 까지 dp 축적해나감
                dp[j] += dp[j -currentCoin]; // currentCoin 이 2라면  dp[2] 일때 dp[0] 축적, dp[3] 일때 dp[1], dp[4]일때 dp[2] 축적 ...(해당 동전의 모든 경우의 수 축적)
            }
        }
        System.out.println(dp[k]);
    }
}