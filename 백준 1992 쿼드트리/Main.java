import java.util.Scanner;

public class Main {
    private static int[][] map;
    private static StringBuilder sb = new StringBuilder();

    private static void dfs(int n, int x, int y) {
        if (n == 1) {
            if (map[y][x] == 1) {
                sb.append("1");
            } else {
                sb.append("0");
            }
            return;
        }
        if (isSame(n, x, y)) {
            return;
        }
        sb.append("(");
        dfs(n / 2, x, y);
        dfs(n / 2, x + n / 2, y);
        dfs(n / 2, x, y + n / 2);
        dfs(n / 2, x + n / 2, y + n / 2);
        sb.append(")");
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
            sb.append("0");
        } else {
            sb.append("1");
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        map = new int[size][size];
        for (int i = 0; i < size; i++) {
            String line = sc.next();
            for (int j = 0; j < line.length(); j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }
        dfs(size, 0, 0);
        System.out.println(sb.toString());
    }
}