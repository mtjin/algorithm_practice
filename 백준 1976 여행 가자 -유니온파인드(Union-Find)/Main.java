import java.io.FileOutputStream;
import java.util.Scanner;

class Main {
    private static int[] parent;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); //도시의 수
        int M = sc.nextInt(); //여행계획 수
        parent = new int[N+1]; // [해당노드] = 최상위부모값
        for (int i=0; i<N; i++){
            parent[i] = i;
        }
        for (int i = 1; i <= N; i++) { //경로잇기
            for (int j = 1; j <= N; j++) {
                int flag = sc.nextInt(); // 방문 여부
                if (flag == 1) { //방문이라면 연결
                    union(i, j);
                }
            }
        }
        //여행 계획
        int prev = sc.nextInt();
        for (int i = 0; i < M-1; i++) {
            if (!isSameParent(prev,sc.nextInt())){
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");
    }

    private static void union(int x, int y) {
        x = find(x);
        y = find(y);
        if (x != y) {
            parent[y] = x;
        }
    }

    private static int find(int x) {
        if (parent[x] == x) {
            return x;
        } else {
            return parent[x] = find(parent[x]);
        }
    }

    private static boolean isSameParent(int x, int y) {
        x = find(x);
        y = find(y);
        return x == y;
    }
}