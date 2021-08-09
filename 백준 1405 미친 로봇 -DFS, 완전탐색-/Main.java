import java.util.Scanner;

class Main {
    private static int N; // 로봇 움직일 횟수
    private static double[] directions = new double[4]; // 각 방향의 이동확률 (동서남북순)
    private static int[] dr = {1, -1, 0, 0}; // 동서남북순으로 directions 와 맞춰준다. 안그럼 틀림
    private static int[] dc = {0, 0, 1, -1};
    private static boolean[][] isVisited = new boolean[100][100];
    private static double answer = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        for (int i = 0; i < 4; i++) { // 각 방향 이동 확률 초기화  (이동할 확률을 모두 더하면 100이다.)
            directions[i] = 0.01 * sc.nextInt();
        }
        isVisited[50][50] = true;
        dfs(50, 50, 1.0);
        System.out.println(answer);
    }

    private static void dfs(int r, int c, double p) {
        if (N == 0) { // 다움직임
            answer += p; // 로빗의 이동경로 단순할 확률업
            return;
        }
        for (int i = 0; i < 4; i++) {
            int r2 = r + dr[i];
            int c2 = c + dc[i];
            if (!isVisited[r2][c2] && directions[i] > 0) { // 0인 이동확률도 제외해줘야함
                N--;
                isVisited[r2][c2] = true;
                dfs(r2, c2, p * directions[i]);  // 이동 , 확률 더해줌
                N++;
                isVisited[r2][c2] = false;
            }
        }
    }

}