import java.util.Scanner;

public class Main {
    private static int N; // 로마 숫자 N개
    private static int[] nums = new int[]{1, 5, 10, 50};
    private static boolean[] isVisited = new boolean[1001];
    private static int result = 0;


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        dfs(0, 0, 0);
        System.out.println(result);
    }

    private static void dfs(int depth, int index, int sum) {
        if (depth == N) {
            if (!isVisited[sum]) {
                isVisited[sum] = true;
                result++;
            }
            return;
        }
        for (int i = index; i < 4; i++) {
            // 중복탐색안되게끔 index 설정
            dfs(depth + 1, i, sum + nums[i]);
        }
    }
}
