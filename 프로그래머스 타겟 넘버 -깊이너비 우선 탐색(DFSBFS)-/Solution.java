class Solution {
    private static int target;
    private static int size;
    private static int answer = 0;
    private static int[] numbers;

    public static void dfs(int n, int count) {
        if (count == size-1) {
            if (n == target) {
                answer++;
            }
        } else {
            dfs(n + numbers[count+1], count + 1);
            dfs(n + (numbers[count+1]*-1), count + 1);
        }
    }

    public int solution(int[] numbers, int target) {
        size = numbers.length; //5
        Solution.target = target; //3
        Solution.numbers = numbers;
        dfs(numbers[0], 0); // 1
        dfs(numbers[0]*-1, 0); // -1
        return answer;
    }
}