import java.util.Stack;

class Solution {
    public int solution(String s) {
        Stack<Character> stack = new Stack<>();
        int answer = 0;
        for (int i = 0; i < s.length(); i++) {
            if (!stack.isEmpty()) {  //비어있지 않으면 최근 단어와 비교해서 같으면 기존 단어와 새로들어오는거 모두 스택에서 제거
                if (stack.peek() == s.charAt(i)) {
                    stack.pop();
                }
            } else { //비어있는 경우 추가
                stack.push(s.charAt(i));
            }
        }
        if (stack.isEmpty()) { // 비어있다면 다 제거된거므로 답은 1
            answer = 1;

        }

        return answer;
    }
}