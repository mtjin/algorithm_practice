import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.TreeSet;

public class Main {

    private static int[][] map;
    private static int[] dx = {-1, 0, 1, 0};
    private static int[] dy = {0, -1, 0, 1};
    private static Queue<Point> queue = new LinkedList<>();
    private static TreeSet<Integer> resultTreeSet = new TreeSet<>();
    private static int N;
    private static int M;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt(); // 열(2차원) 6
        M = sc.nextInt(); // 행(1차원) 4

        map = new int[M + 2][N + 2];

        //맵 세팅
        for (int i = 1; i < M + 1; i++) {
            for (int j = 1; j < N + 1; j++) {
                map[i][j] = sc.nextInt();
                if (map[i][j] == 1) {
                    queue.offer(new Point(i, j));
                }
            }
        }

        //모두 들어있지 않은 칸이거나 0인 경우
        if (queue.isEmpty()) {
            System.out.println(-1);
            return;
        }

        //바깥쪽 멥은 -1로 세팅 (사방히막힌 경우 구하기위해)
        for (int i = 0; i < N + 2; i++) {
            map[0][i] = -1;
            map[M + 1][i] = -1;
        }
        for (int i = 0; i < M + 2; i++) {
            map[i][0] = -1;
            map[i][N + 1] = -1;
        }

        //순차적 탐색
        bfs();

        //결과
        for (int i = 1; i < M + 1; i++) {
            for (int j = 1; j < N + 1; j++) {
                if (map[i][j] == 0) { //익지못한 토마토있는 경우
                    System.out.println(-1);
                    return;
                }
            }
        }
        if (resultTreeSet.isEmpty()) {
            System.out.println(0);
        } else {
            System.out.println(resultTreeSet.last() - 1);
        }

    }


    private static void bfs() {
        while (!queue.isEmpty()) {
            Point point = queue.poll();
            for (int i = 0; i < 4; i++) {
                int x2 = point.x + dx[i];
                int y2 = point.y + dy[i];

                //익지않은 토마토만 탐색
                if (map[x2][y2] == 0) {
                    queue.offer(new Point(x2, y2));
                    if (i == 0) { //왼쪽으로 이동한 상태
                        map[x2][y2] = map[x2 + 1][y2] + 1;
                    } else if (i == 1) {//상단으로 이동한 상태
                        map[x2][y2] = map[x2][y2 + 1] + 1;
                    } else if (i == 2) {//오른쪽으로 이동한 상태
                        map[x2][y2] = map[x2 - 1][y2] + 1;
                    } else {//밑으로 이동한 상태
                        map[x2][y2] = map[x2][y2 - 1] + 1;
                    }
                    resultTreeSet.add(map[x2][y2]);
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

