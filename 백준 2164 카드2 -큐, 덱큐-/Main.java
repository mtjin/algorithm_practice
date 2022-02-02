import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        Deque<Integer> deque = new ArrayDeque<>();
        // 1. 초기화
        for (int i = 1; i <= N; i++) {
            deque.add(i);
        }
        // 한 장 남을때까지 반복
        while (deque.size() > 1) {
            // 2. 맨 위 카드 버리기
            deque.pollFirst();
            // 3. 맨 위 카드 맨밑으로 옮기기
            deque.offerLast(deque.pollFirst());
        }
        // 마지막 카드 정답 출력
        System.out.println(deque.poll());
    }
}
