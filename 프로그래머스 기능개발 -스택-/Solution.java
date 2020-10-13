import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Solution {

    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> queue = new LinkedList<>();
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < progresses.length; i++) {
            int day = (int) Math.ceil((double)(100 - progresses[i]) / speeds[i]);
            queue.offer(day);
        }
        int prev = queue.poll();
        int count = 1;
        while (!queue.isEmpty()) {
            int now = queue.poll();
            if (prev >= now) {
                count++;
            } else {
                result.add(count);
                count = 1;
                prev = now;
            }
        }
        result.add(count);
        int[] answer = new int[result.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = result.get(i);
        }
        return answer;
    }
}