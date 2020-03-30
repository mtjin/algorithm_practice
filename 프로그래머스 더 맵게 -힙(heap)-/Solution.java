import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solution(new int[]{1, 2, 3, 9, 10, 12}, 7);
    }

    public int solution(int[] scoville, int K) {
        int answer = 0;
        Queue<Integer> queue = new PriorityQueue<>();
        for (int i : scoville) {
            queue.add(i);
        }
        if (queue.size() == 1) {
            if (queue.peek() >= K) {
                return 0;
            } else {
                return -1;
            }
        }
        while (queue.peek() < K && queue.size() >= 2) {
            int a = queue.poll();
            int b = queue.poll();
            int newScob = a +(b* 2);
            queue.add(newScob);
            answer++;
        }
        if (queue.peek() < K) {
            return -1;
        }
        System.out.println(answer);
        return answer;
    }
}