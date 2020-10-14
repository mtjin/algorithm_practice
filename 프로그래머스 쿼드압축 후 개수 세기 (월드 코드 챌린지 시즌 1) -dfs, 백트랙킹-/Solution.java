class Solution {
    private static int[][] map;
    private static int zero = 0;
    private static int one = 0;

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solution(new int[][]{{1, 1, 0, 0}, {1, 0, 0, 0}, {1, 0, 0, 1}, {1, 1, 1, 1}});
    }

    private static void dfs(int n, int x, int y) {
        if (n == 1) { // 한개인 경우 해당 값 +
            if (map[x][y] == 1) {
                one++;
            } else {
                zero++;
            }
            return;
        }
        if (isSame(n, x, y)) { //같은값인지 압축 가능한지
            return;
        }
        //4개 분리 탐색
        dfs(n / 2, x, y);
        dfs(n / 2, x + n / 2, y);
        dfs(n / 2, x, y + n / 2);
        dfs(n / 2, x + n / 2, y + n / 2);
    }

    public static boolean isSame(int n, int x, int y) {
        int first = map[x][y];
        for (int i = x; i < x + n; i++) {
            for (int j = y; j < y + n; j++) {
                if (first != map[i][j]) {
                    return false;
                }
            }
        }
        //압축 가능하면 해당 값 +1
        if (first == 0) {
            zero += 1;
        } else {
            one += 1;
        }
        return true;
    }

    public int[] solution(int[][] arr) {
        int[] answer = new int[2];
        map = arr;
        dfs(arr.length, 0, 0);
        answer[0] = zero;
        answer[1] = one;
        return answer;
    }

}