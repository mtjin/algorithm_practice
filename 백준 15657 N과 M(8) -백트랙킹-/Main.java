import java.util.Arrays;
import java.util.Scanner;

class Main {
    static int N;
    static int M;
    static int[] nums;
    static boolean[] isVisited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        nums = new int[N];
        isVisited = new boolean[N];
        for (int i = 0; i < N; i++) {
            nums[i] = sc.nextInt();
        }
        Arrays.sort(nums);
        int[] answer = new int[M];
        Arrays.fill(answer, -1);
        dfs(0, answer, -10);
    }

    static void dfs(int count, int[] answer, int prev) {
        if (count == M) {
            for (int i = 0; i < M; i++) {
                System.out.print(answer[i] + " ");
            }
            System.out.println();
            return;
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < answer.length; j++) {
                if (answer[j] == -1 && prev <= nums[i]) {
                    answer[j] = nums[i];
                    dfs(count + 1, answer, answer[j]);
                    answer[j] = -1;
                    break;
                }

            }
        }
    }

}