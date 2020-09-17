import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int M = 0; //배추밭 가로길이
    static int K = 0; //배추가 심어져 있는 위치의 개수
    private static int[][] map;
    private static boolean[][] isVisited;
    private static int N = 0; //배추밭 세로길이
    private static int result = 0; //지렁이개수
    private static int[] dx = {-1, 0, 1, 0};
    private static int[] dy = {0, -1, 0, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 0; t < T; t++) {
            result = 0;
            M = sc.nextInt();
            N = sc.nextInt();
            map = new int[N + 2][M + 2];
            isVisited = new boolean[N + 2][M + 2];
            K = sc.nextInt();
            for (int i = 0; i < K; i++) {
                int y = sc.nextInt() + 1;
                int x = sc.nextInt() + 1;
                map[x][y] = 1;
            }
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= M; j++) {
                    if (!isVisited[i][j] && map[i][j] == 1) {
                        bfs(i, j);
                        result++;
                    }
                }
            }
            System.out.println(result);
        }
    }

    static void bfs(int x, int y) {
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(x, y));
        isVisited[x][y] = true;
        while (!queue.isEmpty()) {
            Point point = queue.poll();
            for (int i = 0; i < 4; i++) {
                int x2 = point.x + dx[i];
                int y2 = point.y + dy[i];
                if (map[x2][y2] == 1 && !isVisited[x2][y2]) {
                    isVisited[x2][y2] = true;
                    queue.offer(new Point(x2, y2));
                }
            }
        }
    }

    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

}
