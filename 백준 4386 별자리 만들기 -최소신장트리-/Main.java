import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Main {
    private static int[] parent;
    private static ArrayList<Star> tmpList = new ArrayList<>();
    private static ArrayList<Star> starList = new ArrayList<>();
    private static float answer = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            double x = sc.nextDouble();
            double y = sc.nextDouble();
            tmpList.add(new Star(x, y, 0f));
        }
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        for (int i = 0; i < tmpList.size() - 1; i++) {
            Star star1 = tmpList.get(i);
            double x1 = star1.x;
            double y1 = star1.y;
            for (int j = i + 1; j < tmpList.size(); j++) {
                Star star2 = tmpList.get(j);
                double x2 = star2.x;
                double y2 = star2.y;
                double weight = Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
                starList.add(new Star(i, j, weight));
            }
        }
        Collections.sort(starList);
        for (int i = 0; i < starList.size(); i++) {
            Star star = starList.get(i);
            if (!isSameParent((int) star.x, (int) star.y)) {
                answer += star.weight;
                union((int) star.x, (int) star.y); //연결
            }
        }
        System.out.println(Math.round(answer*100)/100.0);
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

    private static boolean isSameParent(int x, int y) {
        x = find(x);
        y = find(y);
        return x == y;
    }

    static class Star implements Comparable<Star> {
        double x; //처음엔 x좌표로 사용하고 이후 시작 지점으로 사용
        double y;
        double weight;

        public Star(double x, double y, double weight) {
            this.x = x;
            this.y = y;
            this.weight = weight;
        }

        @Override
        public int compareTo(Star o) {
            return Double.compare(weight, o.weight);
        }
    }

}