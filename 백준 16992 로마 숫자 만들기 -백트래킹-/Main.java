import java.util.HashSet;
import java.util.Scanner;

public class Main {
    private static int N; // 로마 숫자 N개
    private static int[] nums = new int[]{1, 5, 10, 50};
    private static HashSet<Integer> set = new HashSet<>();


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        dfs(0, 0);
        System.out.println(set.size());
    }

    private static void dfs(int depth, int sum) {
        if (depth == N) {
            set.add(sum);
            return;
        }
        for (int i = 0; i < 4; i++) {
            dfs(depth + 1, sum + nums[i]);
        }
    }
}
