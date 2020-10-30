import java.util.Arrays;
import java.util.Scanner;

class Main {
    static int[] nums;
    static int[] arr;
    static boolean[] isVisited;
    static int N;
    static int M;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        nums = new int[N];
        arr = new int[N];
        isVisited = new boolean[N];
        for (int i = 0; i < N; i++) {
            nums[i] = sc.nextInt();
        }
        Arrays.sort(nums);
        dfs(0);
        System.out.println(sb.toString());
    }

    private static void dfs(int count) {
        if (count == M) {
            for (int i = 0; i < M; i++) {
                sb.append(arr[i]).append(" ");
            }
            sb.append("\n");
            return;
        }
        for (int i = 0; i < N; i++) {
            if (!isVisited[i]) { // 방문안하고 현재값이 이전값보다 커야함
                if (count == 0 || (count > 0&& nums[i] > arr[count - 1])) {
                    isVisited[i] = true;
                    arr[count] = nums[i];
                    dfs(count + 1);
                    arr[count] = 0; //0으로 초기화
                    isVisited[i] = false;
                }
            }
        }
    }
}