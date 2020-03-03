import java.util.*;

public class Main {

    private static int[][] map;
    private static boolean[][] visited;
    private static int[] dx = {-1, 0, 1, 0};
    private static int[] dy = {0, -1, 0, 1};
    private static ArrayList<Integer> result = new ArrayList<Integer>();
    private static int totalNumOfHouse = 0; //전체 방의 개수

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        // index 에러 안나게 배열 생성
        map = new int[size + 2][size + 2];
        visited = new boolean[size + 2][size + 2];
        sc.nextLine();

        //배열 초기화
        for (int i = 1; i < size + 1; i++) {
            String str = sc.nextLine();
            for (int j = 1; j < size + 1; j++) {
                map[i][j] = str.charAt(j - 1) - '0';
            }
        }

        //모든 배열 인덱스 시작점으로 탐색
        for (int i = 1; i < size + 1; i++) {
            for (int j = 1; j < size + 1; j++) {
                if (map[i][j] == 1 && visited[i][j] == false) {
                    bfs(i, j);
                }
            }
        }

        System.out.println(totalNumOfHouse);
        Collections.sort(result);
        for (int num : result) {
            System.out.println(num);
        }

    }

    private static void bfs(int x, int y) {
        int numOfHouse = 0;
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(x, y));
        visited[x][y] = true;
        totalNumOfHouse++;
        numOfHouse++;
        while (!queue.isEmpty()) {
            Point point = queue.poll();
            //동서남북 탐색
            for (int i = 0; i < 4; i++) {
                int x2 = point.x + dx[i];
                int y2 = point.y + dy[i];
                if (!(map[x2][y2] == 0 || visited[x2][y2] == true)) {
                    visited[x2][y2] = true;
                    numOfHouse++;
                    queue.offer(new Point(x2, y2));
                }
            }
        }
        result.add(numOfHouse);
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

