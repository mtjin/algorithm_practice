import java.util.Scanner;

class Main {
    private static int G; // G개의 게이트
    private static int P; // P개의 게이트
    private static int[] parent;
    private static int answer = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        G = sc.nextInt();
        P = sc.nextInt();
        parent = new int[G + 1];
        for (int i = 1; i <= G; i++) {
            parent[i] = i;
        }
        for (int i = 1; i <= P; i++) {
            int gate = sc.nextInt(); // 게이트 번호
            int docking = find(gate); // 도킹될 번호 (0이면 더이상 도킹 불가하므로 폐쇄)
            if (docking == 0) break;
            answer++;
            union(docking, docking - 1); // 다음번 중복 도킹방지를 위해 자신보다 낮은번호로 도킹되게끔 Union (최종적으론 0을 바라봄)
        }
        System.out.println(answer);
    }

    private static void union(int x, int y) {
        x = find(x);
        y = find(y);
        if (x != y) {
            if (x < y) parent[y] = x;
            else parent[x] = y;
        }
    }

    private static int find(int x) {
        if (parent[x] == x) return x;
        else return parent[x] = find(parent[x]);
    }

}