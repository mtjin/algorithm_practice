class Solution {

    public int[] solution(String x) {
        int[] answer = new int[2];
        int removeCnt = 0; // 제거된 0의 모든 개수
        int convertCnt = 0; //변환 횟수

        while (!x.equals("1") && !x.equals("")) {
            // 1. x의 모든 0을 제거합니다.
            removeCnt += x.chars().filter(c -> c == '0').count();
            x = x.replaceAll("0", "");
            // 2. x의 길이를 c라고 하면, x를 "c를 2진법으로 표현한 문자열"로 바꿉니다.
            int c = x.length();
            StringBuilder str = new StringBuilder();
            while (c != 1) {
                str.insert(0, (c % 2));
                c = c / 2;
                if (c == 1) str.insert(0, 1);
            }
            x = str.toString();
            convertCnt++;
        }
        answer[0] = convertCnt;
        answer[1] = removeCnt;
        return answer;
    }
}