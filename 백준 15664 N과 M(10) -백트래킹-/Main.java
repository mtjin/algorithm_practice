import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    private static int N;
    private static int M;
    private static int[] nums;
    private static StringBuilder sb = new StringBuilder(); //사용안하면 시간초과남
    private static Set set = new HashSet<String>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = sc.nextInt();
        }
        Arrays.sort(nums);
        boolean[] isVisited = new boolean[N];
        dfs(0, nums.clone(), isVisited);
        System.out.println(sb.toString());
    }

    private static void dfs(int depth, int[] arr, boolean[] isVisited) {
        if (depth == M) {
            StringBuilder sb2 = new StringBuilder();
            for (int i = 0; i < M; i++) {
                sb2.append(arr[i] + " ");
            }
            if(!set.contains(sb2.toString())) { //중복방지
                set.add(sb2.toString());
                sb.append(sb2.toString()).append("\n");
            }
            return;
        }
        int prev = -1;
        if (depth - 1 >= 0) {
            prev = arr[depth - 1];
        }
        for (int i = 0; i < N; i++) {
            if (prev <= nums[i] && !isVisited[i]) { // 오름차순의 경우만 + 중복되는 수열 여러번 출력 방지
                prev = nums[i];
                isVisited[i] = true;
                arr[depth] = prev;
                dfs(depth + 1, arr, isVisited);
                isVisited[i] = false;
            }
        }
    }
}