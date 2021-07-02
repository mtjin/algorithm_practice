import java.util.Scanner;

class Main {
    private static int N;
    private static int[] parent;

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        parent = new int[N + 1];
        // 1, 초기화
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }
        // 2. 유니온
        for (int i = 0; i < N - 2; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            union(start, end);
        }
        // 3. 다리 체크 및 이어주기
        for (int i = 2; i <= N; i++) {
            if (!isSameParent(1, i)) {
                System.out.print(1 + " " + i);
                return;
            }
        }
    }

    private static void union(int x, int y) {
        x = find(x);
        y = find(y);
        if (x != y) {
            if (x < y) parent[y] = x;
            else parent[x] = y;
        }
    }

    private static boolean isSameParent(int x, int y) {
        return find(x) == find(y);
    }

    private static int find(int x) {
        if (parent[x] == x) {
            return x;
        } else {
            return parent[x] = find(parent[x]);
        }
    }
}