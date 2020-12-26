import java.util.Scanner;

class Main {
    private static boolean[] isVisited;
    private static int[] nums;
    private static int[] arr;
    private static int N;
    private static int answer = Integer.MIN_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        nums = new int[N];
        isVisited = new boolean[N];
        arr = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = sc.nextInt();
        }
        dfs(0);
        System.out.println(answer);
    }

    private static void dfs(int depth) {
        if (depth == N) {
            int tmp = 0;
            for (int i = 0; i < N - 1; i++) {
                tmp += Math.abs(arr[i] - arr[i + 1]);
            }
            answer = Math.max(answer, tmp);
            return;
        }
        for (int i = 0; i < N; i++) {
            if (!isVisited[i]) {
                isVisited[i] = true;
                arr[depth] = nums[i];
                dfs(depth + 1);
                isVisited[i] = false;
            }
        }
    }
}