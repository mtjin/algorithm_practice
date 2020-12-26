import java.util.Scanner;

class Main {
    private static boolean[] isVisited;
    private static int[] nums;
    private static int[] arr;
    private static int size;
    private static int answer = Integer.MAX_VALUE;
    private static String x;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        x = sc.next();
        size = x.length();
        isVisited = new boolean[x.length()];
        nums = new int[x.length()];
        arr = new int[x.length()];
        for (int i = 0; i < x.length(); i++) {
            nums[i] = x.charAt(i) - '0';
        }
        dfs(0);
        if (answer != Integer.MAX_VALUE) {
            System.out.println(answer);
        } else {
            System.out.println(0);
        }
    }

    private static void dfs(int depth) {
        if (depth == size) {
            int tmp = 0;
            int multiply = 1;
            for (int i = 0; i < size; i++) {
                if (isVisited[i]) {
                    tmp += (arr[i] * multiply);
                    multiply *= 10;
                }
            }
            if (tmp > Integer.parseInt(x)) answer = Math.min(answer, tmp);
            return;
        }
        for (int i = 0; i < size; i++) {
            if (!isVisited[i]) {
                isVisited[i] = true;
                arr[depth] = nums[i];
                dfs(depth + 1);
                isVisited[i] = false;
            }
        }
    }
}