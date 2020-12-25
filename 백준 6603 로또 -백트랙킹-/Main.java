import java.util.Scanner;

class Main {
    private static int K;
    private static boolean[] isVisited;
    private static int[] nums;
    private static int[] lottos;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            K = sc.nextInt();
            if (K == 0) break;
            isVisited = new boolean[K];
            nums = new int[K];
            for (int i = 0; i < K; i++) {
                nums[i] = sc.nextInt();
            }
            lottos = new int[6];
            dfs(0,0);
            System.out.println();
        }

    }

    private static void dfs(int start, int depth) {
        if (depth == 6) {
            for (int i = 0; i < K; i++) {
                if (isVisited[i]) System.out.print(nums[i] + " ");
            }
            System.out.println();
            return;
        }
        for (int i = start; i < K; i++) {
            isVisited[i] = true;
            dfs(i + 1, depth + 1);
            isVisited[i] = false;
        }
    }

}