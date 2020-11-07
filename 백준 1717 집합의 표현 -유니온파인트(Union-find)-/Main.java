import java.util.Scanner;

class Main {
    private static int[] parent;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        parent = new int[n + 1]; // [해당노드] = 최상위부모값
        for (int i = 1; i <= n; i++) { //Disjoint-set 만들어줌(상호배타적집합)
            parent[i] = i;
        }
        for (int i = 0; i < m; i++) {
            int flag = sc.nextInt();
            int a = sc.nextInt();
            int b = sc.nextInt();
            if (flag == 0) {
                union(a, b);
            } else {
                if(isSameParent(a,b)){
                    System.out.println("YES");
                }else {
                    System.out.println("NO");
                }
            }
        }
    }

    private static boolean isSameParent(int x, int y) {
        x = find(x);
        y = find(y);
        return x == y;
    }

    private static void union(int x, int y) {
        x = find(x);
        y = find(y);
        if (x != y) { //서로 최상위부모값이 다르면 합쳐준다,
            parent[y] = x;
        }
    }

    private static int find(int x) { //최상위 부모값을 찾는다
        if (x == parent[x]) {
            return x;
        } else {
            return parent[x] = find(parent[x]);
        }
    }
}