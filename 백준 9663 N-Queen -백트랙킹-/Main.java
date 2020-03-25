import java.util.Scanner;

class Main {
    static int result = 0;
    static int N;

    /*
     *  int map[행인덱스(col)] = 열인덱스(row)
     * */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        // 첫번째 행 1...N열 차례대로 퀸 놓고 다음 행 호출
        for (int col = 1; col <= N; col++) {
            int[] map = new int[N + 1];
            map[1] = col;
            dfs(map, 1);
        }
        System.out.println(result);
    }

    static void dfs(int[] map, int col) {
        if (col == N) { // 마지막 행까지 탐색 완료
            result++;
        } else { // 해당 행의 열을 처음 부터 N 까지 차례대로 탐색
            for (int row = 1; row <= N; row++) {
                map[col + 1] = row;
                if (check(map, col + 1)) {
                    // 놓을 수 있는 경우 다음 행 검사
                    dfs(map, col + 1);
                }
            }
        }
    }

    // 퀸 놓을 수 있는 자린지 체크하는 함수
    static boolean check(int[] map, int col) {
        // 현재 퀸을 놓을려는 행의 이전 행들 차례대로 검사
        for (int i = 1; i < col; i++) {
            // 이전 행들에 같은 열에 퀸이 있는 경우
            if (map[i] == map[col]) {
                return false;
            }
            // 이전 행들에 대각선 공격 가능한 퀸이 있는 경우
            if (Math.abs(i - col) == Math.abs(map[i] - map[col])) {
                return false;
            }
        }
        return true;
    }
}