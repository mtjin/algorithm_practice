import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

class Main {
    private static int N; //수빈이 위치
    private static int K; //동생 위치
    private static boolean[] isVisited = new boolean[100001];
    private static int answer = Integer.MAX_VALUE;


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();
        bfs();
        System.out.println(answer);
    }

    static void bfs() {
        PriorityQueue<Point> queue = new PriorityQueue<>();
        queue.offer(new Point(N, 0));
        while (!queue.isEmpty()) {
            Point point = queue.poll();
            isVisited[point.pos] = true; //3가지케이스에 큐에 offer한다음에 방문처리하면 우선순위때문에 최소거리 바뀌는 경우 발생함
            if (point.pos == K) {
                answer = point.count;
            }
            if (point.pos * 2 <= 100000 && !isVisited[point.pos * 2]) { // 0초 순간이동
                queue.offer(new Point(point.pos * 2, point.count));
            }
            if (point.pos + 1 <= 100000 && !isVisited[point.pos + 1]) { //1초 한칸우측
                queue.offer(new Point(point.pos + 1, point.count + 1));
            }
            if (point.pos - 1 >= 0 && !isVisited[point.pos - 1]) { //1초 한칸좌측
                queue.offer(new Point(point.pos - 1, point.count + 1));
            }
        }
    }

    private static class Point implements Comparable<Point>{
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