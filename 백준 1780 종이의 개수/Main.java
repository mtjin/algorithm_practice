import java.util.Scanner;

public class Main {
    private static int[][] map;
    private static int zero = 0;
    private static int one = 0;
    private static int minus1 = 0;

    private static void dfs(int n, int x, int y) {
        if (n == 1) {
            int num = map[y][x];
            if (num == -1) {
                minus1++;
            } else if (num == 0) {
                zero++;
            } else {
                one++;
            }
            return;
        }
        if (isSame(n, x, y)) {
            return;
        }
        dfs(n / 3, x, y);
        dfs(n / 3, x + n / 3, y);
        dfs(n / 3, x + 2 * n / 3, y);
        dfs(n / 3, x, y + n / 3);
        dfs(n / 3, x, y + 2 * n / 3);
        dfs(n / 3, x + n / 3, y + n / 3);
        dfs(n / 3, x + n / 3, y + 2 * n / 3);
        dfs(n / 3, x + 2 * n / 3, y + n / 3);
        dfs(n / 3, x + 2 * n / 3, y + 2 * n / 3);
    }

    private static boolean isSame(int n, int x, int y) {
        int first = map[y][x];
        for (int i = y; i < y + n; i++) {
            for (int j = x; j < x + n; j++) {
                if (first != map[i][j]) {
                    return false;
                }
            }
        }
        //해당 종이 하나로 압축
        if (first == 0) {
            zero++;
        } else if (first == 1) {
            one++;
        } else {
            minus1++;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        map = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                map[i][j] = sc.nextInt();
            }
        }
        dfs(size, 0, 0);
        System.out.println(minus1);
        System.out.println(zero);
        System.out.println(one);
    }
}