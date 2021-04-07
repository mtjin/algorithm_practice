import java.util.Scanner;

class Main {
    private static int N; // 10 ≤ N < 100,000
    private static int S;
    private static int left = 0;
    private static int right = 0;
    private static int answer = 100001;
    private static int sum = 0;
    private static int[] nums;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        S = sc.nextInt();
        nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = sc.nextInt();
        }
        while (true) {
            if (sum >= S) { //조건 만족
                sum -= nums[left];
                answer = Math.min(answer, (right - left)); // 부분합 최소 길이 갱신
                left++; // 왼쪽 포인터 오른쪽으로 이동
            } else if (right == N) { //끝 도달
                break;
            } else { // right포인터 오른쪽으로 이동
                sum += nums[right++];
            }
        }
        if (answer == 100001) {
            System.out.println(0);
        } else {
            System.out.println(answer);
        }
    }
}