class Solution {
    private static int answer = 0;
    private static boolean[][][][] isVisited = new boolean[11][11][11][11]; // (x,y) -> (x,y) 로 이동한 적 있는지
    private static int x, y; //현재좌표
    private static int x2, y2; //이동할좌표
    private static int[] dx = {-1, 0, 1, 0};
    private static int[] dy = {0, -1, 0, 1};

    public int solution(String dirs) {
        x = 5;
        y = 5;
        x2 = 5;
        y2 = 5;
        for (char move : dirs.toCharArray()) {
            x = x2;
            y = y2;
            if (move == 'L') { //좌하우상
                x2 = x + dx[0];
                y2 = y + dy[0];
            } else if (move == 'D') {
                x2 = x + dx[1];
                y2 = y + dy[1];
            } else if (move == 'R') {
                x2 = x + dx[2];
                y2 = y + dy[2];
            } else {
                x2 = x + dx[3];
                y2 = y + dy[3];
            }

            //범위벗어난거처리
            if (x2 < 0 || x2 > 10 || y2 < 0 || y2 > 10) {
                //이동하기 전 좌표로 바꿔줌
                x2 = x;
                y2 = y;
                continue;
            }

            //이동가능한 좌표, 첫방문이면 답 +1
            if (!isVisited[x][y][x2][y2]) {
                isVisited[x][y][x2][y2] = true;
                isVisited[x2][y2][x][y] = true;
                answer++;
            }
        }

        return answer;
    }
}