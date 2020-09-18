import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.TreeSet;

/*
*
* 6 4
0 0 0 0 0 0
0 0 0 0 0 0
0 0 0 0 0 0
0 0 0 0 0 1
*/
public class Main {

    private static int N; //1차원
    private static int M; //2차원
    private static int[][] map;
    private static int[] dx = {-1, 0, 1, 0};
    private static int[] dy = {0, -1, 0, 1};
    private static TreeSet<Integer> resultTreeSet = new TreeSet();
    private static Queue<Point> queue = new LinkedList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        M = sc.nextInt();
        N = sc.nextInt();
        map = new int[N + 2][M + 2];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                map[i][j] = sc.nextInt();
                if (map[i][j] == 1) {
                    queue.offer(new Point(i, j));
                }
            }
        }
        for (int i = 0; i < N + 2; i++) {
            map[i][0] = -1;
            map[i][M + 1] = -1;
        }
        //바깥쪽 -1세팅
        for (int i = 0; i < M + 2; i++) {
            map[0][i] = -1;
            map[N + 1][i] = -1;
        }
        //탐색
        bfs();
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                if (map[i][j] == 0) { //익지 못하는 상황
                    System.out.println(-1);
                    return;
                }
            }
        }
        if (resultTreeSet.isEmpty()) { // 모드 토마토가 익어있는 상태
            System.out.println(0);
        } else {
            System.out.println(resultTreeSet.pollLast() - 1);
        }
    }

    static void bfs() {
        while (!queue.isEmpty()) {
            Point point = queue.poll();
            for (int i = 0; i < 4; i++) {
                int x2 = point.x + dx[i];
                int y2 = point.y + dy[i];
                if (map[x2][y2] == 0) {
                    map[x2][y2] = map[point.x][point.y] + 1;
                    resultTreeSet.add(map[x2][y2]);
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