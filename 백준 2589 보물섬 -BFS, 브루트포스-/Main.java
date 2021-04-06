import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Main {
    private static int R; // 행
    private static int C; // 열
    private static int[] dr = new int[]{-1, 0, 1, 0};
    private static int[] dc = new int[]{0, -1, 0, 1};
    private static int[][] map; // 맵
    private static boolean[][] isVisited; // 방문여부
    private static int answer = -1;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        R = sc.nextInt();
        C = sc.nextInt();
        map = new int[R][C];
        for (int i = 0; i < R; i++) {
            String str = sc.next();
            for (int j = 0; j < str.length(); j++) {
                map[i][j] = str.charAt(j);
            }
        }
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                isVisited = new boolean[R][C];
                if (map[i][j] == 'L') {
                    bfs(i, j);
                }
            }
        }
        System.out.println(answer);
    }

    private static void bfs(int r, int c) {
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(r, c, 0));
        isVisited[r][c] = true;
        while (!queue.isEmpty()) {
            Point point = queue.poll();
            for (int i = 0; i < 4; i++) {
                int r2 = point.r + dr[i];
                int c2 = point.c + dc[i];
                if (0 <= r2 && r2 < R && 0 <= c2 && c2 < C && map[r2][c2] == 'L' && !isVisited[r2][c2]) {
                    isVisited[r2][c2] = true;
                    queue.offer(new Point(r2, c2, point.cnt + 1));
                    answer = Math.max(answer, point.cnt + 1);
                }
            }
        }
    }

    private static class Point {
        int r;
        int c;
        int cnt; // 걸린시간

        public Point(int r, int c, int cnt) {
            this.r = r;
            this.c = c;
            this.cnt = cnt;
        }
    }
}