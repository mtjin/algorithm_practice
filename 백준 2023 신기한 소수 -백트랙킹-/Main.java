import java.util.Scanner;

class Main {
    private static int N;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        dfs("", 0);
        System.out.println(sb.toString());
    }

    private static void dfs(String num, int depth) {
        if (depth == N) {
            sb.append(num).append("\n");
            return;
        }
        for (int i = 1; i <= 9; i++) {
            int currentNum = Integer.parseInt(num + i);
            if (isPrime(currentNum)) {
                dfs(currentNum + "", depth + 1);
            }
        }

    }

    private static boolean isPrime(int n) {
        // 0, 1
        if (n < 2) return false;
        // 2
        if (n == 2) return true;

        for (int i = 2; i < n; i++) {
            // 소수 X
            if (n % i == 0) return false;
        }
        return true;
    }


}