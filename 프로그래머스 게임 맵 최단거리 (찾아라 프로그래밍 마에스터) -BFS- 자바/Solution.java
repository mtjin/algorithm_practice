import java.util.LinkedList;
import java.util.Queue;

class Solution {
    private static boolean[][] isVisited;
    private static int[] dr = new int[]{-1, 0, 1, 0};
    private static int[] dc = new int[]{0, -1, 0, 1};
    private static int answer = Integer.MAX_VALUE;

    private static void bfs(int[][] maps) {
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(0, 0, 0));
        while (!queue.isEmpty()) {
            Point point = queue.poll();
            if (point.r== maps.length-1 && point.c == maps[0].length-1) { //도착지점
                answer = Math.min(answer, point.cnt+1);
                return;
            }
            for (int i = 0; i < 4; i++) {
                int r2 = point.r + dr[i];
                int c2 = point.c + dc[i];
                if (r2 >= 0 && r2 < maps.length && c2 >= 0 && c2 < maps[0].length && maps[r2][c2] == 1 && !isVisited[r2][c2]) {
                    queue.add(new Point(r2, c2, point.cnt + 1));
                    isVisited[r2][c2] = true;
                }
            }
        }
    }

    public int solution(int[][] maps) { // 0:벽, 1:길
        isVisited = new boolean[maps.length][maps[0].length];
        bfs(maps);
        if(answer == Integer.MAX_VALUE) answer = -1;
        return answer;
    }

    private static class Point {
        int r;
        int c;
        int cnt;

        Point(int r, int c, int cnt) {
            this.r = r;
            this.c = c;
            this.cnt = cnt;
        }
    }
}