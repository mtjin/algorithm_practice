import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Main {
    private static int[] dr = {-1, -1, -1, 0, 1, 1, 1, 0};
    private static int[] dc = {-1, 0, 1, 1, 1, 0, -1, -1};
    private static int w; //너비
    private static int h; //높이
    private static int[][] map;
    private static boolean[][] isVisited;
    private static int answer = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        w = sc.nextInt();
        h = sc.nextInt();
        while (w != 0 && h != 0) {
            answer = 0;
            map = new int[h][w];
            isVisited = new boolean[h][w];
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    map[i][j] = sc.nextInt();
                }
            }
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (!isVisited[i][j] && map[i][j] == 1) {
                        bfs(i, j);
                    }
                }
            }
            System.out.println(answer);
            w = sc.nextInt();
            h = sc.nextInt();
        }
    }

    private static void bfs(int r, int c) {
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(r, c));
        isVisited[r][c] = true;
        while (!queue.isEmpty()) {
            Point point = queue.poll();
            r = point.r;
            c = point.c;
            for (int i = 0; i < 8; i++) {
                int r2 = point.r + dr[i];
                int c2 = point.c + dc[i];
                if (r2 >= 0 && r2 < h && c2 >= 0 && c2 < w && !isVisited[r2][c2] && map[r2][c2] == 1) {
                    isVisited[r2][c2] = true;
                    queue.offer(new Point(r2, c2));
                }
            }
        }
        answer++;
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