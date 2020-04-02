import java.util.Scanner;

class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] R = new int[N + 1];
        int[] G = new int[N + 1];
        int[] B = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            R[i] = sc.nextInt();
            G[i] = sc.nextInt();
            B[i] = sc.nextInt();
        }
        for (int i = 1; i < N; i++) {
            R[i + 1] += Math.min(G[i], B[i]);
            G[i + 1] += Math.min(R[i], B[i]);
            B[i + 1] += Math.min(R[i], G[i]);
        }
        System.out.println(Math.min(Math.min(R[N], G[N]), B[N]));
    }


}