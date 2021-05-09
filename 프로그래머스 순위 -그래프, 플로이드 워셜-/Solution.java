class Solution {
    private static int[][] weights;

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solution(5, new int[][]{{4, 3}, {4, 2}, {3, 2}, {1, 2}, {2, 5}});
    }

    public int solution(int n, int[][] results) {
        int answer = 0;
        weights = new int[n + 1][n + 1];
        for (int i = 0; i < results.length; i++) {
            int win = results[i][0];
            int lose = results[i][1];
            weights[win][lose] = 1; //이김
            weights[lose][win] = -1; //짐
        }
        floyd(n);
        for (int i = 1; i <= n; i++) {
            int cnt = 0;
            for (int j = 1; j <= n; j++) {
                if ((weights[i][j] != 0 || weights[j][i] != 0) && i != j) { // 해당 선수가 타 선수와의 승패를 아는 경우
                    cnt++;
                }
            }
            if (cnt == n - 1) answer++; // 자신을 제외한 타선수와의 승패결과를 모두 아는 경우 순위확정 + 1
        }
        System.out.println(answer);
        return answer;
    }

    private void floyd(int n) {
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (weights[i][k] == weights[k][j] && weights[i][k] != 0) { //서로 비교할 수 있는 경우
                        weights[i][j] = weights[i][k]; // i>k>j OR i<k<j 이므로 i,k 의 대소관계도 알 수 있게된다.
                    }
                }
            }
        }
    }
}