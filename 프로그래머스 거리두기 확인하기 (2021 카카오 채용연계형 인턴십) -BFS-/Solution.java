import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    private int[] answer;
    private char[][] map = new char[5][5];
    private boolean[][] isVisited = new boolean[5][5];
    private int[] dr = {-1, 0, 1, 0};
    private int[] dc = {0, -1, 0, 1};

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solution(new String[][]{{"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"}, {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"}, {
                "PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"}, {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"}, {
                "PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}});
    }

    public int[] solution(String[][] places) {
        answer = new int[places.length];
        Arrays.fill(answer, 1); // 1로 초기화
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                String str = places[i][j];
                for (int k = 0; k < str.length(); k++) {
                    map[j][k] = str.charAt(k);
                }
            }
            for (int r = 0; r < 5; r++) {
                boolean flag = true; // 거리두기 지켰는지
                for (int c = 0; c < 5; c++) {
                    // 초기화
                    isVisited = new boolean[5][5];
                    if (map[r][c] != 'X') { //벽아닌곳
                        if (!bfs(r, c, i)) { // 방 거리두기 잘 지키는지 탐색
                            flag = false;
                            break; // 거리두기 안지킴 -> 탐색중지
                        }
                    }
                }
                if (!flag) break; // 거리두기 안지킴 -> 탐색중지
            }
        }
        for (int i = 0; i < 5; i++) { // 정답 세팅
            System.out.println(answer[i]);
        }
        return answer;
    }

    private boolean bfs(int r, int c, int index) {
        Queue<Point> queue = new LinkedList<>();
        if (isPerson(r, c)) {
            queue.offer(new Point(r, c, 2));
        } else {
            queue.offer(new Point(r, c, 0));
        }
        isVisited[r][c] = true;
        while (!queue.isEmpty()) {
            Point point = queue.poll();
            for (int i = 0; i < 4; i++) {
                int r2 = point.r + dr[i];
                int c2 = point.c + dc[i];
                if ((r2 >= 0 && r2 < 5 && c2 >= 0 && c2 < 5) && !isVisited[r2][c2] && map[r2][c2] != 'X') { //방문안하고 벽아닌곳
                    // 거리두기 여부 체크
                    if (isPerson(r2, c2) && point.cnt > 0) {
                        answer[index] = 0; // 거리두기 실패
                        return false; // 거리두기 실패
                    }
                    // BFS 탐색 추가
                    if (isPerson(r2, c2)) { // 사람있는 곳
                        queue.offer(new Point(r2, c2, 2));
                    } else { // 사람없는 곳
                        queue.offer(new Point(r2, c2, point.cnt - 1));
                    }
                    isVisited[r2][c2] = true;
                }
            }
        }
        return true; // 거리두기 지킴
    }

    // 사람이 앉은 자리인지
    private boolean isPerson(int r, int c) {
        return map[r][c] == 'P';
    }

    class Point {
        int r;
        int c;
        int cnt; //  사람과의 거리

        public Point(int r, int c, int cnt) {
            this.r = r;
            this.c = c;
            if (cnt < 0) { // 마이너스 된 경우 0으로 세팅해줌
                this.cnt = 0;
            } else {
                this.cnt = cnt;
            }
        }
    }

}