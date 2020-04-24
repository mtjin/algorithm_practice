import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] num = new int[n + 1][2]; //[][1] : A 전깃줄 번호, [][2] : B 전깃줄 번호
        int[] dp = new int[n + 1]; // 해당 위치까지의 가장 많이 설치할 수 있는 전깃줄 개수
        int maxInstall = 1; //가장 많이 설치할 수 있는 개수

        for (int i = 1; i <= n; i++) {
            num[i][0] = sc.nextInt();
            num[i][1] = sc.nextInt();
        }

        //[][0] 정렬 (A 전봇대 기준으로)
        Arrays.sort(num, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        for (int i = 1; i <= n; i++) {
            dp[i] = 1;
            for (int j = 1; j < i; j++) {
                if (num[j][1] < num[i][1]) { // 과거 A의 전깃줄과 이어진 B 번호보다 현재 B 번호가 더 커야 이을 수 있다.(A보다큰)
                    dp[i] = Math.max(dp[i], dp[j] + 1); // 과거 최대 전깃줄 개수 + 1 세팅
                }
            }
            maxInstall = Math.max(maxInstall, dp[i]); // 최대 전깃줄 개수 세팅
        }
        System.out.println(n - maxInstall); //없애야 하는 전깃줄의 최소 개수 = 전체개수 - 가장많이설치할 수 있는 개수
    }
}