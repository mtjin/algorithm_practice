import java.util.Scanner;

class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] dp = new int[n + 1]; // n번째 마신 경우의 최대양
        int[] wine = new int[n + 1]; // n번째 와인 양
        // 포도주 초기화
        for (int i = 1; i <= n; i++) {
            wine[i] = sc.nextInt();
        }
        // 첫잔, 두번째 잔 초기화
        dp[1] = wine[1];
        if (n > 1) { // 한잔일 때 예외처리
            dp[2] = wine[1] + wine[2];
        }
        //0잔마실떄, 한잔마실떄 , 두잔연속마실떄,
        for (int i = 3; i < dp.length; i++) {
            dp[i] = Math.max(dp[i - 1], Math.max(dp[i - 2] + wine[i], dp[i - 3] + wine[i - 1] + wine[i]));
        }
        System.out.println(dp[n]);
    }
}