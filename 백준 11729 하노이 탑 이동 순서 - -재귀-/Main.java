import java.util.Scanner;

class Main {
    public static int answer = 0;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        move(n, 1, 2, 3);
        System.out.println(answer);
        System.out.println(sb);
    }

    static void move(int n, int from, int by, int to) {
        answer++;
        if (n == 1) {
            sb.append(from + " " + to + "\n");
        } else {
            move(n - 1, from, to, by);
            sb.append(from + " " + to + "\n");
            move(n - 1, by, from, to);
        }
    }
}