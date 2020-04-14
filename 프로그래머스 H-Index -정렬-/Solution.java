import java.util.Arrays;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solution(new int[]{1,1,1,1,1, 2, 4, 4, 7, 7,8, 12, 13}); // 13개
    }


    public int solution(int[] citations) {
        int answer = 0;
        int N = citations.length; // 논문의 수
        Arrays.sort(citations); // 정렬
        for (int i = 0; i < N; i++) {
            int cite = citations[i];
            int h = N - i;
            if (h <= cite) {
                answer = h;
                break;
            }
        }
        return answer;
    }
}