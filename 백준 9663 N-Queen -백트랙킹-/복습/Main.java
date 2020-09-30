import java.util.Scanner;

public class Main {
    static int n;
    static int result = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        for (int i = 1; i <= n; i++) {
            int[] num = new int[n + 1];
            num[1] = i;
            dfs(num, 1);
        }
        System.out.println(result);
    }

    static void dfs(int[] num, int row) {
        if (row == n) {
            result++;
            return;
        }
        for (int j = 1; j <= n; j++) {
            num[row + 1] = j;
            if (check(num, row + 1)) {
                dfs(num, row + 1);
            }
        }
    }

    static boolean check(int[] num, int row) {
        for (int i = 1; i < row; i++) {
            if (num[i] == num[row]) { //같은열존재
                return false;
            }
            if (Math.abs(i - row) == Math.abs(num[i] - num[row])) { //대각선존재
                return false;
            }
        }
        return true;
    }
}