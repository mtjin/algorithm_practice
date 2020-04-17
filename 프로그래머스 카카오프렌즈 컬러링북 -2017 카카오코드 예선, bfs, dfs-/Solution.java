import java.util.*;

class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solution(6, 4, new int[][]{{1, 1, 1, 0}, {1, 2, 2, 0}, {1, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 3}, {0, 0, 0, 3}});
    }

    public static int[] dx;
    public static int[] dy;
    public static int[][] map;
    public static boolean[][] visited;
    public static ArrayList<Integer> biggestSizeResult; // 모든 영역크기 리스트
    public static int domainCountResult; // 영역의 수

    public int[] solution(int m, int n, int[][] picture) {
        int[] answer = new int[2];
        dx = new int[]{-1, 0, 1, 0};
        dy = new int[]{0, -1, 0, 1};
        biggestSizeResult = new ArrayList<>();
        domainCountResult = 0;

        map = new int[m + 2][n + 2];
        visited = new boolean[m + 2][n + 2];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                map[i + 1][j + 1] = picture[i][j];
            }
        }

        //모든 배열 인덱스 시작점으로 탐색
        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (map[i][j] != 0 && visited[i][j] == false) { //영역 결과값 추출
                    bfs(i, j);
                    domainCountResult++;
                }
            }
        }

        //지금까지의 영역수 오름차순 정렬
        Collections.sort(biggestSizeResult, Comparator.reverseOrder());
        //결과 세팅
        answer[0] = domainCountResult;
        answer[1] = biggestSizeResult.get(0);
        System.out.println(answer[0] + " " + answer[1]);
        return answer;
    }

    public static void bfs(int x, int y) {
        int totalSize = 1;
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(x, y));
        visited[x][y] = true;
        while (!queue.isEmpty()) {
            Point point = queue.poll();
            for (int i = 0; i < 4; i++) {
                int x2 = point.x + dx[i];
                int y2 = point.y + dy[i];
                if ((map[x2][y2] == map[x][y]) && visited[x2][y2] == false) { //방문 안하고 이전값과 같으면 추가(동일한 색인 경우)
                    visited[x2][y2] = true;
                    totalSize++;
                    queue.offer(new Point(x2, y2));
                }
            }
        }
        // 최고 영역 크기값 추출 (추후 정렬)
        biggestSizeResult.add(totalSize);
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