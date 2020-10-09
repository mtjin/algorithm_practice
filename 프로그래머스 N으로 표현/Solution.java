class Solution {

    private static int N;
    private static int number;
    private static int answer = 9;

    static private void dfs(int count, int prev) {
        if (count > 8) {
            answer = -1;
            return;
        }
        if (number == prev && answer > count) { //답과 같고 최소의 답인 경우
            answer = count;
            return;
        }
        int n2 = N;
        for (int i = 0; i < 8 - count; i++) { // 남은 최소 개수만큼  5, 55,555... 사칙연산 경우의 수 모두 탐색
            dfs(count + i + 1, prev + n2);
            dfs(count + i + 1, prev - n2);
            dfs(count + i + 1, prev * n2);
            dfs(count + i + 1, prev / n2);
            n2 += N * (Math.pow(10, i + 1)); //5, 55, 555, 5555..
        }
    }

    public int solution(int N, int number) {
        Solution.N = N;
        Solution.number = number;
        dfs(0, 0);
        if (answer == 9) answer = -1;
        return answer;
    }
}