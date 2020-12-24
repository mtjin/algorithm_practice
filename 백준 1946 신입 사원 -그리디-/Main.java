import java.util.Arrays;
import java.util.Scanner;

class Main {
    private static Score[] scores;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 0; t < T; t++) {
            int N = sc.nextInt();
            int answer = 0;
            scores = new Score[N];
            for (int i = 0; i < N; i++) {
                int score1 = sc.nextInt();
                int score2 = sc.nextInt();
                scores[i] = new Score(score1, score2);
            }
            Arrays.sort(scores);
            int min = Integer.MAX_VALUE;
            for (Score score : scores) {
                int second = score.b;
                if (second < min) {
                    answer++;
                    min = second;
                }
            }
            System.out.println(answer);
        }
    }

    static class Score implements Comparable<Score> {
        int a;
        int b;

        public Score(int a, int b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public int compareTo(Score o) {
            return a - o.a;
        }
    }

}