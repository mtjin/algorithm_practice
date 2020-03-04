import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    private static int[][] map;
    private static boolean[][] visited;
    private static int[] dx = {-1, 0, 1, 0};
    private static int[] dy = {0, -1, 0, 1};
    private static int snakeCountResult = 0; //전체 방의 개수

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCaseCount = sc.nextInt();
        for (int i = 0; i < testCaseCount; i++) {
            int M = sc.nextInt(); // 가로길이
            int N = sc.nextInt(); // 세로길이
            int K = sc.nextInt(); //배추 개수
            // index 에러 안나게 배열 생성
            map = new int[N + 2][M + 2];
            visited = new boolean[N + 2][M + 2];
            //배열값 세팅
            for (int k = 0; k < K; k++) {
                int Y = sc.nextInt() + 1;
                int X = sc.nextInt() + 1;
                map[X][Y] = 1;
            }

            //순차적 탐색
            snakeCountResult = 0;
            for (int n = 1; n < N + 1; n++) {
                for (int m = 1; m < M + 1; m++) {
                    if (map[n][m] == 1 && visited[n][m] == false) {
                        bfs(n, m);
                    }
                }
            }
            System.out.println(snakeCountResult);
        }
    }

    private static void bfs(int x, int y) {
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(x, y));
        visited[x][y] = true;
        snakeCountResult++;
        while (!queue.isEmpty()) {
            Point point = queue.poll();
            //동서남북 탐색
            for (int i = 0; i < 4; i++) {
                int x2 = point.x + dx[i];
                int y2 = point.y + dy[i];
                if (!(map[x2][y2] == 0 || visited[x2][y2] == true)) {
                    visited[x2][y2] = true;
                    queue.offer(new Point(x2, y2));
                }
            }
        }
    }

    static class Point {
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}

