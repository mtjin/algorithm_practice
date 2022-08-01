import java.util.Scanner;

public class Main {
    static StringBuilder sb = new StringBuilder();
    private static int M;
    private static int N;
    private static int[] nums;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        nums = new int[M+1];
        dfs(1);
        System.out.println(sb.toString());
    }

    private static void dfs(int depth) {
        if (depth > M) {
            for (int i = 1; i <= M; i++) {
                sb.append(nums[i]).append(" ");
            }
            sb.append("\n");
            return;
        }
        for (int i = 1; i <= N; i++) {
            nums[depth] = i;
            dfs(depth + 1);
        }
    }
}
