import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.TreeSet;

public class Main {

    private static int N; //1차원
    private static int M; //2차원
    private static int H; //3차원
    private static int[][][] map;
    private static int[] dx = {-1, 0, 1, 0, 0, 0};
    private static int[] dy = {0, -1, 0, 1, 0, 0};
    private static int[] dz = {0, 0, 0, 0, -1, 1};
    private static TreeSet<Integer> resultTreeSet = new TreeSet();
    private static Queue<Point> queue = new LinkedList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        M = sc.nextInt();
        N = sc.nextInt();
        H = sc.nextInt();
        map = new int[N + 2][M + 2][H + 2];
        //바깥쪽 세팅을 위한 for 문 (테두리가 아닌 값도 세팅해서 시간오버플로우가 생기긴함)
        for (int i = 0; i < N + 2; i++) {
            for (int j = 0; j < M + 2; j++) {
                for (int k = 0; k < H + 2; k++) {
                    map[i][j][k] = -1;
                }
            }
        }
        for (int k = 1; k <= H; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= M; j++) {
                    map[i][j][k] = sc.nextInt();
                    if (map[i][j][k] == 1) {
                        queue.offer(new Point(i, j, k));
                    }

                }
            }
        }

        //탐색
        bfs();
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                for (int k = 1; k <= H; k++) {
                    if (map[i][j][k] == 0) { //익지 못하는 상황
                        System.out.println(-1);
                        return;
                    }
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
            for (int i = 0; i < 6; i++) {
                int x2 = point.x + dx[i];
                int y2 = point.y + dy[i];
                int z2 = point.z + dz[i];
                if (map[x2][y2][z2] == 0) {
                    map[x2][y2][z2] = map[point.x][point.y][point.z] + 1;
                    resultTreeSet.add(map[x2][y2][z2]);
                    queue.offer(new Point(x2, y2, z2));
                }
            }
        }
    }

    static class Point {
        int x;
        int y;
        int z;

        public Point(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }


}
