import java.util.LinkedList;
import java.util.Queue;

class Solution {
    private static int[] dr = {0,1,1}; // 아래, 오른쪽밑대각선, 오른쪽
    private static int[] dc = {1, 0, 1};
    private static boolean[][] isVisited;
    private static int answer = 0;

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solution(new int[][]{{0, 0, 1, 1}, {1, 1, 1, 1}});
    }

    private static void bfs(int r, int c, int[][] board) {
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(r, c, 1));
        isVisited[r][c] = true;
        while (!queue.isEmpty()) {
            Point point = queue.poll();
            for (int i = 0; i < 3; i++) {
                int r2 = point.r + dr[i];
                int c2 = point.c + dc[i];
                if (r2 >= 0 && r2 < board.length && c2 >= 0 && c2 < board[0].length) {
                    if(!isVisited[r2][c2]) {
                        if (board[r2][c2] == 0) {
                            answer = Math.max(answer, point.cnt);
                            return;
                        }
                        isVisited[r2][c2] = true;
                        queue.offer(new Point(r2, c2, point.cnt + 1));
                    }
                }else { //벽만남
                    answer = Math.max(answer, point.cnt);
                    return;
                }
            }
            if (queue.isEmpty()) { // 마지막값예외처리 (케이스 2번같이 길에막혀 탐색다한 경우)
                answer = Math.max(answer, point.cnt - 1);
            }
        }
    }

    public int solution(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                isVisited = new boolean[board.length][board[0].length];
                if (board[i][j] == 1) {
                    answer = Math.max(answer, 1);
                    bfs(i, j, board);
                }
            }
        }
        System.out.println(answer * answer);
        return answer * answer;
    }

    static class Point {
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