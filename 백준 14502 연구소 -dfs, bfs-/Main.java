import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    private static int[][] map;
    private static int[] dx = {-1, 0, 1, 0};
    private static int[] dy = {0, -1, 0, 1};
    private static int N;
    private static int M;
    private static ArrayList<Virus> virusList = new ArrayList<>();
    private static int answer = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        map = new int[N + 2][M + 2];
        for (int i = 0; i < map.length; i++) {
            map[i][0] = 1;
            map[i][M + 1] = 1;
        }
        for (int j = 0; j < map[0].length; j++) {
            map[0][j] = 1;
            map[N + 1][j] = 1;
        }
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                map[i][j] = sc.nextInt();
                if (map[i][j] == 2) {
                    virusList.add(new Virus(i, j));
                }
            }
        }
        dfs(0);
        System.out.println(answer);
    }

    private static void dfs(int count) {
        if (count == 3) {
            //  int[][] tmpMap = map.clone();  deep copy 안됨
            int[][] tmpMap = new int[N + 2][M + 2];
            for (int i = 0; i <= N + 1; i++) {
                for (int j = 0; j <= M + 1; j++) {
                    tmpMap[i][j] = map[i][j];
                }
            }
            for (Virus virus : virusList) {
                spreadVirus(virus, tmpMap);
            }
            countSafeArea(tmpMap);
            return;
        }
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                if (map[i][j] == 0) {
                    map[i][j] = 1;
                    dfs(count + 1);
                    map[i][j] = 0;
                }
            }
        }
    }

    private static void spreadVirus(Virus virus, int[][] map) {
        Queue<Virus> queue = new LinkedList<>();
        queue.offer(virus);
        while (!queue.isEmpty()) {
            Virus virus2 = queue.poll();
            for (int i = 0; i < 4; i++) {
                int x2 = virus2.x + dx[i];
                int y2 = virus2.y + dy[i];
                if (map[x2][y2] == 0) {
                    map[x2][y2] = 2;
                    queue.offer(new Virus(x2, y2));
                }
            }
        }
    }

    private static void countSafeArea(int[][] map) {
        int count = 0;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                if (map[i][j] == 0) {
                    count++;
                }
            }
        }
        answer = Math.max(answer, count);
    }

    private static class Virus {
        int x;
        int y;

        public Virus(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}