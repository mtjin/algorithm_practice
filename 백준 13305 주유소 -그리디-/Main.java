import java.util.Scanner;

class Main {
    private static int N; // 도시의 개수
    private static long[] distances; // 거리
    private static long[] costs; // 비용
    private static long sum = 0; // 총 비용 (답)

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        distances = new long[N - 1];
        costs = new long[N];
        for (int i = 0; i < N - 1; i++) {
            distances[i] = sc.nextLong();
        }
        for (int i = 0; i < N; i++) {
            costs[i] = sc.nextLong();
        }
        //첫번째 도시 출발지점 초기화
        long minCost = costs[0];
        sum = minCost * distances[0];
        //두번째도시 ~~ 마지막도시
        for (int i = 1; i < N - 1; i++) {
            if (costs[i] < minCost) { //최소 기름값 업데이트
                minCost = costs[i];
            }
            sum += minCost * distances[i];
        }
        System.out.println(sum);
    }
}