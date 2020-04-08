class Solution {

    private static StringBuilder answer = new StringBuilder();
    private static int completeCnt = 0;
    static int max = 0;

    public String solution(String number, int k) {
        answer.append(number);
        while (completeCnt < k) {
            for (int i = 0; i < answer.length() - 1; i++) {
                if(answer.charAt(i) == 9){
                    continue;
                }
                if (answer.charAt(i) < answer.charAt(i + 1)) {
                    answer.deleteCharAt(i);
                    completeCnt++;
                    break;
                }
                if (i == answer.length() - 2) {
                    answer.deleteCharAt(i + 1);
                    completeCnt++;
                    break;
                }
            }
        }
        return answer.toString();
    }
}