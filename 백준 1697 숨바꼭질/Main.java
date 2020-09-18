import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    private static int N; //수빈이 위치
    private static int M; //동생 위치
    private static int[] map = new int[100001];


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        bfs();
        System.out.println(map[M]);
    }

    static void bfs() {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(N);
        while (!queue.isEmpty()) {
            N = queue.poll();
            if (N == M) {
                break;
            }
            if (N - 1 >= 0 && map[N - 1] == 0) {
                queue.offer(N - 1);
                map[N - 1] = map[N] + 1;
            }
            if (N + 1 <= 100000 && map[N + 1] == 0) {
                queue.offer(N + 1);
                map[N + 1] = map[N] + 1;
            }
            if (N * 2 <= 100000 && map[N * 2] == 0) {
                queue.offer(N * 2);
                map[N * 2] = map[N] + 1;
            }
        }
    }


}