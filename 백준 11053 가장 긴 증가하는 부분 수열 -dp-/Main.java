import java.util.Scanner;

class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] dp = new int[n + 1]; // n 번째까지의 최대 부분수열 길이
        int[] num = new int[n + 1]; // n 번째의 숫자
        int answer = 0;
        for (int i = 1; i <= n; i++) {
            num[i] = sc.nextInt();
        }

        dp[1] = 1;
        if (n < 2) { // 한개일 때 예외처리
            System.out.println(dp[1]);
            return;
        }

        for (int i = 2; i <= n; i++) {
            int max = 0;
            for (int j = 1; j < i; j++) {
                if (max < dp[j] && num[i] > num[j]) { // 과거(이전값들) 중 최대 부분수열 길이를 최우선으로하고, 그 때의 값보다 커야하는걸 만족해야함
                    max = dp[j];
                }
            }
            dp[i] = max + 1;
            answer = Math.max(answer, dp[i]); // 가장 큰 값 세팅
        }
        System.out.println(answer);
    }
}