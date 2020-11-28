import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Main {
    private static int[][] map;
    private static boolean[][] isVisited;
    private static int N;
    private static int sRow;
    private static int sCol;
    private static int answer = 0;
    private static int sharkSize = 2;
    private static int eatSize = 0;
    private static int[] dr = {-1, 0, 0, 1};
    private static int[] dc = {0, -1, 1, 0}; //가장 위-> 가장 왼쪽으로 우선 순위

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        map = new int[N][N];
        isVisited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = sc.nextInt();
                if (map[i][j] == 9) {
                    sRow = i;
                    sCol = j;
                }
            }
        }
        while (true) {
            if (!bfs(sRow, sCol)) break;
        }
        System.out.println(answer);

    }

    private static boolean bfs(int r, int c) {
        isVisited = new boolean[N][N];
        isVisited[r][c] = true;
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(r, c, 0));
        ArrayList<Point> eatList = new ArrayList<>(); //잡아먹을 수 있는 물고기 리스트
        int tmpMove = 401; //이동거리( 물고기 먹은 경우의 이동경로 이후로 탐색을 그만하기 위한 flag)
        while (!queue.isEmpty()) {
            Point point = queue.poll();
            for (int i = 0; i < 4; i++) {
                int r2 = point.r + dr[i];
                int c2 = point.c + dc[i];
                if (r2 >= 0 && r2 < N && c2 >= 0 && c2 < N && !isVisited[r2][c2] && tmpMove > point.move && sharkSize >= map[r2][c2]) {//크기가 같거나 작은거만 지나갈 수 있다.
                    isVisited[r2][c2] = true;
                    if (map[r2][c2] < sharkSize && map[r2][c2] != 0) { //아기상어가 먹을 수 있는 물고기
                        eatList.add(new Point(r2, c2, point.move + 1));
                        tmpMove = point.move + 1;
                        break;
                    } else { //계속 탐색이동
                        queue.offer(new Point(r2, c2, point.move + 1));
                    }
                }
            }
        }

        //잡아먹은 물고기가 있다면 우선순위인 놈 잡아먹음(가장 상단인 놈 다음엔 왼쪽 기준)
        eatList.sort((o1, o2) -> {
            if (o1.r == o2.r) {
                return o1.c - o2.c;
            } else {
                return o1.r - o2.r;
            }
        });
        if (!eatList.isEmpty()) {
            int r2 = eatList.get(0).r;
            int c2 = eatList.get(0).c;
            eatSize++; //먹은개수 + 1
            answer += (eatList.get(0).move);
            map[r][c] = 0; //처음 자기위치 리셋
            map[r2][c2] = 0; //먹은 물고기 처리
            if (eatSize == sharkSize) { //레벨업 체크
                sharkSize++;
                eatSize = 0;
            }
            sRow = r2;
            sCol = c2;
            return true;
        }
        return false;
    }

    private static class Point {
        int r;
        int c;
        int move;

        Point(int r, int c, int move) {
            this.r = r;
            this.c = c;
            this.move = move;
        }
    }


}