import java.util.Scanner;

class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] house = new int[N + 1][3]; //2차원배열 RGB

        for (int i = 1; i <= N; i++) {
            house[i][0] = sc.nextInt(); //R
            house[i][1] = sc.nextInt(); //R
            house[i][2] = sc.nextInt(); //R
        }
        for (int i = 1; i < N; i++) {
            house[i + 1][0] += Math.min(house[i][1], house[i][2]);
            house[i + 1][1] += Math.min(house[i][0], house[i][2]);
            house[i + 1][2] += Math.min(house[i][0], house[i][1]);
        }
        System.out.println(Math.min(Math.min(house[N][0], house[N][1]), house[N][2]));
    }


}