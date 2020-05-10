import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public static char[][] map;
    public static boolean[][] isVisited;
    public static int answer = 0;
    public static int m;
    public static int n;
    static boolean isBombFlag;
    private static int[] dx = {0, 1, 0, 1};
    private static int[] dy = {0, 0, 1, 1};

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solution(3, 2, new String[]{"AA", "AA", "AB"});
    }

    // 2x2 터질 곳 있는지 체크
    public static boolean checkBomb(int x, int y) {
        char block = map[x][y];
        if (block == '0') {
            return false;
        }
        for (int i = 0; i < 4; i++) {
            int x2 = x + dx[i];
            int y2 = y + dy[i];
            if (block != map[x2][y2]) {
                return false;
            }
        }
        isBombFlag = true; // 터트릴수 있음
        for (int i = 0; i < 4; i++) { //이미 터트린 폭탄을 제외한 2x2 폭탄 제거
            int x2 = x + dx[i];
            int y2 = y + dy[i];
            if (!isVisited[x2][y2]) {
                answer++; // 제거 개수 추가
            }
            isVisited[x2][y2] = true;
        }
        return true;
    }

    // 터진 곳 폭탄 값으로 변경
    public static void changeBomb() {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (isVisited[i][j]) {
                    map[i][j] = '0';
                }
            }
        }
    }

    // 폭탄으로 인한 맵 조정
    public static void arrange() {
        ArrayList<Queue> list = new ArrayList<>();
        // 한줄 세로로 아래에서 위 순으로 프렌즈블록만 하나씩 불러옴
        for (int j = 0; j < n; j++) {
            // 처음에 이걸 리스트에 list 밑에 생성하고 이부분에 queue.clear() 하는 식으로 했는데
            // 그러면 list에 이미 들어가 있는 큐도 똑같이 값이 바뀌어 이상해진다. (얕은복사여서 그렇다 주의)
            Queue<Character> queue = new LinkedList();
            for (int i = m - 1; i >= 0; i--) {
                if (map[i][j] != '0') { //폭탄아니면 큐에 삽입
                    queue.offer(map[i][j]);
                }
            }
            list.add(queue);
        }
        // 맵 재조정
        for (int j = 0; j < n; j++) {
            for (int i = m - 1; i >= 0; i--) {
                Queue queue2 = list.get(j);
                if (!queue2.isEmpty()) {
                    map[i][j] = (char) queue2.poll();
                } else {
                    map[i][j] = '0';
                }
            }
        }
    }

    public int solution(int m, int n, String[] board) {
        Solution.m = m;
        Solution.n = n;
        map = new char[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = board[i].charAt(j);
            }
        }
        while (true) { //터지는 폭탄이 없을때 까지 반복
            isVisited = new boolean[m][n];
            isBombFlag = false;
            for (int i = 0; i < m - 1; i++) {
                for (int j = 0; j < n - 1; j++) {
                    checkBomb(i, j);
                }
            }
            changeBomb();
            if (!isBombFlag) { //터진 폭탄없으면 끝
                break;
            }
            arrange();
        }
        return answer;
    }
}