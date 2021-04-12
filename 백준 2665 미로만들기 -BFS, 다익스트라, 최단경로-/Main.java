import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    private static int N;
    private static int[][] map; // 맵
    private static int[][] distances; // 해당 좌표까지 오는데 바꾼 방 색 개수
    private static int[] dr = {-1, 0, 1, 0};
    private static int[] dc = {0, -1, 0, 1};
    private static int INF = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        map = new int[N][N];
        distances = new int[N][N];
        for (int i = 0; i < N; i++) {
            String str = sc.next();
            for (int j = 0; j < str.length(); j++) {
                map[i][j] = str.charAt(j) - '0';
                distances[i][j] = INF;
            }
        }
        System.out.println(bfs());
    }

    private static int bfs() {
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(0, 0));
        distances[0][0] = 0;
        while (!queue.isEmpty()) {
            Point point = queue.poll();
            int r = point.r;
            int c = point.c;
            for (int i = 0; i < 4; i++) {
                int r2 = r + dr[i];
                int c2 = c + dc[i];
                // 이동할 좌표 갱신 X , 더 작은값으로 갱신 가능한 경우
                if (r2 >= 0 && c2 >= 0 && r2 < N && c2 < N && (distances[r2][c2] > distances[r][c])) {
                    if (map[r2][c2] == 1) { // 이동가능경로
                        distances[r2][c2] = distances[r][c];
                        queue.add(new Point(r2, c2));
                    } else { // 벽
                        distances[r2][c2] = distances[r][c] + 1;
                        queue.add(new Point(r2, c2));
                    }
                }
            }
        }
        return distances[N - 1][N - 1];
    }

    static class Point {
        int r;
        int c;

        Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}