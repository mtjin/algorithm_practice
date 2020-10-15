class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solution(6);
    }

    public int[] solution(int n) {
        int[] answer = {};
        int[][] arr = new int[n][n];
        int max = n * (n + 1) / 2; // 총 개수
        int top = 0; //상단
        int left = 0; //좌측
        int bottom = n - 1; //하단
        int right = n - 1; //우측
        int value = 1;
        while (max >= value) {
            for (int i = top; i <= bottom; i++) { // 하단이동
                if (max < value) break;
                arr[i][left] = value++;
            }
            if (max < value) break;
            top++;
            left++;
            for (int j = left; j <= right; j++) { // 우측이동
                if (max < value) break;
                arr[bottom][j] = value++;
            }
            if (max < value) break;
            bottom--;
            right--;
            int index = right;
            for (int i = bottom; i >= top; i--) { //상단 이동
                if (max < value) {
                    break;
                }
                arr[i][index--] = value++;
            }
            top++;
            right--;
        }
        answer = new int[max];
        int index = 0;
        for (int i=0; i<n; i++){
            for (int j=0; j<=i; j++){
                answer[index++] =  arr[i][j];
            }
        }
        return answer;
    }
}