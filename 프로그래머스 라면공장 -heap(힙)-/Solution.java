import java.util.Collections;
import java.util.PriorityQueue;

class Solution {
    public int solution(int stock, int[] dates, int[] supplies, int k) {
        int answer = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>(Collections.reverseOrder()); // 밀가루 많은 순으로 정렬
        int dateIndex = 0;

        // 끝나는날짜(k) 까지 반복
        for (int i = 0; i < k; i++) {
            // 지급할게 남아있고 밀가루 주는 날짜인 경우 밀가루 공급
            if (dateIndex < dates.length && dates[dateIndex] == i) {
                queue.offer(supplies[dateIndex]);
                dateIndex++;
            }
            // 남은 밀가루 0일 경우 공급받기
            if (stock == 0) {
                stock += queue.poll();
                answer++;
            }
            // 하루마다 밀가루 -1
            stock--;
        }
        return answer;
    }
}