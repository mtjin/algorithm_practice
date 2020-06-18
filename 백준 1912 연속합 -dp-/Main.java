import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] dp = new int[N];
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        dp[0] = arr[0];
        int max = arr[0];

        for (int i = 1; i < N; i++) {
            int n = dp[i - 1] + arr[i];
            dp[i] = Math.max(n, arr[i]);
            max = Math.max(dp[i], max);
        }
        System.out.println(max);
    }
}