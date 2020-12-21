import java.util.PriorityQueue;
import java.util.Scanner;

class Main {
    private static int[] map = new int[100001];
    private static boolean[] isVisited = new boolean[100001];
    private static int K;
    private static int lastCnt = Integer.MAX_VALUE;
    private static int answerCount = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); //누나 위치
        K = sc.nextInt(); //동생 위치
        bfs(N);
        System.out.println(lastCnt);
        System.out.println(answerCount);
    }

    private static void bfs(int n) {
        PriorityQueue<Point> queue = new PriorityQueue<>();
        queue.add(new Point(n, 0));
        while (!queue.isEmpty()) {
            Point point = queue.poll();
            int pos = point.pos;
            int count = point.count;
            isVisited[pos] = true;
            if (pos == K && lastCnt >= count) {
                lastCnt = count;
                answerCount++;
                continue;
            }
            if (pos * 2 < 100001 && !isVisited[pos * 2]) {
                queue.offer(new Point(pos * 2, count + 1));
            }
            if (pos + 1 < 100001 && !isVisited[pos + 1]) {
                queue.offer(new Point(pos + 1, count + 1));
            }
            if (pos - 1 >=0 && !isVisited[pos - 1]) {
                queue.offer(new Point(pos - 1, count + 1));
            }
        }
    }

    static class Point implements Comparable<Point> {
        int pos;
        int count;

        public Point(int pos, int count) {
            this.pos = pos;
            this.count = count;
        }

        @Override
        public int compareTo(Point o) {
            return count - o.count;
        }
    }
}