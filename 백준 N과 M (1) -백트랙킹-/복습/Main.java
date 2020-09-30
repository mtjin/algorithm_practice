import java.util.Scanner;

public class Main {
    static int N;
    static int M;
    static boolean[] isVisited;
    static int[] num;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        isVisited = new boolean[N + 1];
        num = new int[N + 1];
        dfs(1);

    }

    static void dfs(int current) {
        if (current > M) {
            for (int i = 1; i <= M; i++) {
                System.out.print(num[i] + " ");
            }
            System.out.println();
            return;
        }
        for (int i = 1; i <= N; i++) {
            if (isVisited[i]) {
                continue;
            }
            isVisited[i] = true;
            num[current] = i;
            dfs(current + 1);
            isVisited[i] = false;
        }
    }


}