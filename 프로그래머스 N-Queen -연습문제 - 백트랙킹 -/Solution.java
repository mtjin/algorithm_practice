class Solution {
    public static int N;
    public static int answer = 0;

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solution(8);
    }
    public static void dfs(int[] map, int row) {
        if (row == N) { //마지막행까지 다 놓은 경우
            answer++;
        } else {
            for (int col = 1; col <= N; col++) {
                map[row + 1] = col;
                if (check(map, row + 1)) {
                    // 놓을 수 있는 자리인 경우 다음행으로 재귀
                    dfs(map, row+1);
                }
            }
        }
    }

    public static boolean check(int[] map, int row) {
        for (int i = 1; i < row; i++) { // 이전 행들 반복문
            // 이전행의 같은 열에 체스가 있었는지
            if (map[i] == map[row]) {
                return false;
            }
            //대각선 공격 가능한지
            if (Math.abs(i - row) == Math.abs(map[i] - map[row])) {
                return false;
            }
        }
        return true;
    }

    public int solution(int n) {
        N = n;
        for (int i = 1; i <= n; i++) {
            int[] map = new int[n + 1];
            map[1] = i;
            dfs(map, 1);
        }
        return answer;
    }
}