import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    private static char[][] map;
    private static char[][] map2;
    private static boolean[][] isVisited;
    private static boolean[][] isVisited2;
    private static int[] dx = {-1, 0, 1, 0};
    private static int[] dy = {0, -1, 0, 1};
    private static int size;
    private static int answer1 = 0; // 정상인
    private static int answer2 = 0; // 적록색약인

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        size = sc.nextInt();
        map = new char[size + 2][size + 2];
        map2 = new char[size + 2][size + 2];
        isVisited = new boolean[size + 2][size + 2];
        isVisited2 = new boolean[size + 2][size + 2];
        for (int i = 1; i <= size; i++) {
            String line = sc.next();
            for (int j = 1; j <= size; j++) {
                map[i][j] = line.charAt(j - 1);
                map2[i][j] = line.charAt(j - 1);
                if (line.charAt(j - 1) == 'G') {
                    map2[i][j] = 'R';
                }
            }
        }

        for (int i = 1; i <= size; i++) {
            for (int j = 1; j <= size; j++) {
                if (!isVisited[i][j]) {
                    bfs(new Point(i, j));
                    answer1++;
                }
            }
        }

        for (int i = 1; i <= size; i++) {
            for (int j = 1; j <= size; j++) {
                if (!isVisited2[i][j]) {
                    bfs2(new Point(i, j));
                    answer2++;
                }
            }
        }

        System.out.println(answer1 + " " + answer2);
    }

    private static void bfs(Point point) {
        Queue<Point> queue = new LinkedList<>();
        queue.offer(point);
        isVisited[point.x][point.y] = true;
        while (!queue.isEmpty()) {
            Point point2 = queue.poll();
            for (int i = 0; i < 4; i++) {
                int x2 = point2.x + dx[i];
                int y2 = point2.y + dy[i];
                if (map[point2.x][point2.y] == map[x2][y2] && !isVisited[x2][y2]) {
                    queue.offer(new Point(x2, y2));
                    isVisited[x2][y2] = true;
                }
            }
        }
    }

    private static void bfs2(Point point) {
        Queue<Point> queue = new LinkedList<>();
        queue.offer(point);
        isVisited2[point.x][point.y] = true;
        while (!queue.isEmpty()) {
            Point point2 = queue.poll();
            for (int i = 0; i < 4; i++) {
                int x2 = point2.x + dx[i];
                int y2 = point2.y + dy[i];
                if (map2[point2.x][point2.y] == map2[x2][y2] && !isVisited2[x2][y2]) {
                    queue.offer(new Point(x2, y2));
                    isVisited2[x2][y2] = true;
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