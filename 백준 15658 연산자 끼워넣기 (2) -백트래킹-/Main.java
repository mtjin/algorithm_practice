import java.util.Scanner;

public class Main {
    private static int N;
    private static int[] op = new int[4];
    private static int[] arr;
    private static int max = Integer.MIN_VALUE;
    private static int min = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        for (int i = 0; i < 4; i++) {
            op[i] = sc.nextInt();
        }
        dfs(1, op, arr[0]);
        System.out.println(max);
        System.out.println(min);
    }

    private static void dfs(int depth, int[] op, int result) {
        if (depth == N) {
            max = Math.max(max, result);
            min = Math.min(min, result);
            return;
        }
        for (int i = 0; i < 4; i++) {
            if (op[i] == 0) {
                continue;
            }
            op[i]--;
            switch (i) {
                case 0:
                    dfs(depth + 1, op, result + arr[depth]);
                    break;
                case 1:
                    dfs(depth + 1, op, result - arr[depth]);
                    break;
                case 2:
                    dfs(depth + 1, op, result * arr[depth]);
                    break;
                case 3:
                    dfs(depth + 1, op, result / arr[depth]);
                    break;
            }
            op[i]++;
        }
    }
}
