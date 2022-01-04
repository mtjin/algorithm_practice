import java.util.Scanner;

public class Main {
    private static int N;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        boolean[] isVisited = new boolean[N+1];
        dfs(0, isVisited, new int[N]);
    }

    private static void dfs(int depth, boolean[] isVisited, int[] nums) {
        if (depth == N) {
            for (int i = 0; i < nums.length; i++) {
                System.out.print(nums[i] + " ");
            }
            System.out.println();
            return;
        }
        for (int i = 1; i <= N; i++) {
            if (!isVisited[i]) {
                isVisited[i] = true;
                nums[depth] = i;
                dfs(depth + 1, isVisited, nums);
                isVisited[i] = false;
            }
        }
    }


}
