public class Solution {
    public static void main(String[] args) {
        System.out.println(solution(15));
    }

    static public int solution(int n) {
        int answer = 0;
        int totalSum;
        int addNum;
        for (int i = 1; i <= n; i++) {
            totalSum = i;
            addNum = i;
            while (totalSum <= n) {
                if (totalSum == n) {
                    answer++;
                    break;
                }
                totalSum += (++addNum);
            }
        }
        return answer;

    }

}
