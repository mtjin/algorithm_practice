import java.util.*;

public class Main {
    static int[][] map;
    static boolean[][] isVisited;
    static int N = 0; //정사각형 크기
    static int totalNumOfHouse = 0;
    static ArrayList<Integer> result = new ArrayList();
    private static int[] dx = {-1, 0, 1, 0};
    private static int[] dy = {0, -1, 0, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        map = new int[N + 2][N + 2];
        isVisited = new boolean[N + 2][N + 2];
        for (int i = 1; i <= N; i++) {
            String line = sc.next();
            for (int j = 1; j <= N; j++) {
                map[i][j] = line.charAt(j-1) - '0';
            }
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (!isVisited[i][j] && map[i][j] == 1)
                    bfs(i, j);
            }
        }
        System.out.println(totalNumOfHouse);
        Collections.sort(result);
        for (int i : result) {
            System.out.println(i);
        }
    }

    static void bfs(int x, int y) {
        int size = 1;
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(x, y));
        isVisited[x][y] = true;
        totalNumOfHouse++;
        while (!queue.isEmpty()) {
            Point point = queue.poll();
            for (int i = 0; i < 4; i++) {
                int x2 = point.x + dx[i];
                int y2 = point.y + dy[i];
                if (map[x2][y2] == 1 && !isVisited[x2][y2]) {
                    isVisited[x2][y2] = true;
                    size++;
                    queue.offer(new Point(x2, y2));
                }
            }
        }
        result.add(size);
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
