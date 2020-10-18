import java.util.Scanner;

public class Main {
    private static int[][] map;
    private static int zeroWhite = 0;
    private static int oneBlue = 0;

    private static void dfs(int n, int x, int y) {
        if (n == 1) {
            if (map[x][y] == 1) {
                oneBlue++;
            } else {
                zeroWhite++;
            }
            return;
        }
        if (isSame(n, x, y)) {
            return;
        }
        dfs(n / 2, x, y);
        dfs(n / 2, x + n / 2, y);
        dfs(n / 2, x, y + n / 2);
        dfs(n / 2, x + n / 2, y + n / 2);
    }

    public static boolean isSame(int n, int x, int y) {
        int first = map[x][y];
        for (int i = x; i < x + n; i++) {
            for (int j = y; j < y + n; j++) {
                if (first != map[i][j]) {
                    return false;
                }
            }
        }
        //해당 종이 하나로 퉁쳐서 +1
        if (first == 0) {
            zeroWhite += 1;
        } else {
            oneBlue += 1;
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
        System.out.println(zeroWhite);
        System.out.println(oneBlue);
    }
}