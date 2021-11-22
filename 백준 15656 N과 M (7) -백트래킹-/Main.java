import java.util.Arrays;
import java.util.Scanner;

public class Main {
    private static int N;
    private static int M;
    private static int[] nums;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = sc.nextInt();
        }
        Arrays.sort(nums);
        dfs(0, new int[M]);
        System.out.println(sb.toString());
    }

    private static void dfs(int depth, int[] answers) {
        if (depth == M) {
            for (int i = 0; i < M; i++) {
                sb.append(answers[i]).append(" ");
            }
            sb.append("\n");
            return;
        }
        for (int i = 0; i < N; i++) {
            answers[depth] = nums[i];
            dfs(depth + 1, answers);
        }
    }
}
