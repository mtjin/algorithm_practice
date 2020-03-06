import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    private static int[][] map;
    private static boolean[][] visited;
    private static int[] dx = {-1, 0, 1, 0};
    private static int[] dy = {0, -1, 0, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 행
        int M = sc.nextInt(); // 열

        map = new int[M + 2][N + 2];
        visited = new boolean[M + 2][N + 2];

        sc.nextLine();
        for (int i = 1; i < N + 1; i++) {
            String str = sc.nextLine();
            for (int j = 1; j < M + 1; j++) {
                map[j][i] = str.charAt(j - 1) - '0';
            }
        }

        bfs(1, 1);
        System.out.println(map[M][N]);
    }


    private static void bfs(int x, int y) {
        Queue<Point> queue = new LinkedList<Point>();
        queue.offer(new Point(x, y));
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            Point point = queue.poll();
            for (int i = 0; i < 4; i++) {
                int x2 = point.x + dx[i];
                int y2 = point.y + dy[i];
                if (!(map[x2][y2] == 0 || visited[x2][y2] == true)) {
                    visited[x2][y2] = true;
                    queue.offer(new Point(x2, y2));
                    //이전좌표의 값의 + 1을 가짐 (최소거리 누적해서 더해나감)
                    if (i == 0) { //왼쪽으로 이동한 상태
                        map[x2][y2] = map[x2 + 1][y2] + 1;
                    } else if (i == 1) {//상단으로 이동한 상태
                        map[x2][y2] = map[x2][y2 + 1] + 1;
                    } else if (i == 2) {//오른쪽으로 이동한 상태
                        map[x2][y2] = map[x2 - 1][y2] + 1;
                    } else {//밑으로 이동한 상태
                        map[x2][y2] = map[x2][y2 - 1] + 1;
                    }
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
