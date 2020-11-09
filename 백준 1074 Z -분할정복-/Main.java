import java.util.Scanner;

class Main {
    private static int r;
    private static int c;
    private static int n;
    private static int count;
    private static int[] dx = {0, 1, 0, 1};
    private static int[] dy = {0, 0, 1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = (int)Math.pow(2, sc.nextInt());
        r = sc.nextInt();
        c = sc.nextInt();
        dfs(n, 0, 0);
    }

    private static void dfs(int num, int row, int col) {
        if(num == 2 ) {
            for (int i = 0; i < 4; i++) {
                int r2 = row + dy[i];
                int c2 = col + dx[i];
                if (r2 == r && c2 == c) {
                    System.out.println(count);
                    System.exit(0);
                }
                count++;
            }
            return;
        }
        dfs(num / 2, row, col);
        dfs(num / 2, row, col + num / 2); //우측
        dfs(num / 2, row + num / 2, col);  //하단
        dfs(num / 2, row + num / 2, col + num / 2); //대각선하단
    }
}