import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(); //최소힙
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> o2 - o1); //최대힙
        for (int i = 0; i < N; i++) {
            int n = Integer.parseInt(br.readLine());
            if (minHeap.size() == maxHeap.size()) { //두 힙에 번갈아 넣어줌
                maxHeap.offer(n);
            } else {
                minHeap.offer(n);
            }
            if (!minHeap.isEmpty() && !maxHeap.isEmpty()) {
                if (minHeap.peek() < maxHeap.peek()) {
                    //maxHeap의 최댓값이 minHeap의 최솟값 보다 큰 경우 균형을 맞추기 위해 swap
                    int tmp = minHeap.poll();
                    minHeap.offer(maxHeap.poll());
                    maxHeap.offer(tmp);
                }
            }
            System.out.println(maxHeap.peek());
        }
    }
}