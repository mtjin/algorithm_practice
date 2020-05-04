public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solution(5000);
    }
    public int solution(int n) {
        int ans = 0;
        while (n != 0){ // 0이 될때까지 반복
            ans += n%2; //슈트쓴 경우 건전지 사용 X, 아닌 경우 점프해야하므로 건전지 + 1
            n /= 2; // 남은거리/2
        }
        return ans;
    }
}