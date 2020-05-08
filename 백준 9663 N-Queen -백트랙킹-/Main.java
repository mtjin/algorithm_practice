import java.util.Scanner;

class Main {
    static int result = 0;
    static int N;

    /*
     *  int map[열인덱스(col)] = 행인덱스(row)
     * */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        // 첫번째 행 1...N열 차례대로 퀸 놓고 다음 행 호출
        for (int row = 1; row <= N; row++) {
            int[] map = new int[N + 1];
            map[1] = row;
            dfs(map, 1);
        }
        System.out.println(result);
    }

    static void dfs(int[] map, int row) {
        if (row == N) { // 마지막 행까지 탐색 완료
            result++;
        } else { // 해당 행의 열을 처음 부터 N 까지 차례대로 탐색
            for (int col = 1; col <= N; col++) {
                map[row + 1] = col;
                if (check(map, row + 1)) {
                    // 놓을 수 있는 경우 다음 행 검사
                    dfs(map, row + 1);
                }
            }
        }
    }

    // 퀸 놓을 수 있는 자린지 체크하는 함수
    static boolean check(int[] map, int row) {
        // 현재 퀸을 놓을려는 행의 이전 행들 차례대로 검사
        for (int i = 1; i < row; i++) {
            // 이전 행들에 같은 열에 퀸이 있는 경우
            if (map[i] == map[row]) {
                return false;
            }
            // 이전 행들에 대각선 공격 가능한 퀸이 있는 경우
            if (Math.abs(i - row) == Math.abs(map[i] - map[row])) {
                return false;
            }
        }
        return true;
    }
}