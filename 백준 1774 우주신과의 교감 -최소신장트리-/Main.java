import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Main {
    private static int[] parent;
    private static Space[] spaces;
    private static ArrayList<Space> spaceList = new ArrayList<>();
    private static double answer = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); //우주선의 개수
        int M = sc.nextInt(); //신들과의 통로의 개수
        parent = new int[N];
        spaces = new Space[N];
        for (int i = 0; i < N; i++) {
            parent[i] = i;
        }
        //황선자를 포함하여 우주신들의 좌표
        for (int i = 0; i < N; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            spaces[i] = new Space(x, y, 0);
        }
        //이미 연결된 통로
        for (int i = 0; i < M; i++) {
            int space1 = sc.nextInt();
            int space2 = sc.nextInt();
            union(space1-1, space2-1);
        }
        //edge 초기화
        for (int i = 0; i < spaces.length - 1; i++) {
            Space space1 = spaces[i];
            for (int j = i + 1; j < spaces.length; j++) {
                Space space2 = spaces[j];
                double weight = Math.sqrt(Math.pow(space1.x - space2.x, 2) + Math.pow(space1.y - space2.y, 2));
                spaceList.add(new Space(i, j, weight));
            }
        }
        //최소비용 오름차순 정렬
        Collections.sort(spaceList);
        //최소비용 탐색
        for (int i = 0; i < spaceList.size(); i++) {
            Space space = spaceList.get(i);
            if (!isSameParent(space.x, space.y)) {
                answer += space.weight;
                union(space.x, space.y);
            }
        }
        System.out.println(String.format("%.2f", answer));
    }

    private static void union(int x, int y) {
        x = find(x);
        y = find(y);
        if (x < y) parent[y] = x;
        else parent[x] = y;
    }

    private static boolean isSameParent(int x, int y) {
        return find(x) == find(y);
    }

    private static int find(int x) {
        if (parent[x] == x) return x;
        else return parent[x] = find(parent[x]);
    }

    private static class Space implements Comparable<Space> {
        int x; //x좌표이자 노드
        int y;
        double weight;

        public Space(int x, int y, double weight) {
            this.x = x;
            this.y = y;
            this.weight = weight;
        }

        @Override
        public int compareTo(Space o) {
            if (weight > o.weight) return 1;
            else return -1;
        }
    }

}