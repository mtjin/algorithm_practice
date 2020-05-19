import java.util.Stack

internal class Solution {

    fun solution(arrangement: String): Int {
        var answer = 0
        val stack = Stack<Char>()
        for ((i, c) in arrangement.toCharArray().withIndex()) {
            if (c == '(') {
                stack.add(c)
            } else {
                stack.pop()
                if (arrangement[i - 1] == '(') { // 왼쪽 막대기 잘려야할 개수, 이전께 '(' 일 경우 레이저의 왼쪽부분 잘리는 개수를 더함
                    answer += stack.size
                } else { // 오른쪽 막대기 잘리는 부분 하나 증가 ,이전께 ')' 일 경우에 한개 더잘림
                    answer++
                }
            }
        }
        return answer
    }
}