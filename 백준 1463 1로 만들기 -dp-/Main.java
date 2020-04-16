import java.util.Scanner;

class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] dp = new int[N + 1]; // 인덱스 : 숫자, 값 : 최솟값
        dp[0] = 0;
        dp[1] = 0;
        for (int i = 2; i <= N; i++) {
            dp[i] = dp[i - 1] + 1; // 1을 빼는 경우(항상 최악의 경우)
            if (i % 3 == 0) { //현재 최솟값과 3로 나눴었을 때의 과거최솟값과 비교(과거값이니 +1 해줌)
                dp[i] = Math.min(dp[i], dp[i / 3] + 1);
            }
            if (i % 2 == 0) {
                dp[i] = Math.min(dp[i], dp[i / 2] + 1);
            }
        }
        System.out.println(dp[N]);
    }
}