class Solution {
    private static int[][] map;
    private static boolean[] isVisited;
    private static int n;
    private static int answer = 0;

    private static void dfs(int start) {
        if (isVisited[start]) {
            return;
        }
        isVisited[start] = true;
        for (int j = 0; j < n; j++) {
            if (map[start][j] == 1 && isVisited[j] == false) {
                dfs(j);
                answer--; // 붙어 있는거면 전체 네트워크 개수 - 1
            }
        }
    }

    public int solution(int n, int[][] computers) {
        Solution.n = n;
        map = new int[n][n];
        isVisited = new boolean[n];
        answer = n;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = computers[i][j];
            }
        }
        for (int i = 0; i < n; i++) {
            dfs(i);
        }
        System.out.println(answer);
        return answer;
    }
}