import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    private static int[] dx = {0, 0, -1, 1};
    private static int[] dy = {-1, 1, 0, 0};
    private static int N; //수빈이 위치
    private static int M; //동생 위치
    private static int[][] map;
    private static boolean[][][] isVisited; //x,y, (0:안부심,1:부심)

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        map = new int[N + 2][M + 2];
        isVisited = new boolean[N + 2][M + 2][2];
        for (int i = 1; i <= N; i++) {
            String line = sc.next();
            for (int j = 0; j < M; j++) {
                map[i][j + 1] = line.charAt(j) - '0';
            }
        }
        //바깥쪽 멥은 -1로 세팅 (사방히막힌 경우 구하기위해)
        for (int i = 0; i < M + 2; i++) { //왼쪽,오른쪽벽
            map[0][i] = -1;
            map[N + 1][i] = -1;
        }
        for (int i = 0; i < N + 2; i++) {
            map[i][0] = -1;
            map[i][M + 1] = -1;
        }
        bfs(1, 1);
    }

    private static void bfs(int x, int y) {
        Queue<Point> queue = new LinkedList<>();
        //초깃값도 이동경로개수 포함
        queue.offer(new Point(x, y, 0, 1));
        isVisited[x][y][0] = true;
        isVisited[x][y][1] = true;

        while (!queue.isEmpty()) {
            Point point = queue.poll();
            if (point.x == N && point.y == M) {
                System.out.println(point.distance);
                return;
            }
            for (int i = 0; i < 4; i++) {
                int x2 = point.x + dx[i];
                int y2 = point.y + dy[i];
                int destroyCnt = point.destroyCnt;
                int distance = point.distance;
                if (map[x2][y2] == 1) { //이동할 곳이 벽인 경우
                    if (destroyCnt == 0 && !isVisited[x2][y2][1]) { //벽부순적이없고 방문한적이 없던 곳
                        isVisited[x2][y2][1] = true;
                        queue.offer(new Point(x2, y2, destroyCnt + 1, distance + 1));
                    }
                } else if (map[x2][y2] != -1) { // 이동할 곳이 벽이 아닌 경우( + 쓰레기외부값아닌경우)
                    if (!isVisited[x2][y2][destroyCnt]) { //해당 벽을 방문하지 않은 경우
                        isVisited[x2][y2][destroyCnt] = true;
                        queue.offer(new Point(x2, y2, point.destroyCnt, distance + 1));
                    }
                }
            }
        }
        System.out.println(-1);
    }

    static class Point {
        int x;
        int y;
        int destroyCnt; //부순 벽개수
        int distance; // 이동한 개수

        public Point(int x, int y, int destroyCnt, int distance) {
            this.x = x;
            this.y = y;
            this.destroyCnt = destroyCnt;
            this.distance = distance;
        }
    }


}